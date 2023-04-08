package com.orangesummer.mathgenealogy.controller;

import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.model.vo.ResultVO;
import com.orangesummer.mathgenealogy.service.MathematicianBasicService;
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
public class MathematicianBasicController {
    @Resource
    MathematicianBasicService mathematicianBasicService;

    @GetMapping("/get")
    public ResultVO<MathematicianVO> getMathematician(@RequestParam(value = "id") Long mid) {
        return mathematicianBasicService.getMathematician(mid);
    }

    @GetMapping("/getlist")
    public ResultVO<Page<MathematicianVO>> getAllMathematicians(@RequestParam Integer page, @RequestParam Integer size) {
        return mathematicianBasicService.allMathematicians(page, size);
    }

    @GetMapping("/getCountryCount")
    public ResultVO<Collection<Map<String, Object>>> getCountryCount() {
        return mathematicianBasicService.getCountryCount();
    }

    @GetMapping("/getInstitutionCount")
    public ResultVO<Collection<Map<String, Object>>> getInstitutionCount() {
        return mathematicianBasicService.getInstitutionCount();
    }
    @GetMapping("/getClassificationCount")
    public ResultVO<Collection<Map<String, Object>>> getClassificationCount() {
        return mathematicianBasicService.getClassificationCount();
    }
}
