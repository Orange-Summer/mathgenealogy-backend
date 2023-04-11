package com.orangesummer.mathgenealogy.controller;

import com.orangesummer.mathgenealogy.service.GraphService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/4
 */
@RestController
@RequestMapping("/graph")
public class GraphController {
    @Resource
    GraphService graphService;

    @GetMapping("/getTree")
    public Map<String, Object> getTreeByMid(@RequestParam(value = "id") Long mid, @RequestParam Long depth) {
        return graphService.getTreeByMid(mid, depth);
    }

    @GetMapping("getStudentTree")
    public Map<String, Object> getStudentTreeByMid(@RequestParam(value = "id") Long mid, @RequestParam Long depth) {
        return graphService.getStudentTreeByMid(mid, depth);
    }

    @GetMapping("getAdvisorTree")
    public Map<String, Object> getAdvisorTreeByMid(@RequestParam(value = "id") Long mid, @RequestParam Long depth) {
        return graphService.getAdvisorTreeByMid(mid, depth);
    }
}
