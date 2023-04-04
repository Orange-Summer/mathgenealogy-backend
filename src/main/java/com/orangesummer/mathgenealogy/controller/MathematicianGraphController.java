package com.orangesummer.mathgenealogy.controller;

import com.orangesummer.mathgenealogy.model.vo.ResultVO;
import com.orangesummer.mathgenealogy.service.MathematicianGraphService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/4
 */
@RestController
@RequestMapping("/graph")
public class MathematicianGraphController {
    @Resource
    MathematicianGraphService mathematicianGraphService;

    @GetMapping("/getTree")
    public ResultVO<List<Map<String, Object>>> getTreeByMid(@RequestParam(value = "id") Long mid, @RequestParam Long depth) {
        return mathematicianGraphService.getTreeByMid(mid, depth);
    }
}
