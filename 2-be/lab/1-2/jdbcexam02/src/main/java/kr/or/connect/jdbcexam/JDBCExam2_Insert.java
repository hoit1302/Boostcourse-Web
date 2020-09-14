package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2_Insert {

	public static void main(String[] args) {
		/* insert */
		int roleId = 500;
	    String description = "CTO";
	    
	    Role role = new Role(roleId, description);
	    
	    RoleDao dao = new RoleDao();
	    int insertCount = dao.addRole(role);
	 
	    System.out.println(insertCount);
	}

}
