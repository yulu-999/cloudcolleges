package team.rookie.remark.service;

import java.util.Map;

public interface IRemarkService {

    Map<String, Object> add (String courseId, Integer level,String token,String content);

    Map<String, Object> byId(String courseId);

    Map<String, Object> deleteById(String id);


}
