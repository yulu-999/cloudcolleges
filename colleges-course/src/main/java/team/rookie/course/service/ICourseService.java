package team.rookie.course.service;

import java.util.Map;

/**
 * @ClassName ICouarseService
 * @Description TODO 课程业务层接口
 * @Author tran
 * @Date 2021/6/24 8:10
 * @Version 1.0
 **/
public interface ICourseService {


    /**
     * @Desc  获取所有课程
     * @param page 页数
     * @param limit 每页大小
     * @param content 搜索内容
     * @return
     */
    Map<String, Object> selectAll(Integer page, Integer limit,String content);


    /**
     * @Desc 学生加入课程
     * @param token 学生token
     * @param id 课程id
     * @return
     */
    Map<String, Object> addCourse(String token,String id);


    /**
     * @Desc 创建课程
     * @param token 教师token
     * @param coname 课程名
     * @param comax 最大人数
     * @return
     */
    Map<String, Object> createCourse(String token ,String coname,String comax);


    /**
     * @Desc 查询课程 根据id
     * @param id 课程id
     * @return
     */
    Map<String, Object> selectCourseById(String id);

}
