package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Product;
import static kr.or.connect.reservation.dao.ProductDaoSqls.*;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public Product selectOne(int displayId) {
		Map<String, ?> param = Collections.singletonMap("display_id", displayId);
		return jdbc.queryForObject(SELECT_ONE, param, rowMapper);
	}

	public List<Product> selectAll(int start) {
		Map<String, ?> params = Collections.singletonMap("start", start);
		return jdbc.query(SELECT_ALL, params, rowMapper);
	}

	public List<Product> selectOfCategory(int categoryId, int start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("start", start);
		return jdbc.query(SELECT_OF_CATEGORY, params, rowMapper);
	}

	public int getTotalCount() {
		return jdbc.queryForObject(SELECT_COUNT_All, Collections.emptyMap(), Integer.class);
	}

	public int getCategoryCount(int categoryId) {
		Map<String, ?> param = Collections.singletonMap("category_id", categoryId);
		return jdbc.queryForObject(SELECT_COUNT_CATEGORY, param, Integer.class);
	}
}
