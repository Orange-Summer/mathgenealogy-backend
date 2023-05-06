package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.exception.APIException;
import com.orangesummer.mathgenealogy.mapper.BasicRepository;
import com.orangesummer.mathgenealogy.mapper.CountryRepository;
import com.orangesummer.mathgenealogy.model.mapstruct.ClassificationNumMapper;
import com.orangesummer.mathgenealogy.model.mapstruct.ClassificationNumWithYearMapper;
import com.orangesummer.mathgenealogy.model.po.ClassificationNum;
import com.orangesummer.mathgenealogy.model.po.ClassificationNumWithYear;
import com.orangesummer.mathgenealogy.model.po.KnowledgeFlow;
import com.orangesummer.mathgenealogy.model.vo.ClassificationNumVO;
import com.orangesummer.mathgenealogy.model.vo.ClassificationNumWithYearVO;
import com.orangesummer.mathgenealogy.model.vo.KnowledgeFlowVO;
import com.orangesummer.mathgenealogy.service.CountryService;
import com.orangesummer.mathgenealogy.util.Constant;
import com.orangesummer.mathgenealogy.util.ResultCode;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/15
 */
@Service
public class CountryServiceImpl implements CountryService {
    @Resource
    BasicRepository basicRepository;
    @Resource
    CountryRepository countryRepository;
    @Resource
    ClassificationNumMapper classificationNumMapper;
    @Resource
    ClassificationNumWithYearMapper classificationNumWithYearMapper;

    @Override
    public Collection<ClassificationNumVO> getSingleCountryClassification(String country, Integer start, Integer end) {
        Collection<ClassificationNum> classificationNums = countryRepository.countByCountryAndAllClassificationAndYearRange(country, start, end);
        return classificationNums.stream().map(classificationNumMapper::toClassificationNumVO).toList();
    }

    @Override
    public Collection<Map<String, Object>> getCountryCountLine(String[] countries, Integer start, Integer end) {
        if (countries.length > 1) {
            List<Map<String, Object>> result = new ArrayList<>();
            for (String country : countries) {
                Collection<Map<String, Object>> temp = countryRepository.countByCountryAndYearRangeWithYear(country, start, end);
                result.addAll(temp);
            }
            return result;
        } else if (countries.length == 1) {
            if (Objects.equals(countries[0], "all")) {
                Collection<String> countryList = basicRepository.findAllCountry();
                List<Map<String, Object>> result = new ArrayList<>();
                for (String country : countryList) {
                    Collection<Map<String, Object>> temp = countryRepository.countByCountryAndYearRangeWithYear(country, start, end);
                    result.addAll(temp);
                }
                return result;
            } else {
                return countryRepository.countByCountryAndYearRangeWithYear(countries[0], start, end);
            }
        } else {
            throw new APIException();
        }
    }

    @Override
    public Collection<ClassificationNumWithYearVO> getSingleCountryClassificationWithYear(String country, Integer start, Integer end) {
        Collection<ClassificationNumWithYear> classificationNums = countryRepository.countByCountryAndAllClassificationAndYearRangeWithYear(country, start, end);
        return classificationNums.stream().map(classificationNumWithYearMapper::toClassificationNumWithYearVO).toList();
    }

    @Override
    public Collection<KnowledgeFlowVO> getKnowledgeFlowOut(String country, Integer start, Integer end) {
        Collection<KnowledgeFlow> knowledgeFlows = countryRepository.findKnowledgeFlowOut(country, start, end);
        List<KnowledgeFlowVO> result = new ArrayList<>();
        for (KnowledgeFlow knowledgeFlow : knowledgeFlows) {
            if (Constant.COUNTRYLON.containsKey(knowledgeFlow.getFrom()) && Constant.COUNTRYLON.containsKey(knowledgeFlow.getTo())) {
                result.add(new KnowledgeFlowVO(knowledgeFlow));
            }
        }
        if (result.size() == 0) {
            throw new APIException(ResultCode.NULL_DATA);
        }
        return result;
    }

    @Override
    public Collection<KnowledgeFlowVO> getKnowledgeFlowIn(String country, Integer start, Integer end) {
        Collection<KnowledgeFlow> knowledgeFlows = countryRepository.findKnowledgeFlowIn(country, start, end);
        List<KnowledgeFlowVO> result = new ArrayList<>();
        for (KnowledgeFlow knowledgeFlow : knowledgeFlows) {
            if (Constant.COUNTRYLON.containsKey(knowledgeFlow.getFrom()) && Constant.COUNTRYLON.containsKey(knowledgeFlow.getTo())) {
                result.add(new KnowledgeFlowVO(knowledgeFlow));
            }
        }
        if (result.size() == 0) {
            throw new APIException(ResultCode.NULL_DATA);
        }
        return result;
    }

}
