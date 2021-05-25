package com.rainbowland.service.hotfixes;

import com.rainbowland.service.BaseR2dbcService;
import com.rainbowland.service.characters.CharactersService;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

public class HotfixesServiceImpl extends BaseR2dbcService implements HotfixesService {


    public HotfixesServiceImpl(R2dbcEntityTemplate template) {
        super(template);
    }


}
