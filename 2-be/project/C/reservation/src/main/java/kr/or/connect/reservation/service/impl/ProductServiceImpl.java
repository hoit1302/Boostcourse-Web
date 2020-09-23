package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	

	@Override // 상세페이지
	public Product getOneProduct(int displayId) {
		Product product = productDao.selectOne(displayId);
		return product;
	}
	@Override
	public List<Product> getProducts(int start) {
		List<Product> products = productDao.selectAll(start);
		return products;
	}
	@Override
	public List<Product> getProducts(int categoryId, int start) {
		List<Product> products = productDao.selectOfCategory(categoryId, start);
		return products;
	}

	@Override
	public int getTotalCount() {
		int totalCount = productDao.getTotalCount();
		return totalCount;
	}
	@Override
	public int getTotalCount(int categoryId) {
		int totalCount = productDao.getCategoryCount(categoryId);
		return totalCount;
	}	
	
}
