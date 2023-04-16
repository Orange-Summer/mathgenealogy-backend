package com.orangesummer.mathgenealogy.model.mapstruct;

import com.orangesummer.mathgenealogy.model.po.Mathematician;
import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import org.mapstruct.Mapper;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Mapper(componentModel = "spring")
public interface MathematicianMapper {
    MathematicianVO toMathematicianVO(Mathematician mathematician);
}
