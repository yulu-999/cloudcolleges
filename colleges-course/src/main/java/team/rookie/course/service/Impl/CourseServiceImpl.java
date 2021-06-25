package team.rookie.course.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.rookie.api.pojo.Course;
import team.rookie.api.pojo.CourseInfo;
import team.rookie.api.utils.ReturnMapUtil;
import team.rookie.course.myfeign.IAdminFeignService;
import team.rookie.course.mapper.CourseInfoMapper;
import team.rookie.course.mapper.CourserMapper;
import team.rookie.course.service.ICourseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO 课程业务层接口实现
 * @Author tran
 * @Date 2021/6/24 8:24
 * @Version 1.0
 **/
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private IAdminFeignService adminFeignService;

    @Autowired
    private CourserMapper courserMapper;


    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Override
    public Map<String, Object> selectAll(Integer page, Integer limit, String content) {
        // 验证参数
        if (page == null || page < 1) page = 1;
        if (limit == null) limit = 10;
        page = (page - 1) * limit;
        // 获取数据
        List<Map<String, Object>> maps = courserMapper.selectAllCourse(page, limit, content);
        //重新封装
        ArrayList<Map<String, Object>> dataList = new ArrayList<>();
        // 封装数据
        for (Map<String, Object> objectMap : maps) {
            HashMap<String, Object> data = new HashMap<>();
            Map<String, Object> teacher = adminFeignService.getTeacherById(objectMap.get("teacher_id")+"");
            if (teacher.get("data")!=null){
                data.put("teacher",teacher.get("data"));
            }else {
                data.put("teacher","获取失败");
            }
            data.put("courseId",objectMap.get("course_id"));
            data.put("courseName",objectMap.get("course_name"));
            data.put("max",objectMap.get("course_max"));
            data.put("school","河北软件职业技术学院");
            dataList.add(data);
        }
        return ReturnMapUtil.printf(0,"获取成功",dataList);
    }

    /**
     * @Desc  加入课程
     * @param token 学生token
     * @param id 课程id
     * @return
     */
    @Override
    public Map<String, Object> addCourse(String token, String id) {
        // 验证参数
        if (token==null||token.equals("")||id==null||id.equals("")){
            return  ReturnMapUtil.printf(-1,"缺少参数");
        }else {
            Map<String, Object> byID = adminFeignService.getTokenByID(token);
            // 服务出现异常
            if (!byID.get("code").toString().equals("200")){
                return byID;
            }else {

                String studentID = byID.get("data").toString();
                CourseInfo courseInfo = new CourseInfo();
                courseInfo.setCourseInfoId(IdUtil.simpleUUID());
                courseInfo.setStudentId(studentID);
                courseInfo.setCourseId(id);
                courseInfo.setBirth("2020-09-16");
//                courseInfo.setShow(1);
                // 加入课程
                courseInfoMapper.insert(courseInfo);
                return ReturnMapUtil.printf(0,"加成功");
            }
        }

    }

    /**
     * @Desc 创建课程
     * @param token 教师token
     * @param coname 课程名
     * @param comax 最大人数
     * @return
     */
    @Override
    public Map<String, Object> createCourse(String token, String coname, String comax) {
        // 验证参数
        if (token==null||token.equals("")||coname==null||coname.equals("")){
            return  ReturnMapUtil.printf(-1,"缺少参数");
        }else {
            Map<String, Object> byID = adminFeignService.getTokenByID(token);
            // 服务出现异常
            if (!byID.get("code").toString().equals("0")) {
                return byID;
            }else {
                // 获取教师id
                String id = byID.get("data").toString();
                Course course = new Course();
                course.setCourseId(IdUtil.simpleUUID());
                course.setCourseName(coname);
                course.setTeacherId(id);
                course.setCourseMax(comax==null?"200":comax);
                course.setCourseType("信息");
                course.setCourseStart(1);
                course.setCourseWeek("2");

                // 添加课程
                courserMapper.insert(course);
                // 返回数据
                return ReturnMapUtil.printf(0,"创建成功");
            }
        }
    }

    /**
     * @Desc 获取课程信息
     * @param id 课程id
     * @return
     */
    @Override
    public Map<String, Object> selectCourseById(String id) {
        if (id==null||id.equals("")){
            return ReturnMapUtil.printf(-1,"缺少参数");
        }else {
            //查询课程
            Course course = courserMapper.selectById(id);

            if (course==null){
                return ReturnMapUtil.printf(-1,"没有该课程");
            }
            else{
                HashMap<String, Object> data = new HashMap<>();
                data.put("courseId",course.getCourseId());
                data.put("courseName",course.getCourseName());
                data.put("max",course.getCourseMax());
                data.put("school","河北软件职业技术学院");
                Map<String, Object> teacher = adminFeignService.getTeacherById(course.getTeacherId());
                if (teacher.get("data")!=null){
                    data.put("tname",teacher.get("data"));
                }else {
                    data.put("tname","获取失败");
                }
                return ReturnMapUtil.printf(200,"获取成功",data);
            }


        }

    }

    @Override
    public Map<String, Object> selectCourseByToken(String token) {

        if (token==null ||token.equals("")){
            return ReturnMapUtil.printf(-1,"非法登录");
        }else {
            Map<String, Object> map = adminFeignService.getTokenByID(token);

            String id = map.get("data").toString();
            if (id==null){
                return ReturnMapUtil.printf(-1,"非法登录");
            }else {
                List<Map<String, Object>> mycourse = courserMapper.findMycourse(id);
                ArrayList<Map<String, Object>> data = new ArrayList<>();
                for (Map<String,Object> map1: mycourse) {
                        Map<String, Object> map2 = new HashMap<>();
                        map2.put("courseId",map1.get("course_id"));
                        map2.put("center",map1.get("courseinfo_id"));
                        map2.put("courseName",map1.get("course_name"));
                        map2.put("teacher",map1.get("teacher_id"));
                        map2.put("max",map1.get("course_max"));
                        map2.put("school","河北软件职业技术学院");
                        data.add(map2);
                }
                return ReturnMapUtil.printf(0,"获取成功",data);
            }
        }
    }
}
