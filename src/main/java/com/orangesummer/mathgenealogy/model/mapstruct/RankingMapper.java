package com.orangesummer.mathgenealogy.model.mapstruct;

import com.orangesummer.mathgenealogy.model.po.Ranking;
import com.orangesummer.mathgenealogy.model.vo.RankingVO;
import com.orangesummer.mathgenealogy.util.Constant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/23
 */
@Mapper(componentModel = "spring")
public interface RankingMapper {
    @Mapping(source = "classificationId", target = "classification", qualifiedByName = "idToClassification")
    RankingVO toRankingVO(Ranking ranking);

    @Named("idToClassification")
    default String idToClassification(Integer classificationId) {
        if (classificationId == -1) {
            return "";
        }
        return Constant.CLASSIFICATIONARRAY.get(classificationId);
    }
}
