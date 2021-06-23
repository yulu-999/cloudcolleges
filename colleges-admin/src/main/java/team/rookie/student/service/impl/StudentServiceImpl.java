package team.rookie.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.rookie.student.mapper.StudentMapper;
import team.rookie.student.service.IStudentService;

import java.util.Map;

/**
 * @author ShiJie
 * @desc
 * @time 2021-06-23-14:18
 */

public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Map<String, Object> selectAll(Integer page, Integer limit, String content) {


        return null;
    }
}
