package com.orangesummer.mathgenealogy.model.vo;

import com.orangesummer.mathgenealogy.model.po.KnowledgeFlow;
import com.orangesummer.mathgenealogy.util.Constant;
import lombok.Data;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/20
 */
@Data
public class KnowledgeFlowVO {
    private Double fromLon;
    private Double fromLat;
    private Double toLon;
    private Double toLat;

    public KnowledgeFlowVO(KnowledgeFlow knowledgeFlow) {
        this.fromLon = Constant.COUNTRYLON.get(knowledgeFlow.getFrom());
        this.fromLat = Constant.COUNTRYLAT.get(knowledgeFlow.getFrom());
        this.toLon = Constant.COUNTRYLON.get(knowledgeFlow.getTo());
        this.toLat = Constant.COUNTRYLAT.get(knowledgeFlow.getTo());
    }
}
