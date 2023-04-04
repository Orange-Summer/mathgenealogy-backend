package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.mapper.MathematicianBasicRepository;
import com.orangesummer.mathgenealogy.mapper.Neo4jClientRepository;
import com.orangesummer.mathgenealogy.model.po.MathematicianFindByMid;
import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.model.vo.ResultVO;
import com.orangesummer.mathgenealogy.service.MathematicianBasicService;
import com.orangesummer.mathgenealogy.util.Constant;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    @Override
    public ResultVO<MathematicianVO> getMathematician(Long mid) {
        Collection<MathematicianFindByMid> mathematician = neo4jClientRepository.findByMid(mid);
        if (mathematician!=null){
            // MathematicianVO mathematicianVO = MathematicianMapper.INSTANCE.toMathematicianVO(mathematician);
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "请求成功", null);
        }else {
            return new ResultVO<>(Constant.REQUEST_FAIL, "没有结果", null);
        }
    }


    @Override
    public Page<MathematicianVO> listMathematicians(Integer pageNum) {
        return null;
    }
}
