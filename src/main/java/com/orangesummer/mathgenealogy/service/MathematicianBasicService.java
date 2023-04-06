package com.orangesummer.mathgenealogy.service;

import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.model.vo.ResultVO;
import org.springframework.data.domain.Page;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
public interface MathematicianBasicService {
    ResultVO<Page<MathematicianVO>> allMathematicians(Integer page, Integer size);
}
