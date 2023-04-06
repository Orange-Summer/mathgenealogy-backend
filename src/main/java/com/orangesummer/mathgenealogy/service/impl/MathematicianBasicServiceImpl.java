package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.mapper.MathematicianBasicRepository;
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
    MathematicianMapper mathematicianMapper;

    @Override
    public ResultVO<Page<MathematicianVO>> allMathematicians(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Mathematician> page1 = mathematicianBasicRepository.getList(pageable);
        Page<MathematicianVO> page2 = page1.map(mathematicianMapper::toMathematicianVO);
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "请求成功", page2);
    }
}
