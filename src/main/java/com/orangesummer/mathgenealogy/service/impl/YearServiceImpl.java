package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.exception.APIException;
import com.orangesummer.mathgenealogy.mapper.YearRepository;
import com.orangesummer.mathgenealogy.model.mapstruct.ClassificationNumWithYearMapper;
import com.orangesummer.mathgenealogy.model.po.ClassificationNumWithYear;
import com.orangesummer.mathgenealogy.model.vo.ClassificationNumWithYearVO;
import com.orangesummer.mathgenealogy.service.YearService;
import com.orangesummer.mathgenealogy.util.Constant;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/9
 */
@Service
public class YearServiceImpl implements YearService {
    @Resource
    YearRepository yearRepository;
    @Resource
    ClassificationNumWithYearMapper classificationNumWithYearMapper;

    /**
     * 各国一个时间段数学家数量总计
     * @param start
     * @param end
     * @return
     */
    @Override
    public Collection<Map<String, Object>> getCountryCount(Integer start, Integer end) {
        Collection<Map<String, Object>> maps = yearRepository.getCountryCount(start, end);
        if (maps == null || maps.isEmpty()) {
            throw new APIException();
        }
        return maps;
    }

    /**
     * 一个时间段各学科数学家数量总计
     * @param start
     * @param end
     * @return
     */
    @Override
    public Collection<Map<String, Object>> getClassificationCount(Integer start, Integer end) {
        Collection<Map<String, Object>> maps = yearRepository.getClassificationCount(start, end);
        if (maps == null || maps.isEmpty()) {
            throw new APIException();
        }
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> temp : maps) {
            Map<String, Object> newMap = new HashMap<>(temp);
            int classificationId = ((Long) temp.get("classification")).intValue();
            if (classificationId != -1) {
                newMap.put("classification", Constant.CLASSIFICATIONARRAY.get(classificationId));
            } else {
                newMap.put("classification", "");
            }
            result.add(newMap);
        }
        return result;
    }

    @Override
    public Collection<ClassificationNumWithYearVO> getClassificationCountWithYear(Integer start, Integer end) {
        Collection<ClassificationNumWithYear> classificationNums = yearRepository.getClassificationCountWithYear(start, end);
        Collection<ClassificationNumWithYearVO> result = classificationNums.stream().map(classificationNumWithYearMapper::toClassificationNumWithYearVO).toList();
        return result;
    }

}
