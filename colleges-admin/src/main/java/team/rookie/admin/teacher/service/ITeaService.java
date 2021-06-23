package team.rookie.admin.teacher.service;
/**
 * @desc   教师模块的M层接口
 * @author zyf
 * @time   6-23
 */

import team.rookie.api.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface ITeaService {

    //分页模糊查询
    Map<String, Object> queryAll(Integer page,Integer limit,String content);

    //根据ID修改数据
    Map<String, Object> update(String id,String teacherName,String teacherSex, String number,String password);

    //添加教师
    Map<String, Object> add(String name,Integer sex,String number, String password, String school);
}
