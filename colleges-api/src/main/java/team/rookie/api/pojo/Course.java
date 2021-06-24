package team.rookie.api.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName Course
 * @Description TODO 课程
 * @Author tran
 * @Date 2021/6/22 20:43
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("course")
public class Course {

    //课程id
    @TableId("course_id")
    private String courseId;
    //课程名字
    @TableField("course_name")
    private String courseName;
    //教师id
    @TableField("teacher_id")
    private String teacherId;
    //课程最大人数
    @TableField("course_max")
    private String courseMax;
    //课程类类型
    @TableField("course_type")
    private String courseType;
    //课程是否开启
    @TableField("course_start")
    private Integer courseStart;
    //周次
    @TableField("course_week")
    private String courseWeek;
}
