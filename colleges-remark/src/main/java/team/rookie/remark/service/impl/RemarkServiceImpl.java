package team.rookie.remark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.rookie.remark.mapper.RemarkMapper;
import team.rookie.remark.service.IRemarkService;

import java.util.Map;


@Service
public class RemarkServiceImpl implements IRemarkService {
    @Autowired
    public RemarkMapper remarkMapper;

    @Override
    public Map<String, Object> add(String courseId, Integer level, String token, String content) {



        return null;
    }
}
