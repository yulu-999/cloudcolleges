package team.rookie.remark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team.rookie.remark.feign.IAdminFeignService;
import team.rookie.remark.mapper.RemarkMapper;
import team.rookie.remark.service.IRemarkService;

import java.util.Map;


@Service
public class RemarkServiceImpl implements IRemarkService {
    @Autowired
    public RemarkMapper remarkMapper;


    @Qualifier("IAdminFeignService")
    @Autowired
    private IAdminFeignService adminFeignService;

    @Override
    public Map<String, Object> add(String courseId, Integer level, String token, String content) {
        Map<String, Object> maps = adminFeignService.getTokenByID(token);
        if (maps.get("data")==null){
            return maps;
        }
        return null;
    }
}
