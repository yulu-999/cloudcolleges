package team.rookie.admin.teacher.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.rookie.admin.teacher.service.ITeaService;
import team.rookie.api.pojo.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeaController {

    @Autowired
    public ITeaService teaService;


    @RequestMapping("/all")
    public Map<String, Object> queryAll(Integer page,Integer limit,String content){

        return teaService.queryAll(page,limit,content);
    }


    @RequestMapping("/update")
    public Map<String, Object> update(String id,String teacherName,String teacherSex,String number,String password){
        return teaService.update(id,teacherName,teacherSex,number,password);
    }



}
