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

    Map<String, Object> getStudentTreeByMid(Long mid, Long depth);

    Map<String, Object> getAdvisorTreeByMid(Long mid, Long depth);
}
