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

    @GetMapping("/getlist")
    public ResultVO<Page<MathematicianVO>> getAllMathematicians(@RequestParam Integer page, @RequestParam Integer size) {
        return mathematicianBasicService.allMathematicians(page, size);
    }
}
