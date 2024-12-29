package com.github.mmo.game.service.model.reputation;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepSpilloverTemplate {

	public int factionId;

    public int[] faction = new int[5];
    public float[] factionRate = new float[5];
    public int[] factionRank = new int[5];

}
