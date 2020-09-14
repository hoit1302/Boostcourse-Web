package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam1_Select1 {

	public static void main(String[] args) {
		/* select 특정 (where 절) */
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);

	}

}
