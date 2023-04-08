package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.mapper.MathematicianGraphRepository;
import com.orangesummer.mathgenealogy.model.vo.ResultVO;
import com.orangesummer.mathgenealogy.service.MathematicianGraphService;
import com.orangesummer.mathgenealogy.util.Constant;
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
public class MathematicianGraphServiceImpl implements MathematicianGraphService {
    @Resource
    MathematicianGraphRepository mathematicianGraphRepository;


    /**
     * @param mid
     * @param depth
     * @return
     */
    @Override
    public ResultVO<Map<String, Object>> getTreeByMid(Long mid, Long depth) {
        List<Map<String, Object>> mTree = mathematicianGraphRepository.findTreeByMid(mid, depth);
        //改变字段名
        Map<String, Object> students = changeKey(mTree.get(0), "advisorof", Constant.DIRECTION_RIGHT);
        Map<String, Object> advisors = changeKey(mTree.get(1), "studentof", Constant.DIRECTION_LEFT);
        Collection stuChildren = (Collection) students.get("children");
        Collection advChildren = (Collection) advisors.get("children");
        stuChildren.addAll(advChildren);
        students.put("children",stuChildren);
        return new ResultVO<>(Constant.REQUEST_SUCCESS, Constant.REQUEST_SUCCESS_MESSAGE, students);
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
