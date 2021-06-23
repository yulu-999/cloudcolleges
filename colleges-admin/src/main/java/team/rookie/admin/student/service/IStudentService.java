package team.rookie.admin.student.service;

import java.util.Map;

/**
 * @author ShiJie
 * @desc
 * @time 2021-06-23-14:18
 */

public interface IStudentService {

    /**
     * 学生获取
     * @param token
     * @param page
     * @param limit
     * @param content
     * @return
     */
    Map<String,Object> selectAll(Integer page,Integer limit,String content);
}
