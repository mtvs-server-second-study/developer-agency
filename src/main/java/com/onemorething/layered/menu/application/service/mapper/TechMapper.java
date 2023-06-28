package com.onemorething.layered.menu.application.service.mapper;

import com.onemorething.layered.menu.application.dto.TechDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.Tech;

public class TechMapper {

    public TechDTO techToTechDTO(Tech tech){
        TechDTO techDTO = new TechDTO(tech.getTechSeq(), tech.getTechName());
        return techDTO;
    }

}
