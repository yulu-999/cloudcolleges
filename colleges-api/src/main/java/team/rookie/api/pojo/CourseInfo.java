package team.rookie.api.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName CourseInfo
 * @Description TODO 课程信息
 * @Author tran
 * @Date 2021/6/22 20:46
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("courseinfo")
public class CourseInfo {

    //选课记录id
    @TableId("courseinfo_id")
    private String courseInfoId;
    //学生id
    @TableField("studnet_id")
    private String studentId;
    //课程id
    @TableField("course_id")
    private Integer courseId;
    //加入时间
    @TableField("birth")
    private String birth;
    //是否删除
    @TableField("show")
    private String show;
}
