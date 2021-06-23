package team.rookie.admin.teacher.controller;
/**
 * @desc   教师模块的c层
 * @author zyf
 * @time   6-23
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.rookie.admin.teacher.service.ITeaService;

import java.util.Map;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins="*")
public class TeaController {

    @Autowired
    public ITeaService teaService;


    /**
     * @desc  教师模块的分页模糊查询
     * @param page
     * @param limit
     * @param content
     * @return
     */
    @RequestMapping("/all")
    public Map<String, Object> queryAll(Integer page,Integer limit,String content){

        return teaService.queryAll(page,limit,content);
    }


    /**
     * @desc  教师模块的根据id修改
     * @param id
     * @param teacherName
     * @param teacherSex
     * @param number
     * @param password
     * @return
     */
    @RequestMapping("/update")
    public Map<String, Object> update(String id,String teacherName,String teacherSex,String number,String password){
        return teaService.update(id,teacherName,teacherSex,number,password);
    }


    /**
     * @desc  教师模块的添加
     * @param name
     * @param sex
     * @param number
     * @param password
     * @param school
     * @return
     */
    @RequestMapping("/add")
    public Map<String, Object> add(String name,Integer sex,String number, String password, String school){

        return  teaService.add(name,sex,name,password,school);
    };



}
