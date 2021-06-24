package team.rookie.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import team.rookie.api.pojo.CourseInfo;

/**
 * @ClassName CouserInfoMapper
 * @Description TODO 课程信息 dao层
 * @Author tran
 * @Date 2021/6/24 8:53
 * @Version 1.0
 **/
@Mapper
public interface CourseInfoMapper extends BaseMapper<CourseInfo> {
}
