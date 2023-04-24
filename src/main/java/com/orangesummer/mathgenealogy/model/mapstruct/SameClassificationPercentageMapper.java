package com.orangesummer.mathgenealogy.model.mapstruct;

import com.orangesummer.mathgenealogy.model.po.SameClassificationPercentage;
import com.orangesummer.mathgenealogy.model.vo.SameClassificationPercentageVO;
import com.orangesummer.mathgenealogy.util.Constant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/24
 */
@Mapper(componentModel = "spring")
public interface SameClassificationPercentageMapper {

    @Mapping(source = "classificationId", target = "classification", qualifiedByName = "idToClassification")
    SameClassificationPercentageVO toSameClassificationPercentageVO(SameClassificationPercentage sameClassificationPercentage);

    @Named("idToClassification")
    default String idToClassification(Integer classificationId) {
        if (classificationId == -1) {
            return "";
        }
        return Constant.CLASSIFICATIONARRAY.get(classificationId);
    }
}
