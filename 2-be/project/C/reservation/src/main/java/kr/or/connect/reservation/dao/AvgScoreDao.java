package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.AvgScoreDaoSqls.SELECT;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.AvgScore;

@Repository
public class AvgScoreDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<AvgScore> rowMapper = BeanPropertyRowMapper.newInstance(AvgScore.class);
	
	public AvgScoreDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public AvgScore getAvgScore(int displayId) {
		Map<String, ?> param = Collections.singletonMap("display_id", displayId);
		return jdbc.queryForObject(SELECT, param, rowMapper);
	}
}
