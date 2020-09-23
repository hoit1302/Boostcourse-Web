package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ProductPriceDaoSqls.SELECT_ALL_OF_A_DISPLAY;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ProductPrice;

@Repository
public class ProductPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductPrice> rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	
	public ProductPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductPrice> selectAllOfCategory(int displayId) {
		Map<String, ?> param = Collections.singletonMap("display_id", displayId);
		return jdbc.query(SELECT_ALL_OF_A_DISPLAY, param, rowMapper);
	} 
}
