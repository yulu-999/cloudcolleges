package team.rookie.course.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import team.rookie.course.hystrix.AdminHystrixServiceImpl;

/**
 * @ClassName RemakeFeguinService
 * @Description TODO
 * @Author tran
 * @Date 2021/6/24 9:06
 * @Version 1.0
 **/
@FeignClient(name = "remake",fallback = AdminHystrixServiceImpl.class)
@Component("remakeFeguinService")
public class RemakeFeguinService {
}
