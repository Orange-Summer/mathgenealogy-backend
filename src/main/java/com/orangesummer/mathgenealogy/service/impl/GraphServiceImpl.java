package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.exception.APIException;
import com.orangesummer.mathgenealogy.mapper.GraphRepository;
import com.orangesummer.mathgenealogy.service.GraphService;
import com.orangesummer.mathgenealogy.util.Constant;
import com.orangesummer.mathgenealogy.util.ResultCode;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/4
 */
@Service
public class GraphServiceImpl implements GraphService {
    @Resource
    GraphRepository graphRepository;


    /**
     * @param mid
     * @param depth
     * @return
     */
    @Override
    public Map<String, Object> getTreeByMid(Long mid, Long depth) {
        List<Map<String, Object>> mTree = graphRepository.findTreeByMid(mid, depth);
        //改变字段名
        Map<String, Object> students = changeKey(mTree.get(0), "advisorof", Constant.DIRECTION_RIGHT);
        Map<String, Object> advisors = changeKey(mTree.get(1), "studentof", Constant.DIRECTION_LEFT);
        Collection stuChildren = (Collection) students.get("children");
        Collection advChildren = (Collection) advisors.get("children");
        Collection children = new ArrayList<>();
        if (stuChildren != null) {
            children.addAll(stuChildren);
        }
        if (advChildren != null) {
            children.addAll(advChildren);
        }
        if (!children.isEmpty()) {
            students.put("children", children);
        } else {
            students.remove("children");
        }
        return students;
    }

    @Override
    public Map<String, Object> getStudentTreeByMid(Long mid, Long depth) {
        List<Map<String, Object>> students = graphRepository.findStudentTreeByMid(mid, depth);
        Map<String, Object> student = changeKey(students.get(0), "advisorof", Constant.DIRECTION_RIGHT);
        if (student.get("children") == null) {
            throw new APIException(ResultCode.NULL_DATA);
        }
        return student;
    }

    @Override
    public Map<String, Object> getAdvisorTreeByMid(Long mid, Long depth) {
        List<Map<String, Object>> advisors = graphRepository.findAdvisorTreeByMid(mid, depth);
        Map<String, Object> advisor = changeKey(advisors.get(0), "studentof", Constant.DIRECTION_LEFT);
        if (advisor.get("children") == null) {
            throw new APIException(ResultCode.NULL_DATA);
        }
        return advisor;
    }

    private Map<String, Object> changeKey(Map<String, Object> map, String specialKey, Integer direction) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", map.get("mid").toString());
        result.put("mid", map.get("mid"));
        result.put("direction", direction);
        result.put("name", map.getOrDefault("name", ""));
        // result.put("country", map.getOrDefault("country", ""));
        // result.put("title", map.getOrDefault("title", ""));
        // result.put("year", map.getOrDefault("year", 0));
        // result.put("institution", map.getOrDefault("institution", ""));
        // result.put("dissertation", map.getOrDefault("dissertation", ""));
        // result.put("classification", map.getOrDefault("classification", ""));
        if (map.containsKey(specialKey)) {
            if (map.get(specialKey) instanceof List<?>) {
                List list = (List) map.get(specialKey);
                List<Map<String, Object>> mapList = new ArrayList<>();
                for (Object map1 : list) {
                    if (map1 instanceof Map<?, ?>) {
                        mapList.add(changeKey((Map<String, Object>) map1, specialKey, direction));
                    }
                }
                result.put("children", mapList);
            }
        }
        return result;
    }
}
