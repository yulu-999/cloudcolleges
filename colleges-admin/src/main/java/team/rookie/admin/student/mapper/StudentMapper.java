package team.rookie.admin.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import team.rookie.api.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * @author ShiJie
 * @desc
 * @time 2021-06-23-14:20
 */

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    // 分页查询
    @Select("SELECT *  FROM student  WHERE student_name LIKE  '%${content}%' or number LIKE '%${content}%' LIMIT #{page},#{limit}")
    List<Map<String, Object>> selectAllStudent(@Param("page") Integer page, @Param("limit") Integer limit, @Param("content") String content);



}
