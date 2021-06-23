package team.rookie.admin.teacher.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeaMapper {

    @Select("select * from teacher limit #{page},#{limit}")
    List<Map<String, Object>> query(@Param("page") Integer page,@Param("limit") Integer limit);

    @Select("select * from teacher")
    List<Map<String, Object>> queryAll();
}
