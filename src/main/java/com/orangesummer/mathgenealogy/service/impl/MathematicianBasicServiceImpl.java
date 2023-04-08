package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.mapper.MathematicianBasicRepository;
import com.orangesummer.mathgenealogy.mapper.Neo4jClientRepository;
import com.orangesummer.mathgenealogy.model.mapstruct.MathematicianMapper;
import com.orangesummer.mathgenealogy.model.po.Mathematician;
import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.model.vo.ResultVO;
import com.orangesummer.mathgenealogy.service.MathematicianBasicService;
import com.orangesummer.mathgenealogy.util.Constant;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Service
public class MathematicianBasicServiceImpl implements MathematicianBasicService {
    @Resource
    MathematicianBasicRepository mathematicianBasicRepository;
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
    public ResultVO<MathematicianVO> getMathematician(Long mid) {
        Optional<MathematicianVO> a = neo4jClientRepository.findByMid(mid);
        return a.map(mathematicianFindByMid -> new ResultVO<>(Constant.REQUEST_SUCCESS, "请求成功", mathematicianFindByMid)).orElseGet(() -> new ResultVO<>(Constant.REQUEST_FAIL, "没有结果", null));
    }

    /**
     * 分页获取数学家
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public ResultVO<Page<MathematicianVO>> allMathematicians(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Mathematician> page1 = mathematicianBasicRepository.getList(pageable);
        Page<MathematicianVO> page2 = page1.map(mathematicianMapper::toMathematicianVO);
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "请求成功", page2);
    }

    @Override
    public ResultVO<Collection<Map<String, Object>>> getCountryCount() {
        Collection<Map<String, Object>> map = neo4jClientRepository.getCountryCount();
        if (map == null) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "查询失败", null);
        } else if (map.isEmpty()) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "没有结果", null);
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "请求成功", map);
    }

    @Override
    public ResultVO<Collection<Map<String, Object>>> getInstitutionCount() {
        Collection<Map<String, Object>> map = neo4jClientRepository.getInstitutionCount();
        if (map == null) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "查询失败", null);
        } else if (map.isEmpty()) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "没有结果", null);
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "请求成功", map);
    }

    @Override
    public ResultVO<Collection<Map<String, Object>>> getClassificationCount() {
        Collection<Map<String, Object>> map = neo4jClientRepository.getClassificationCount();
        return null;
    }
}
