package kr.or.connect.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.guestbook.dao.GuestbookDao;
import kr.or.connect.guestbook.dao.LogDao;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.dto.Log;
import kr.or.connect.guestbook.service.GuestbookService;

@Service // service layer
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired // 빈 자동 등록
	GuestbookDao guestbookDao;
	
	@Autowired
	LogDao logDao;

	@Override
	@Transactional
	public List<Guestbook> getGuestbooks(Integer start) {
		List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		return list;
		// 2번째 파라미터: 몇 개를 가지고 올건지
	}

	@Override
	@Transactional(readOnly=false) // 이 메서드는 readOnly가 아님. readOnly로 수행하면 트랜잭션 적용 X. DB에 제대로 입력하기 위해 
//	근데 검색 결과 readOnly의 default값이 false임. 명시적으로 표현하기 위해 
//	https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html#readOnly--
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		return deleteCount;
	}

	@Override
	@Transactional(readOnly=false)
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		guestbook.setId(id);
		
//		if(1 == 1)
//			throw new RuntimeException("test exception");
//		Transaction: 서비스를 나눌 수 없는 하나의 작업 단위 ! (잘 설명해줌)
//		addGuestbook 끝까지 다 성공해야지만 반영
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		

		return guestbook;
	}

	@Override
	public int getCount() {
		return guestbookDao.selectCount();
	}
	
}