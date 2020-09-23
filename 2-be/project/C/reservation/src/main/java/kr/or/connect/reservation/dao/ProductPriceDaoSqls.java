package kr.or.connect.reservation.dao;

public class ProductPriceDaoSqls {
	public static final String SELECT_ALL_OF_A_DISPLAY = 
			"SELECT \r\n" + 
			"pp.id, pp.product_id, pp.price_type_name, pp.price, pp.discount_rate, pp.create_date, pp.modify_date \r\n" + 
			"FROM display_info AS di\r\n" + 
			"LEFT JOIN product_price AS pp ON di.product_id = pp.product_id\r\n" + 
			"WHERE di.id = :display_id\r\n" + 
			"order by pp.price";
}
