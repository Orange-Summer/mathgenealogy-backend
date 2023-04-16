package com.orangesummer.mathgenealogy.model.mapstruct;

import com.orangesummer.mathgenealogy.model.po.ClassificationNum;
import com.orangesummer.mathgenealogy.model.vo.ClassificationNumVO;
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
public interface ClassificationNumMapper {
    @Mapping(source = "classificationId", target = "classification",qualifiedByName = "idToClassification")
    ClassificationNumVO toClassificationNumVO(ClassificationNum classificationNum);

    @Named("idToClassification")
    default String idToClassification(Integer classificationId) {
        return Constant.CLASSIFICATIONARRAY.get(classificationId);
    }
}
