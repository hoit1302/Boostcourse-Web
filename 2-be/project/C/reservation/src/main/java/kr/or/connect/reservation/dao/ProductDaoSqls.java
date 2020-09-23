package kr.or.connect.reservation.dao;

public class ProductDaoSqls {

	public static final String SELECT_ONE = "SELECT "
			+ "di.id, p.category_id, dii.display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, p.create_date, p.modify_date, pi.file_id "
			+ "FROM display_info AS di " + "LEFT JOIN product AS p ON di.product_id = p.id "
			+ "LEFT JOIN display_info_image AS dii ON di.product_id = dii.id "
			+ "LEFT JOIN category AS c ON p.category_id = c.id "
			+ "LEFT JOIN product_image AS pi ON di.product_id = pi.product_id " 
			+ "WHERE pi.type = \'ma\' and di.id = 1";
	
	public static final String SELECT_ALL = 
			"SELECT\r\n" + 
			"di.id, p.category_id, dii.display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, p.create_date, p.modify_date, pi.file_id\r\n" + 
			"FROM display_info AS di\r\n" + 
			"JOIN (SELECT @rownum :=0) AS R ON 1=1\r\n" + 
			"LEFT JOIN product AS p ON di.product_id = p.id\r\n" + 
			"LEFT JOIN display_info_image AS dii ON di.product_id = dii.id\r\n" + 
			"LEFT JOIN category AS c ON p.category_id = c.id\r\n" + 
			"LEFT JOIN product_image AS pi ON di.product_id = pi.product_id AND pi.type = 'ma'\r\n" + 
			"WHERE di.id BETWEEN :start+1 AND :start+4";

	public static final String SELECT_OF_CATEGORY = 
			"SELECT id, category_id, display_info_id, name, description, content, event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, file_id FROM\r\n" + 
			"(SELECT\r\n" + 
			"@rownum := @rownum+1 AS RNUM, di.id, p.category_id, dii.display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, p.create_date, p.modify_date, pi.file_id\r\n" + 
			"FROM display_info AS di\r\n" + 
			"JOIN (SELECT @rownum :=0) AS R ON 1=1\r\n" + 
			"LEFT JOIN product AS p ON di.product_id = p.id\r\n" + 
			"LEFT JOIN display_info_image AS dii ON di.product_id = dii.id\r\n" + 
			"LEFT JOIN category AS c ON p.category_id = c.id\r\n" + 
			"LEFT JOIN product_image AS pi ON di.product_id = pi.product_id AND pi.type = 'ma'\r\n" + 
			"WHERE c.id = :category_id\r\n" + 
			"ORDER BY di.id) AS product\r\n" + 
			"WHERE RNUM BETWEEN :start+1 AND :start+4";
	
	public static final String SELECT_COUNT_All = "SELECT count(*) FROM display_info";

	public static final String SELECT_COUNT_CATEGORY = "SELECT count(*) FROM display_info AS di "
			+ "LEFT JOIN product AS p ON di.product_id = p.id " + "WHERE p.category_id = :category_id";
	
}
