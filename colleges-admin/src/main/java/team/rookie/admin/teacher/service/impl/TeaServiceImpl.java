package team.rookie.admin.teacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.rookie.admin.teacher.mapper.TeaMapper;
import team.rookie.admin.teacher.service.ITeaService;

import java.util.List;
import java.util.Map;


@Service
public class TeaServiceImpl implements ITeaService {
    @Autowired
    public TeaMapper teaMapper;

    @Override
    public List<Map<String, Object>> query(Integer page, Integer limit) {
        return teaMapper.query(page,limit);
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        return teaMapper.queryAll();
    }
}
