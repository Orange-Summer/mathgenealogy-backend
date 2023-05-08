package com.orangesummer.mathgenealogy.controller;

import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.model.vo.MathematicianFindByMid;
import com.orangesummer.mathgenealogy.model.vo.RankingVO;
import com.orangesummer.mathgenealogy.model.vo.SameClassPercentVO;
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
    public MathematicianFindByMid getMathematician(@RequestParam(value = "id") Long mid) {
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

    @GetMapping("/getAllCountry")
    public Collection<String> getAllCountry() {
        return basicService.getAllCountry();
    }

    @GetMapping("/getAllClassification")
    public Collection<String> getAllClassification() {
        return basicService.getAllClassification();
    }

    @GetMapping("/getRanking")
    public Collection<RankingVO> getRanking(@RequestParam String[] countries, @RequestParam String[] classifications, @RequestParam Integer start, @RequestParam Integer end, @RequestParam Integer limit) {
        return basicService.getRanking(countries, classifications, start, end, limit);
    }

    @GetMapping("/getSameClassificationPercentage")
    Collection<SameClassPercentVO> getSameClassPercent() {
        return basicService.getSameClassPercent();
    }

    @GetMapping("/getAverage")
    Collection<Map<String, Object>> getAverage() {
        return basicService.getAverage();
    }
}
