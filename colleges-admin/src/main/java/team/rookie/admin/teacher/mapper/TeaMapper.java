package team.rookie.admin.teacher.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import team.rookie.api.pojo.Teacher;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeaMapper extends BaseMapper<Teacher> {

    @Select("select * from teacher where number like '%${content}%' or teacher_name LIKE '%${content}%' limit #{page},#{limit}")
    List<Map<String, Object>> queryAll(@Param("page") Integer page, @Param("limit") Integer limit, @Param("content") String content);
}
