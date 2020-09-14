package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam5_update {

	public static void main(String[] args) {
		//수정테스트
		int roleId = 500;
		String description = "CEO";
		
		Role role = new Role(roleId, description);		
		RoleDao dao = new RoleDao();
		
		int updateCount = dao.updateRole(role);
		System.out.println(updateCount);
	} 

}
