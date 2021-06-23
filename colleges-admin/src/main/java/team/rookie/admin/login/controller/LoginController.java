package team.rookie.admin.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.rookie.admin.login.service.ILoginService;
import team.rookie.api.utils.ReturnMapUtil;

import java.util.Map;

/**
 * @author ：TianShuo
 * @desc ：登录控制器
 * @date ：2021-06-23 14:47
 */

@RestController
public class LoginController {



    @Autowired
    public  ILoginService loginServicelmpl;



    /**
     * @desc  学生/教师登录
     * @param name  学号/工号
     * @param password   密码
     * @param type  类型
     *              1： 学生(默认)     2： 教师
     * @return
     */
    @RequestMapping("/login")
    public Map login(String name , String password , Integer type){
        return loginServicelmpl.login(type,name,password);
    }

    @RequestMapping("/admin/login")
    public Map adminLogin(String name , String password ){
        return loginServicelmpl.adminLogin(name,password);
    }

}
