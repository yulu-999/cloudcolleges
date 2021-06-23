package team.rookie.admin.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.rookie.admin.login.mapper.AdminMapper;
import team.rookie.admin.login.service.ILoginService;
import team.rookie.admin.student.mapper.StudentMapper;
import team.rookie.admin.teacher.mapper.TeaMapper;
import team.rookie.admin.utils.TokenUtils;
import team.rookie.api.pojo.Admin;
import team.rookie.api.pojo.Student;
import team.rookie.api.pojo.Teacher;
import team.rookie.api.utils.ReturnMapUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：TianShuo
 * @desc ：
 * @date ：2021-06-23 14:57
 */

@Service("loginServicelmpl")
public class LoginServicelmpl implements ILoginService {
    @Autowired
    private TeaMapper teaMapper;


    @Autowired
    private StudentMapper studentMapper;



    @Autowired
    private AdminMapper adminMapper;

    /**
     * 教师和学生的登录
     * @param type  类型 为1学生登录 为2教师登录
     * @param name 账号
     * @param password 密码
     * @return
     */
    @Override
    public Map login(Integer type, String name, String password) {
        //1.验证参数
        if (type == null || type.equals("")) {
            type = 1;
        }
        if (name == null || name.equals("") || password == null || password.equals("")) {
            return ReturnMapUtil.printf(-1, "请输入账号或密码");
        }
        //判断是学生登录还是教师登录
        if (type == 1 ) {
            QueryWrapper<Student> query = new QueryWrapper<>();
            query.eq("number", name);
            Student student = studentMapper.selectOne(query);
            //判断是不是该校学生
            if (student == null) {
                return ReturnMapUtil.printf(-1, "你不是本校学生");
            } else {
                String password1 = student.getPassword();
                System.out.println(password1);
                //判断密码是否正确


                if (password1.equals(password)) {
                    String token = TokenUtils.createToken(student.getStudentId());
                    Map<String, Object> map = new HashMap<>();
                    map.put("token", token);
                    return ReturnMapUtil.printf(200, "登录成功", map);
                } else {
                    return ReturnMapUtil.printf(-1, "密码错误");
                }



            }
        }

        else {
            QueryWrapper<Teacher> query = new QueryWrapper<>();
            query.eq("number", name);
            Teacher teacher = teaMapper.selectOne(query);
            //判断是不是该校老师
            if (teacher == null) {
                return ReturnMapUtil.printf(-1, "你不是本校老师");
            } else {
                String password1 = teacher.getPassword();
                //判断密码是否正确
                if (password1.equals(password)) {
                    String token = TokenUtils.createToken(teacher.getTeacherId());
                    Map<String, Object> map = new HashMap<>();
                    map.put("token", token);
                    return ReturnMapUtil.printf(200, "登录成功", map);
                } else {
                    return ReturnMapUtil.printf(-1, "密码错误");
                }
            }
        }

    }

    /**
     * 管理员登录
     * @param name  学号/工号
     * @param password  密码
     * @return
     */
    @Override
    public Map adminLogin(String name, String password)
    {
        //1.验证参数
        if (name == null || name.equals("") || password == null || password.equals("")) {
            return ReturnMapUtil.printf(-1, "请输入账号或密码");
        }

        //2.查询数据库
        QueryWrapper<Admin> query = new QueryWrapper<>();
        query.eq("name", name);
        Admin admin =  adminMapper.selectOne(query);
        //先比对是否存在
        if ( admin == null ){
            return ReturnMapUtil.printf(-1, "你不是管理员");
        }else { // 比对密码是否正确
            String password1 = admin.getPassword();
            if (password1.equals(password)) {
                String token = TokenUtils.createToken(admin.getId());
                Map<String, Object> map = new HashMap<>();
                map.put("token", token);
                return ReturnMapUtil.printf(200, "登录成功", map);
            }else {
                return ReturnMapUtil.printf(-1, "密码错误");
            }
        }
    }
}
