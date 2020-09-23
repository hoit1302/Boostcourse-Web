package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT_ALL = 
			"SELECT c.id, c.name, COUNT(c.id) as count "
			+ "FROM category AS c "
			+ "LEFT JOIN product AS p "
			+ "ON c.id = p.category_id "
			+ "LEFT JOIN display_info AS d "
			+ "ON p.id = d.product_id "
			+ "GROUP BY c.id";
}
