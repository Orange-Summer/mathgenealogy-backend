package com.orangesummer.mathgenealogy.controller;

import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.service.BasicService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@RestController
@RequestMapping("/basic")
public class BasicController {
    @Resource
    BasicService basicService;

    @GetMapping("/get")
    public MathematicianVO getMathematician(@RequestParam(value = "id") Long mid) {
        return basicService.getMathematician(mid);
    }

    @GetMapping("/getlist")
    public Page<MathematicianVO> getAllMathematicians(@RequestParam Integer page, @RequestParam Integer size) {
        return basicService.allMathematicians(page, size);
    }

    @GetMapping("/getCountryCount")
    public Collection<Map<String, Object>> getCountryCount() {
        return basicService.getCountryCount();
    }

    @GetMapping("/getInstitutionCount")
    public Collection<Map<String, Object>> getInstitutionCount() {
        return basicService.getInstitutionCount();
    }
    @GetMapping("/getClassificationCount")
    public Collection<Map<String, Object>> getClassificationCount() {
        return basicService.getClassificationCount();
    }
}
