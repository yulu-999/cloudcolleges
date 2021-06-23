package team.rookie.remark.hystrix;


import org.springframework.stereotype.Component;
import team.rookie.api.utils.ReturnMapUtil;
import team.rookie.remark.feign.IAdminFeignService;


/**
 * @desc   做熔断处理
 */
@Component
public class AdminHystrixServiceImpl implements IAdminFeignService {


    /**
     * @desc  根据token获取id异常处理
     * @param token
     * @return
     */
    @Override
    public String getTokenByID(String token) {

        return "{\"code\":500,\"msg\":\"admin异常\"}";
    }
}
