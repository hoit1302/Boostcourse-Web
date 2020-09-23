package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Product;

public interface ProductService {
	List<Product> getProducts(int start);
	List<Product> getProducts(int categoryId, int start);
	Product getOneProduct(int displayId);
	int getTotalCount();
	int getTotalCount(int categoryId);
}
