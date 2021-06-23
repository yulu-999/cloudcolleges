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
    public IRemarkService remarkService;

    @Qualifier("adminHystrixServiceImpl")
    @Autowired
    public IAdminFeignService adminFeignService;


    @RequestMapping("/add")
    public Map<String, Object> add(String courseId, Integer level,String token,String content){
        String tokenByID = adminFeignService.getTokenByID(token);
        return  null;
    }



}
