package com.orangesummer.mathgenealogy.service.impl;

import com.orangesummer.mathgenealogy.exception.APIException;
import com.orangesummer.mathgenealogy.mapper.BasicRepository;
import com.orangesummer.mathgenealogy.mapper.Neo4jClientRepository;
import com.orangesummer.mathgenealogy.model.mapstruct.MathematicianMapper;
import com.orangesummer.mathgenealogy.model.mapstruct.RankingMapper;
import com.orangesummer.mathgenealogy.model.po.Mathematician;
import com.orangesummer.mathgenealogy.model.po.Ranking;
import com.orangesummer.mathgenealogy.model.vo.MathematicianFindByMid;
import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.model.vo.RankingVO;
import com.orangesummer.mathgenealogy.service.BasicService;
import com.orangesummer.mathgenealogy.util.Constant;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Service
public class BasicServiceImpl implements BasicService {
    @Resource
    BasicRepository basicRepository;
    @Resource
    Neo4jClientRepository neo4jClientRepository;
    @Resource
    MathematicianMapper mathematicianMapper;
    @Resource
    RankingMapper rankingMapper;

    /**
     * 获取数学家个人信息
     *
     * @param mid
     * @return
     */
    @Override
    public MathematicianFindByMid getMathematician(Long mid) {
        Optional<MathematicianVO> a = neo4jClientRepository.findByMid(mid);
        if (a.isEmpty()) {
            throw new APIException();
        }
        MathematicianVO temp = a.get();
        return new MathematicianFindByMid(
                temp.getMid(),
                temp.getName(),
                temp.getCountry(),
                temp.getTitle(),
                temp.getYear(),
                temp.getInstitution(),
                temp.getDissertation(),
                temp.getClassification() == -1 ? "" : Constant.CLASSIFICATIONARRAY.get(temp.getClassification()),
                temp.getStudents(),
                temp.getAdvisors()
        );
    }

    /**
     * 分页获取数学家
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<MathematicianVO> allMathematicians(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Mathematician> page1 = basicRepository.getList(pageable);
        return page1.map(mathematicianMapper::toMathematicianVO);
    }

    @Override
    public Collection<Map<String, Object>> getCountryCount() {
        Collection<Map<String, Object>> maps = neo4jClientRepository.getCountryCount();
        if (maps == null || maps.isEmpty()) {
            throw new APIException();
        }
        return maps;
    }

    @Override
    public Collection<Map<String, Object>> getInstitutionCount() {
        Collection<Map<String, Object>> maps = neo4jClientRepository.getInstitutionCount();
        if (maps == null || maps.isEmpty()) {
            throw new APIException();
        }
        return maps;
    }

    @Override
    public Collection<Map<String, Object>> getClassificationCount() {
        Collection<Map<String, Object>> maps = neo4jClientRepository.getClassificationCount();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> temp : maps) {
            Map<String, Object> newMap = new HashMap<>(temp);
            int classificationId = ((Long) temp.get("classification")).intValue();
            if (classificationId != -1) {
                newMap.put("classification", Constant.CLASSIFICATIONARRAY.get(classificationId));
            } else {
                newMap.put("classification", "");
            }
            result.add(newMap);
        }
        return result;
    }

    @Override
    public Collection<String> getAllCountry() {
        return basicRepository.getAllCountry();
    }

    @Override
    public Collection<String> getAllClassification() {
        Collection<Long> classificationIds = basicRepository.getAllClassification();
        Collection<String> result = new ArrayList<>();
        for (Long classificationId : classificationIds) {
            result.add(Constant.CLASSIFICATIONARRAY.get(Math.toIntExact(classificationId)));
        }
        return result;
    }

    @Override
    public Collection<RankingVO> getRanking(String[] countries, String[] classifications, Integer start, Integer end, Integer limit) {
        String country, classification, year;
        if (countries.length == 1) {
            if (Objects.equals(countries[0], "all")) {
                country = "";
            } else {
                country = "m.country = " + "\"" + countries[0] + "\"";
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < countries.length; i++) {
                if (i < countries.length - 1) {
                    sb.append("\"").append(countries[i]).append("\"").append(",");
                } else {
                    sb.append("\"").append(countries[i]).append("\"");
                }
            }
            sb.append("]");
            country = "m.country in " + sb;
        }
        if (classifications.length == 1) {
            if (Objects.equals(classifications[0], "all")) {
                classification = "";
            } else {
                classification = "m.classification = " + Constant.CLASSIFICATIONARRAY.indexOf(classifications[0]);
            }
        } else {
            ArrayList<Integer> temp = new ArrayList<>();
            for (String a : classifications) {
                temp.add(Constant.CLASSIFICATIONARRAY.indexOf(a));
            }
            classification = "m.classification in " + temp;
        }
        year = "m.year >= " + start + " and " + "m.year <= " + end;
        StringBuilder query = new StringBuilder("match (m:Mathematician)-[:advisorOf*1..]->(s:Mathematician) where ");
        if (!country.isBlank()) {
            query.append(country).append(" and ");
        }
        if (!classification.isBlank()) {
            query.append(classification).append(" and ");
        }
        query.append(year)
                .append("""
                         return m.mid as mid, m.name as name, m.country as country, m.classification as classificationId, m.year as year, count(distinct s) as descendants
                        order by descendants desc
                        limit
                        """)
                .append(" ")
                .append(limit);
        Collection<Ranking> rankings = neo4jClientRepository.getRanking(query.toString());
        return rankings.stream().map(rankingMapper::toRankingVO).toList();
    }
}
