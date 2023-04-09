package com.orangesummer.mathgenealogy.service;

import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/4
 */
public interface GraphService {
    Map<String, Object> getTreeByMid(Long mid, Long depth);
}
