package team.rookie.api.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName TeamcClass
 * @Description TODO 班级
 * @Author tran
 * @Date 2021/6/22 20:42
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("teamclass")
public class TeamcClass {
    //id
    @TableId("class_id")
    private String teacherId;
    //班级姓名
    @TableField("class_name")
    private String teacherName;
}
