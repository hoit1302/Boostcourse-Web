package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationUserComment;

public interface ReservationUserCommentService {
	List<ReservationUserComment> getComments(int productId, int start);
	int getCount(int productId);
}
