package team.rookie.api.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName Admin
 * @Description TODO 管理员
 * @Author tran
 * @Date 2021/6/22 20:40
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("admin")
public class Admin {

    //id
    @TableId("id")
    private String id;
    //管理员姓名
    @TableField("name")
    private String name;
    //管理员密码
    @TableField("password")
    private Integer password;
    //管理员类型
    @TableField("type")
    private String type;
    //状态
    @TableField("state")
    private String state;

}
