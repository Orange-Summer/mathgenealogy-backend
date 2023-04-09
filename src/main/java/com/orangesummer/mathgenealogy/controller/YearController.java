package com.orangesummer.mathgenealogy.controller;

import com.orangesummer.mathgenealogy.service.YearService;
import jakarta.annotation.Resource;
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
 * @date Created on 2023/4/9
 */
@RestController
@RequestMapping("/year")
public class YearController {
    @Resource
    YearService yearService;

    @GetMapping("/getCountryCount")
    public Collection<Map<String, Object>> getCountryCount(@RequestParam Integer start, @RequestParam Integer end) {
        return yearService.getCountryCount(start, end);
    }

    @GetMapping("/getClassificationCount")
    public Collection<Map<String, Object>> getClassificationCount(@RequestParam Integer start, @RequestParam Integer end) {
        return yearService.getClassificationCount(start, end);
    }
}
