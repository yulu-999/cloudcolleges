package team.rookie.admin.student.service;

import team.rookie.api.pojo.Student;

import java.util.Map;

/**
 * @author ShiJie
 * @desc
 * @time 2021-06-23-14:18
 */

public interface IStudentService {

    /**
     * 学生获取
     * @param page
     * @param limit
     * @param content
     * @return
     */
    Map<String,Object> selectAll(Integer page,Integer limit,String content);

    /**
     * 根据id查询学生
     * @param studentId
     * @return
     */
    Map<String,Object> selectOne(Integer studentId);


    /**
     * 添加
     * @param studentName
     * @param studentSex
     * @param number
     * @param password
     * @param cid
     * @param school
     * @return
     */
    Map<String, Object> addOne(String studentName,Integer studentSex,String number,String password,String cid,String school);

    /**
     * 修改
     * @param studentId
     * @param studentName
     * @param studentSex
     * @param number
     * @param password
     * @param cid
     * @param school
     * @return
     */
    Map<String, Object> updateOne(String studentId,String studentName,Integer studentSex,String number,String password,String cid,String school);

}
