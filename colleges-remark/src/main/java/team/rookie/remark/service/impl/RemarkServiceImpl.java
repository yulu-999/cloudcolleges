package team.rookie.remark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team.rookie.api.pojo.RemarkInfo;
import team.rookie.api.utils.ReturnMapUtil;
import team.rookie.remark.feign.IAdminFeignService;
import team.rookie.remark.mapper.RemarkMapper;
import team.rookie.remark.service.IRemarkService;
import team.rookie.remark.utils.IDUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RemarkServiceImpl implements IRemarkService {
    @Autowired
    public RemarkMapper remarkMapper;



    @Autowired
    private IAdminFeignService adminFeignService;

    @Override
    public Map<String, Object> add(String courseId, Integer level, String token, String content) {
        Map<String, Object> maps = adminFeignService.getTokenByID(token);
        if (maps.get("data")==null){
            return maps;
        }else {
            String studentId =  maps.get("data").toString();
            RemarkInfo remarkInfo = new RemarkInfo();
            remarkInfo.setRemarkInfoId(IDUtil.getID());
            remarkInfo.setLevel(level);
            remarkInfo.setStudnetId(studentId);
            remarkInfo.setContent(content);
            remarkInfo.setCourseId(courseId);
            remarkInfo.setMyshow(1);

            remarkMapper.insert(remarkInfo);

            return ReturnMapUtil.printf(0,"添加成功");
        }
    }

    @Override
    public Map<String, Object> byId(String courseId) {

        RemarkInfo  remarkInfo = remarkMapper.selectById(courseId);

        if (remarkInfo==null){
            return ReturnMapUtil.printf(-1,"没有此学生");
        }else {
            if (remarkInfo.getMyshow()==0){
                return ReturnMapUtil.printf(-1,"没有此学生");
            }
            ArrayList<Map<String, Object>> data = new ArrayList<>();
            HashMap<String, Object> remarkMap = new HashMap<>();
            remarkMap.put("id",remarkInfo.getRemarkInfoId());
            remarkMap.put("level",remarkInfo.getLevel());
            remarkMap.put("content",remarkInfo.getContent());
            data.add(remarkMap);
            return ReturnMapUtil.printf(0,"查询成功",data);
        }


    }

    @Override
    public Map<String, Object> deleteById(String id) {
        if (id==null || id.equals("")){
            return ReturnMapUtil.printf(-1,"非法调用");
        }else {
            remarkMapper.deleteById(id);

            return ReturnMapUtil.printf(0,"删除成功");
        }

    }
}
