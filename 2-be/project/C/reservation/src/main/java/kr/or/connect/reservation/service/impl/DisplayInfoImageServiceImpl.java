package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.DisplayInfoImageDao;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.service.DisplayInfoImageService;

@Service
public class DisplayInfoImageServiceImpl implements DisplayInfoImageService {

	@Autowired
	DisplayInfoImageDao displayInfoImageDao;
	
	@Override
	@Transactional
	public DisplayInfoImage getDisplayInfoImage(int displayId) {
		DisplayInfoImage displayInfoImage = displayInfoImageDao.selectOne(displayId);
		return displayInfoImage;
	}

}
