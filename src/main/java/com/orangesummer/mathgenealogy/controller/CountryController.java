package com.orangesummer.mathgenealogy.controller;

import com.orangesummer.mathgenealogy.model.vo.ClassificationNumVO;
import com.orangesummer.mathgenealogy.model.vo.ClassificationNumWithYearVO;
import com.orangesummer.mathgenealogy.model.vo.KnowledgeFlowVO;
import com.orangesummer.mathgenealogy.service.CountryService;
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
 * @date Created on 2023/4/15
 */
@RestController
@RequestMapping("/country")
public class CountryController {
    @Resource
    CountryService countryService;

    @GetMapping("/getSingleCountryClassification")
    public Collection<ClassificationNumVO> getSingleCountryClassification(@RequestParam String country, @RequestParam Integer start, @RequestParam Integer end) {
        return countryService.getSingleCountryClassification(country, start, end);
    }

    @GetMapping("/getSingleCountryCountLine")
    public Collection<Map<String, Object>> getSingleCountryCountLine(@RequestParam String country, @RequestParam Integer start, @RequestParam Integer end) {
        String[] countries = new String[]{country};
        return countryService.getCountryCountLine(countries, start, end);
    }

    @GetMapping("/getCountryCountLine")
    public Collection<Map<String, Object>> getCountryCountLine(@RequestParam String[] countries, @RequestParam Integer start, @RequestParam Integer end) {
        return countryService.getCountryCountLine(countries, start, end);
    }

    @GetMapping("/getSingleCountryClassificationWithYear")
    Collection<ClassificationNumWithYearVO> getSingleCountryClassificationWithYear(@RequestParam String country, @RequestParam Integer start, @RequestParam Integer end) {
        return countryService.getSingleCountryClassificationWithYear(country, start, end);
    }

    @GetMapping("/getKnowledgeFlowOut")
    public Collection<KnowledgeFlowVO> getKnowledgeFlowOut(@RequestParam String country, @RequestParam Integer start, @RequestParam Integer end) {
        return countryService.getKnowledgeFlowOut(country, start, end);
    }

    @GetMapping("/getKnowledgeFlowIn")
    Collection<KnowledgeFlowVO> getKnowledgeFlowIn(@RequestParam String country, @RequestParam Integer start, @RequestParam Integer end) {
        return countryService.getKnowledgeFlowIn(country, start, end);
    }

}
