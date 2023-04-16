package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.exception.APIException;
import com.orangesummer.mathgenealogy.mapper.CountryRepository;
import com.orangesummer.mathgenealogy.model.mapstruct.ClassificationNumMapper;
import com.orangesummer.mathgenealogy.model.mapstruct.ClassificationNumWithYearMapper;
import com.orangesummer.mathgenealogy.model.po.ClassificationNum;
import com.orangesummer.mathgenealogy.model.po.ClassificationNumWithYear;
import com.orangesummer.mathgenealogy.model.vo.ClassificationNumVO;
import com.orangesummer.mathgenealogy.model.vo.ClassificationNumWithYearVO;
import com.orangesummer.mathgenealogy.service.CountryService;
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
    CountryRepository countryRepository;
    @Resource
    ClassificationNumMapper classificationNumMapper;
    @Resource
    ClassificationNumWithYearMapper classificationNumWithYearMapper;

    @Override
    public Collection<String> getAllCountry() {
        return countryRepository.getAllCountry();
    }

    @Override
    public Collection<ClassificationNumVO> getSingleCountryClassification(String country, Integer start, Integer end) {
        Collection<ClassificationNum> classificationNums = countryRepository.getSingleCountryClassification(country, start, end);
        Collection<ClassificationNumVO> result = classificationNums.stream().map(classificationNumMapper::toClassificationNumVO).toList();
        return result;
    }

    @Override
    public Collection<Map<String, Object>> getCountryCountLine(String[] countries, Integer start, Integer end) {
        if (countries.length > 1) {
            List<Map<String, Object>> result = new ArrayList<>();
            for (String country : countries) {
                Collection<Map<String, Object>> temp = countryRepository.getSingleCountryCount(country, start, end);
                result.addAll(temp);
            }
            return result;
        } else if (countries.length == 1) {
            if (Objects.equals(countries[0], "all")) {
                Collection<String> countryList = getAllCountry();
                List<Map<String, Object>> result = new ArrayList<>();
                for (String country : countryList) {
                    Collection<Map<String, Object>> temp = countryRepository.getSingleCountryCount(country, start, end);
                    result.addAll(temp);
                }
                return result;
            } else {
                return countryRepository.getSingleCountryCount(countries[0], start, end);
            }
        } else {
            throw new APIException();
        }
    }

    @Override
    public Collection<ClassificationNumWithYearVO> getSingleCountryClassificationWithYear(String country, Integer start, Integer end) {
        Collection<ClassificationNumWithYear> classificationNums = countryRepository.getSingleCountryClassificationWithYear(country, start, end);
        Collection<ClassificationNumWithYearVO> result = classificationNums.stream().map(classificationNumWithYearMapper::toClassificationNumWithYearVO).toList();
        return result;
    }

}
