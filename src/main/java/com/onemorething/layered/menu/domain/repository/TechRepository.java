package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Tech;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TechRepository {

    List<Tech> getTechList();
}
