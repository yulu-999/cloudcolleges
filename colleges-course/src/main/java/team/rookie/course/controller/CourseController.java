package team.rookie.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.rookie.course.service.ICourseService;

import java.util.Map;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author tran
 * @Date 2021/6/24 9:09
 * @Version 1.0
 **/
@RestController
@CrossOrigin("*")
public class CourseController   {


    @Autowired
    private ICourseService iCourseService;

    /**
     * @Desc  获取全部
     * @param page 页数
     * @param limit 每页大小
     * @param content 搜索内容
     * @return
     */
    @RequestMapping("/course/all")
    public Map<String, Object> selectAll(Integer page, Integer limit, String content) {
        return iCourseService.selectAll(page,limit,content);
    }


    /**
     * @Desc  课程添加
     * @param token 学生token
     * @param id 课程id
     * @return
     */
    @RequestMapping("/course/add")
    public Map<String, Object> addCourse(String token, String id) {
        return iCourseService.addCourse(token,id);
    }

    /**
     * @Desc   创建课程
     * @param token 教师token
     * @param coname 课程姓名
     * @param comax 最大数
     * @return
     */
    @RequestMapping("/course/create")
    public Map<String, Object> createCourse(String token, String coname, String comax) {
        return iCourseService.createCourse(token,coname,comax);
    }

    /**
     * @Desc 获取课程根据id
     * @param id
     * @return
     */
    @RequestMapping("/course/byid")
    public Map<String, Object> selectCourseById(String id) {
        return iCourseService.selectCourseById(id);
    }



    @RequestMapping("/course/Bytoken")
    public Map<String, Object> selectCourseBytoken(String token){

        return iCourseService.selectCourseByToken(token);

    }
}



