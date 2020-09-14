package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam3_Select {
	public static void main(String[] args) {
		/* select 여러건 */
		RoleDao dao = new RoleDao();

		List<Role> list = dao.getRoles();

		for (Role role_factor : list)
			System.out.println(role_factor);
	}

}
