package com.github.mmo.game.service.domain.reputation;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepSpilloverTemplate {

	public int factionId;

    public int[] faction = new int[5];
    public float[] factionRate = new float[5];
    public int[] factionRank = new int[5];

	public static class ResultExtractor implements ResultSetExtractor<RepSpilloverTemplate> {
		@Override
		public RepSpilloverTemplate extractData(ResultSet rs) throws SQLException, DataAccessException {
			RepSpilloverTemplate repTemplate = new RepSpilloverTemplate();
			int index = 1;
			repTemplate.factionId = rs.getInt(index++);
			repTemplate.faction[0] = rs.getInt(index++);
			repTemplate.factionRate[0] = rs.getFloat(index++);
			repTemplate.factionRank[0] = rs.getInt(index++);
			repTemplate.faction[1] = rs.getInt(index++);
			repTemplate.factionRate[1] = rs.getFloat(index++);
			repTemplate.factionRank[1] = rs.getInt(index++);
			repTemplate.faction[2] = rs.getInt(index++);
			repTemplate.factionRate[2] = rs.getFloat(index++);
			repTemplate.factionRank[2] = rs.getInt(index++);
			repTemplate.faction[3] = rs.getInt(index++);
			repTemplate.factionRate[3] = rs.getFloat(index++);
			repTemplate.factionRank[3] = rs.getInt(index++);
			repTemplate.faction[4] = rs.getInt(index++);
			repTemplate.factionRate[4] = rs.getFloat(index++);
			repTemplate.factionRank[4] = rs.getInt(index++);
			return repTemplate;
		}
	}
}
