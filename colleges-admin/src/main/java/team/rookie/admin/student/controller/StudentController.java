package team.rookie.admin.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.rookie.admin.student.service.IStudentService;
import team.rookie.api.pojo.Student;

import java.util.Map;

/**
 * @ClassName StudentController
 * @Description TODO 学生控制层
 * @Author tran
 * @Date 2021/6/23 14:47
 * @Version 1.0
 **/
@RestController
@CrossOrigin("*")
public class StudentController {


    // 注入studentService
    @Autowired
    private IStudentService iStudentService;


    /**
     * @Desc 查询所有学生
     * @param page 页数
     * @param limit 每页大小
     * @param content 搜索
     * @return
     */
    @RequestMapping("/studnet/all")
    public Map<String,Object> selectAll(Integer page, Integer limit, String content){
         return iStudentService.selectAll(page,limit,content);
    }

    /**
     * @Desc 根据id查询学生
     * @param studentId
     * @return
     */
    @RequestMapping("/studnet/byid")
    public Map<String, Object> selectByOne(Integer studentId){
        return iStudentService.selectOne(studentId);
    }


    /**
     * @desc 添加学生
     * @param student
     * @return
     */
    @RequestMapping("/student/add")
    public Map<String, Object> add(Student student){
        return iStudentService.addOne(student);
    }


    /**
     * @desc 修改学生信息
     * @param student
     * @return
     */
    @RequestMapping("/student/update")
    public Map<String, Object> update(Student student){
        return iStudentService.updateOne(student);
    }
}
