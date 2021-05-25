package com.rainbowland.service.characters;

import com.rainbowland.service.BaseR2dbcService;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

public class CharactersServiceImpl extends BaseR2dbcService implements CharactersService {


    public CharactersServiceImpl(R2dbcEntityTemplate template) {
        super(template);
    }


}
