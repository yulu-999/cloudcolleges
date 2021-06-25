package team.rookie.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import team.rookie.api.pojo.Course;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CouserMapper
 * @Description TODO
 * @Author tran
 * @Date 2021/6/24 8:13
 * @Version 1.0
 **/
@Mapper
public interface CourserMapper extends BaseMapper<Course> {

    @Select("SELECT *  FROM course  WHERE course_name LIKE  '%${content}%'  LIMIT #{page},#{limit}")
    List<Map<String, Object>> selectAllCourse(@Param("page") Integer page, @Param("limit") Integer limit, @Param("content") String content);

    @Select("SELECT * FROM course LEFT JOIN courseinfo on course.course_id = courseinfo.course_id WHERE courseinfo.studnet_id=#{id}")
    List<Map<String, Object>> findMycourse(@Param("id") String id);
}
