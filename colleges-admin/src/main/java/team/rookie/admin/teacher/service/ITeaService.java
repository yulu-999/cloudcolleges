package team.rookie.admin.teacher.service;

import java.util.List;
import java.util.Map;

public interface ITeaService {
    List<Map<String, Object>> query(Integer page, Integer limit);

    List<Map<String, Object>> queryAll();
}
