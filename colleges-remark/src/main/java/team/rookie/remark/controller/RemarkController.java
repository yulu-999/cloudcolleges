package team.rookie.remark.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.rookie.remark.feign.IAdminFeignService;
import team.rookie.remark.service.IRemarkService;

import java.util.Map;

@RestController
@RequestMapping("/remark")
public class RemarkController {

    @Autowired
    private IRemarkService remarkService;


    /**
     * @desc  学生点评
     * @param courseId
     * @param level
     * @param token
     * @param content
     * @return
     */
    @RequestMapping("/add")
    public Map<String, Object> add(String courseId, Integer level,String token,String content){
        return  remarkService.add(courseId,level,token,content);
    }


    @RequestMapping("/byid")
    public Map<String, Object> byId(String courseId){
        return remarkService.byId(courseId);
    }


    @RequestMapping("/del")
    public Map<String, Object> deleteById(String id){
         return remarkService.deleteById(id);
    }



}
