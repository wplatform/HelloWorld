package com.rainbowland.service.world;

import com.rainbowland.service.BaseR2dbcService;
import com.rainbowland.service.hotfixes.HotfixesService;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

public class WorldServiceImpl extends BaseR2dbcService implements WorldService {


    public WorldServiceImpl(R2dbcEntityTemplate template) {
        super(template);
    }


}
