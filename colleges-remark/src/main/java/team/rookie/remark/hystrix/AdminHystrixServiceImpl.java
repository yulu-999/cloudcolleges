package team.rookie.remark.hystrix;


import org.springframework.stereotype.Component;
import team.rookie.api.utils.ReturnMapUtil;
import team.rookie.remark.feign.IAdminFeignService;

import java.util.Map;


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
    public Map<String, Object> getTokenByID(String token) {
        return ReturnMapUtil.printf(555,"admin服务错误");
    }


}
