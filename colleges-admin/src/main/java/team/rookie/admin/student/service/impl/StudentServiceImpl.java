package team.rookie.admin.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.rookie.admin.student.mapper.StudentMapper;
import team.rookie.admin.student.mapper.TeamClassMapper;
import team.rookie.admin.student.service.IStudentService;
import team.rookie.api.pojo.Student;
import team.rookie.api.utils.ReturnMapUtil;

import java.util.*;

/**
 * @author ShiJie
 * @desc 学生管理
 * @time 2021-06-23-14:18
 */
@Service
public class StudentServiceImpl implements IStudentService {

    // 注入 dao层
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeamClassMapper teamClassMapper;

    /**
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @Author tran
     * @Description //TODO  查询学生
     * @Date 14:31 2021/6/23
     * @Param [page, limit, content]
     */
    @Override
    public Map<String, Object> selectAll(Integer page, Integer limit, String content) {

        // 验证参数
        if (page == null || page < 1) page = 1;
        if (limit == null) limit = 10;
        page = (page - 1) * limit;
        //查询数据
        List<Map<String, Object>> studentList = studentMapper.selectAllStudent(page, limit, content);
        //响应给前端的封装
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        for (Map<String, Object> map : studentList) {
            HashMap<String, Object> studentMap = new HashMap<>();
            studentMap.put("studentId", map.get("studnet_id"));
            studentMap.put("studentName", map.get("student_name"));
            if (map.get("student_sex").toString().equals("1"))
                studentMap.put("studnetSex", "男");
            else
                studentMap.put("studnetSex", "女");
            studentMap.put("number", map.get("number"));
            if (map.get("cid") == null)
                studentMap.put("className", "还没有加入班级");
            else
                studentMap.put("className", teamClassMapper.selectById(map.get("cid").toString()).getTeacherName());
            studentMap.put("school", map.get("school"));
            //添加返回数据
            data.add(studentMap);
        }
        //返回数据
        return ReturnMapUtil.printf(0, studentMapper.selectCount(null), "获取成功", data);
    }

    /**
     * 根据id查询单条学生
     * @param studentId
     * @return
     */
    @Override
    public Map<String, Object> selectOne(Integer studentId) {
        //查询数据
        Student student = studentMapper.selectById(studentId);

        //响应给前端的封装
        if (student != null) {
            HashMap<String, Object> studentMap = new HashMap<>();
            studentMap.put("studentId", student.getStudentId());
            studentMap.put("studentName", student.getStudentName());

            if (student.getStudentSex()==1)
                studentMap.put("studnetSex", "男");
            else
                studentMap.put("studnetSex", "女");
            studentMap.put("number", student.getNumber());
            if (student.getCid() == null)
                studentMap.put("className", "还没有加入班级");
            else
                studentMap.put("className", teamClassMapper.selectById(student.getCid().toString()).getTeacherName());
            studentMap.put("school", student.getSchool());

            //返回数据
            return ReturnMapUtil.printf(0, "获取成功", studentMap);
        } else {
            //返回数据
            return ReturnMapUtil.printf(-1, "没有该学生");
        }

    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    public Map<String, Object> addOne(Student student) {

        student.setStudentId(UUID.randomUUID().toString());        //生成随机数作为xueshengid
        student.setSchool("河北软件职业技术学院");         //学校默认为河北软件职业技术学院
        studentMapper.insert(student);

        //返回数据
        return ReturnMapUtil.printf(0, "添加成功");
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public Map<String, Object> updateOne(Student student) {
        studentMapper.updateById(student);
        //返回数据
        return ReturnMapUtil.printf(0, "修改成功");
    }
}

