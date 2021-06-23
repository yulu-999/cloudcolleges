package team.rookie.remark.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import team.rookie.remark.hystrix.AdminHystrixServiceImpl;

import java.util.Map;

@FeignClient(name = "admin",fallback = AdminHystrixServiceImpl.class)
@Component
public interface IAdminFeignService {

    /**
     * @desc  调用admin服务根据token获取id
     * @param token
     * @return
     */
     @RequestMapping(value = "/token",method = RequestMethod.GET)
     Map<String, Object> getTokenByID(@RequestParam("token") String token);

}
