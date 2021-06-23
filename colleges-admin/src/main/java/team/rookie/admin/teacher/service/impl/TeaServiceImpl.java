package team.rookie.admin.teacher.service.impl;
/**
 * @desc   教师模块的M层接口实现类
 * @author  zyf
 * @time    6-23
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.rookie.admin.teacher.mapper.TeaMapper;
import team.rookie.admin.teacher.service.ITeaService;
import team.rookie.admin.utils.IDUtil;
import team.rookie.api.pojo.Teacher;
import team.rookie.api.utils.ReturnMapUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TeaServiceImpl implements ITeaService {
    @Autowired
    public TeaMapper teaMapper;


    /**
     * @desc  教室模块的分页模糊查询
     * @param page
     * @param limit
     * @param content
     * @return
     */
    @Override
    public Map<String, Object> queryAll(Integer page, Integer limit, String content) {
        //参数验证
        if (page==null || page==0) page=1;
        if (limit==null) limit=10;
        page=(page-1)*limit;
        //查询数据
        List<Map<String, Object>> maps=teaMapper.queryAll(page,limit,content);
        //封装返回json数据
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            HashMap<String, Object> studentMap = new HashMap<>();
            studentMap.put("teacherId",map.get("teacher_id"));
            studentMap.put("teachertName",map.get("teacher_name"));
            //判断男女
            if (map.get("teacher_sex").toString().equals("1"))
                studentMap.put("teachertSex","男");
            else
                studentMap.put("teachertSex","女");
            studentMap.put("number",map.get("number"));

            studentMap.put("school",map.get("school"));
            //添加返回数据
            data.add(studentMap);
        }
        //返回数据
        return ReturnMapUtil.printf(0,teaMapper.selectCount(null),"获取成功",data);

    }

    /**
     * @desc  根据id修改信息
     * @param id
     * @param teacherName
     * @param teacherSex
     * @param number
     * @param password
     * @return
     */
    @Override
    public Map<String, Object> update(String id, String teacherName, String teacherSex, String number, String password) {

        //判断id是否为空
        if (id==null) {

            return ReturnMapUtil.printf(-1,"非法调用");
        }else {
            Teacher teacher = teaMapper.selectById(id);
            if (teacher==null){
                return ReturnMapUtil.printf(-2,"该教师不存在");
            }
        }
        Teacher teacher = new Teacher();
        teacher.setTeacherId(id);
        teacher.setTeacherName(teacherName);
        //判断性别
        if (teacherSex.equals('男')){
            teacher.setTeacherSex(1);
        }else {
            teacher.setTeacherSex(2);
        }
        teacher.setNumber(number);
        teacher.setPassword(password);

        //修改数据
        teaMapper.updateById(teacher);
        return ReturnMapUtil.printf(1,"修改成功");
    }

    /**
     * @desc  教师模块的添加
     * @param name
     * @param sex
     * @param number
     * @param password
     * @param school
     * @return
     */
    @Override
    public Map<String, Object> add(String name, Integer sex, String number, String password, String school) {
        //前台数据存入teacher
        Teacher teacher = new Teacher();
        teacher.setTeacherId(IDUtil.getID());
        teacher.setTeacherName(name);
        teacher.setNumber(number);
        teacher.setPassword(password);
        teacher.setSchool(school);
        teacher.setTeacherSex(sex);
        //添加数据
        teaMapper.insert(teacher);
        return ReturnMapUtil.printf(1,"添加成功");
    }
}
