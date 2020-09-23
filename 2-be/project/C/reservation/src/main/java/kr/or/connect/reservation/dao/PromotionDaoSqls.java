package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
	public static final String SELECT_ALL = 
			"SELECT pm.id, pm.product_id, pd.category_id, c.name as category_name, pd.description, i.file_id "
			+ "FROM promotion AS pm "
			+ "LEFT JOIN product AS pd ON pm.product_id = pd.id "
			+ "LEFT JOIN category AS c ON pd.category_id = c.id "
			+ "LEFT JOIN product_image AS i ON pd.id = i.product_id "
			+ "WHERE i.type = \"ma\"";
}
