package team.rookie.api.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName Teacher
 * @Description TODO 教师
 * @Author tran
 * @Date 2021/6/22 20:38
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher")
public class Teacher {

    //教师id
    @TableId("teacher_id")
    private String teacherId;
    //教师姓名
    @TableField("teacher_name")
    private String teacherName;
    //教师性别
    @TableField("teacher_sex")
    private Integer teacherSex;
    //工号
    @TableField("number")
    private String number;
    //教师密码
    @TableField("password")
    private String password;
    //学校名称
    @TableField("school")
    private String school;

}
