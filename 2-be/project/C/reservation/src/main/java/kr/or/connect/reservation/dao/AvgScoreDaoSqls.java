package kr.or.connect.reservation.dao;

public class AvgScoreDaoSqls {
	public static final String SELECT =
			"SELECT count(c.id) AS count, SUM(c.score) AS sum\r\n" + 
			"FROM display_info AS d\r\n" + 
			"LEFT JOIN reservation_user_comment AS c ON c.product_id = d.product_id\r\n" + 
			"WHERE d.id = :display_id";
}
