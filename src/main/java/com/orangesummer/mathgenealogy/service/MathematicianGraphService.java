package com.orangesummer.mathgenealogy.service;

import com.orangesummer.mathgenealogy.model.vo.ResultVO;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/4
 */
public interface MathematicianGraphService {
    ResultVO<List<Map<String, Object>>> getTreeByMid(Long mid, Long depth);
}
