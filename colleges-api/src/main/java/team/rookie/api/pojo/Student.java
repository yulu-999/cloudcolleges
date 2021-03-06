package team.rookie.api.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName Student
 * @Description TODO 学生
 * @Author tran
 * @Date 2021/6/22 15:20
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("student")
public class Student {

    //学生id
    @TableId("studnet_id")
    private String studentId;
    //学生姓名
    @TableField("student_name")
    private String studentName;
    //学生性别
    @TableField("student_sex")
    private Integer studentSex;
    //学号
    @TableField("number")
    private String number;
    //学生密码
    @TableField("password")
    private String password;
    //所属班级
    @TableField("cid")
    private String cid;
    //学校名称
    @TableField("school")
    private String school;
}
