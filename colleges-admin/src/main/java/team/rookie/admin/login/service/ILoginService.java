package team.rookie.admin.login.service;

import java.util.Map;

/**
 * @author ：TianShuo
 * @desc ：
 * @date ：2021-06-23 14:57
 */
public interface ILoginService {
    /**
     * 教师和学生的登录
     * @param type  类型
     *              - 1： 学生(默认)
     * - 2： 教师
     * @param name  学号/工号
     * @param password 密码
     * @return
     */
    Map login(Integer type, String name, String password);

    /**
     * 管理员登录
     * @param name  学号/工号
     * @param password  密码
     * @return
     */
    Map adminLogin(String name, String password);
}
