package com.orangesummer.mathgenealogy.model.mapstruct;

import com.orangesummer.mathgenealogy.model.po.Mathematician;
import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Mapper(componentModel = "spring")
public interface MathematicianMapper {
    MathematicianMapper INSTANCE = Mappers.getMapper(MathematicianMapper.class);

    MathematicianVO toMathematicianVO(Mathematician mathematician);
}
