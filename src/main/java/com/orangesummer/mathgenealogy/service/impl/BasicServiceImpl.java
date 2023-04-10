package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.exception.APIException;
import com.orangesummer.mathgenealogy.mapper.BasicRepository;
import com.orangesummer.mathgenealogy.mapper.Neo4jClientRepository;
import com.orangesummer.mathgenealogy.model.mapstruct.MathematicianMapper;
import com.orangesummer.mathgenealogy.model.po.Mathematician;
import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.model.vo.MathematicianFindByMid;
import com.orangesummer.mathgenealogy.service.BasicService;
import com.orangesummer.mathgenealogy.util.Constant;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Service
public class BasicServiceImpl implements BasicService {
    @Resource
    BasicRepository basicRepository;
    @Resource
    Neo4jClientRepository neo4jClientRepository;
    @Resource
    MathematicianMapper mathematicianMapper;

    /**
     * 获取数学家个人信息
     *
     * @param mid
     * @return
     */
    @Override
    public MathematicianFindByMid getMathematician(Long mid) {
        Optional<MathematicianVO> a = neo4jClientRepository.findByMid(mid);
        if (a.isEmpty()) {
            throw new APIException();
        }
        MathematicianVO temp = a.get();
        return new MathematicianFindByMid(
                temp.getMid(),
                temp.getName(),
                temp.getCountry(),
                temp.getTitle(),
                temp.getYear(),
                temp.getInstitution(),
                temp.getDissertation(),
                temp.getClassification() == -1 ? "" : Constant.CLASSIFICATIONARRAY.get(temp.getClassification()),
                temp.getStudents(),
                temp.getAdvisors()
        );
    }

    /**
     * 分页获取数学家
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<MathematicianVO> allMathematicians(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Mathematician> page1 = basicRepository.getList(pageable);
        return page1.map(mathematicianMapper::toMathematicianVO);
    }

    @Override
    public Collection<Map<String, Object>> getCountryCount() {
        Collection<Map<String, Object>> maps = neo4jClientRepository.getCountryCount();
        if (maps == null || maps.isEmpty()) {
            throw new APIException();
        }
        return maps;
    }

    @Override
    public Collection<Map<String, Object>> getInstitutionCount() {
        Collection<Map<String, Object>> maps = neo4jClientRepository.getInstitutionCount();
        if (maps == null || maps.isEmpty()) {
            throw new APIException();
        }
        return maps;
    }

    @Override
    public Collection<Map<String, Object>> getClassificationCount() {
        Collection<Map<String, Object>> maps = neo4jClientRepository.getClassificationCount();
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
}
