package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.AvgScoreDao;
import kr.or.connect.reservation.dto.AvgScore;
import kr.or.connect.reservation.service.AvgScoreService;

@Service
public class AvgScoreServiceImpl implements AvgScoreService {

	@Autowired
	AvgScoreDao avgScoreDao;
	
	@Override
	public int getAvgScore(int displayId) {
		AvgScore avgScore = avgScoreDao.getAvgScore(displayId);
		double scoreSum = avgScore.getSum();
		int totalNum = avgScore.getCount();
		if (totalNum == 0)
			return 0;
		return (int)(scoreSum/totalNum);
	}

}
