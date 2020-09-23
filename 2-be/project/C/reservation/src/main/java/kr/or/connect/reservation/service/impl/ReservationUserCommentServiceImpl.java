package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationUserCommentDao;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.ReservationUserCommentService;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService{

	@Autowired
	ReservationUserCommentDao reservationUserCommentDao;
	
	@Override
	@Transactional
	public List<ReservationUserComment> getComments(int productId, int start) {
		List<ReservationUserComment> reservationUserComment = reservationUserCommentDao.select(productId, start);
		return reservationUserComment;
	}

	@Override
	@Transactional
	public int getCount(int productId) {
		return 0;
	}

}
