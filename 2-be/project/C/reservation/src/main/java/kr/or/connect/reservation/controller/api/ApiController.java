package kr.or.connect.reservation.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.AvgScoreService;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.DisplayInfoImageService;
import kr.or.connect.reservation.service.ProductImageService;
import kr.or.connect.reservation.service.ProductPriceService;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.PromotionService;
import kr.or.connect.reservation.service.ReservationUserCommentService;

@RestController

@RequestMapping(path = "/api")
public class ApiController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	PromotionService promotionService;
	@Autowired
	ReservationUserCommentService reservationUserCommentService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	DisplayInfoImageService displayInfoImageService;
	@Autowired
	ProductPriceService productPriceService;
	@Autowired
	AvgScoreService  avgScoreService;

	@GetMapping("/categories")
	@ApiOperation(value = "카테고리 목록 구하기")
	public Map<String, Object> categories() {
		List<Category> categories = categoryService.getCategories();

		Map<String, Object> map = new HashMap<>();
		map.put("size", categories.size());
		map.put("items", categories);

		return map;
	}

	@GetMapping("/displayinfos")
	@ApiOperation(value = "상품 목록 구하기")
	public Map<String, Object> displayinfos(@RequestParam(name = "categoryId", required = false) Integer categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		Map<String, Object> map = new HashMap<>();
		if (ObjectUtils.isEmpty(categoryId)) {
			List<Product> products = productService.getProducts(start);
			map.put("totalCount", productService.getTotalCount());
			map.put("productCount", products.size());
			map.put("products", products);
		} else {
			List<Product> products =productService.getProducts(categoryId, start);
			map.put("totalCount", productService.getTotalCount(categoryId));
			map.put("productCount", products.size());
			map.put("products", products);
		}
		return map;
	}

	@GetMapping("/promotions")
	@ApiOperation(value = "프로모션 목록 구하기")
	public Map<String, Object> promotions() {
		List<Promotion> items = promotionService.getPromotions();

		Map<String, Object> map = new HashMap<>();
		map.put("size", items.size());
		map.put("items", items);

		return map;
	}

	@GetMapping("/displayinfos/{displayId}")
	@ApiOperation(value = "전시 정보 구하기")
	public Map<String, Object> displayinfos(@PathVariable(name = "displayId") int displayId) {
		Map<String, Object> map = new HashMap<>();
		map.put("product", productService.getOneProduct(displayId));
		map.put("productImages", productImageService.getProductImage(displayId));
//		map.put("displayInfoImages", displayInfoImageService.getDisplayInfoImage(displayId));
		map.put("avgScore", avgScoreService.getAvgScore(displayId));
		map.put("productPrices", productPriceService.getProductPrice(displayId));

		return map;
	}

	@GetMapping("/comment")
	@ApiOperation(value = "댓글 목록 구하기")
	public Map<String, Object> comments(@RequestParam(name = "productId", required = false) int productId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		Map<String, Object> map = new HashMap<>();

		List<ReservationUserComment> reservationUserComments = reservationUserCommentService.getComments(productId,
				start);
		map.put("totalCount", reservationUserCommentService.getCount(productId));
		map.put("commentCount", reservationUserComments.size());
		map.put("reservationUserComments", reservationUserComments);

		return map;
	}

}
