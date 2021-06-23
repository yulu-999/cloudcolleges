package team.rookie.api.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName remarkInfo
 * @Description TODO 点评信息
 * @Author tran
 * @Date 2021/6/22 20:49
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("remarkinfo")
public class RemarkInfo {

    //点评记录id
    @TableId("remarkinfo_id")
    private String remarkInfoId;
    //学生id
    @TableField("studnet_id")
    private String studnetId;
    //课程id
    @TableField("course_id")
    private String courseId;
    //点评星级
    @TableField("level")
    private Integer level;
    //点评内容
    @TableField("content")
    private String content;
    //是否删除
    @TableField("myshow")
    private Integer myshow;

}
