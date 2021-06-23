package team.rookie.admin.teacher.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.rookie.admin.teacher.service.ITeaService;

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
        Map<String, Object> map = new HashMap<>();
        if (page==1){
            page=0;
        }
        if (limit==null){
            limit=10;
        }
        if (content ==null){
            List<Map<String, Object>> list =teaService.query(page,limit);
            if (list==null || list.size()==0){
                map.put("code",-1);
                map.put("msg","获取失败");
                return map;
            }
            List<Map<String, Object>> list1 = teaService.queryAll();

            if(limit==null){
                map.put("count" ,0);
            }
            else {
                System.out.println(list1.size());
                map.put("count",list1.size());
            }
            map.put("code",0);
            map.put("msg","获取成功");
            map.put("data",list);
        }


        return map;
    }



}
