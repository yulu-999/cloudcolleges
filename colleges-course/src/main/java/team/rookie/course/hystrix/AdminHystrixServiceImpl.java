package team.rookie.course.hystrix;


import org.springframework.stereotype.Component;
import team.rookie.api.utils.ReturnMapUtil;
import team.rookie.course.feign.IAdminFeignService;

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



    /**
     * @Desc 根据id获取教师信息
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getTeacherById(String id) {
        return ReturnMapUtil.printf(555,"admin服务错误");
    }

    /**
     * @Desc  根据id获取学生信息
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getStudentById(String id) {
        return ReturnMapUtil.printf(555,"admin服务错误");
    }

}
