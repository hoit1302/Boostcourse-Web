package kr.or.connect.reservation.dao;

public class ProductImageDaoSqls {
	public static final String SELECT_ONE = 
			"SELECT "
			+ "di.product_id, pi.id as product_image_id, pi.type, pi.file_id as file_info_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, di.create_date, di.modify_date " + 
			"FROM display_info AS di " + 
			"LEFT JOIN product_image AS pi ON di.product_id = pi.product_id AND pi.type = \'ma\' " + 
			"LEFT JOIN file_info AS fi ON pi.file_id = fi.id " + 
			"WHERE di.id = :display_id";

}
