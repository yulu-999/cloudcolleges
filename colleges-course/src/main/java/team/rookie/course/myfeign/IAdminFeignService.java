package team.rookie.course.myfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import team.rookie.course.hystrix.AdminHystrixServiceImpl;
//import team.rookie.course.hystrix.AdminHystrixServiceImpl;

import java.util.Map;

/**
 * @Desc 调取admin模块的接口
 */
@FeignClient(name = "admin",fallback = AdminHystrixServiceImpl.class)
//@FeignClient("admin")
@Component("adminFeignService")
public interface IAdminFeignService {

    /**
     * @desc  调用admin服务根据token获取id
     * @param token
     * @return
     */
     @RequestMapping(value = "/token",method = RequestMethod.GET)
     Map<String, Object> getTokenByID(@RequestParam("token") String token);


    /**
     * @Desc 获取教师根据id
     * @param id
     * @return
     */
    @RequestMapping(value = "/teacher/byid",method = RequestMethod.GET)
    Map<String, Object> getTeacherById(@RequestParam("id")String id);

    /**
     * @Desc 获取学生根据id
     * @param id
     * @return
     */
    @RequestMapping(value = "/student/byid",method = RequestMethod.GET)
    Map<String, Object> getStudentById(@RequestParam("id")String id);


}
