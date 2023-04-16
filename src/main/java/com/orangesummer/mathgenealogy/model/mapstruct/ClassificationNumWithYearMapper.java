package com.orangesummer.mathgenealogy.model.mapstruct;

import com.orangesummer.mathgenealogy.model.po.ClassificationNumWithYear;
import com.orangesummer.mathgenealogy.model.vo.ClassificationNumWithYearVO;
import com.orangesummer.mathgenealogy.util.Constant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/15
 */
@Mapper(componentModel = "spring")
public interface ClassificationNumWithYearMapper {
    @Mapping(source = "classificationId", target = "classification",qualifiedByName = "idToClassification")
    ClassificationNumWithYearVO toClassificationNumWithYearVO(ClassificationNumWithYear classificationNumWithYear);

    @Named("idToClassification")
    default String idToClassification(Integer classificationId) {
        return Constant.CLASSIFICATIONARRAY.get(classificationId);
    }
}
