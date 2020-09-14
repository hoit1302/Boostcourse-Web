package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {

	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";

	/* 특정 건 select문 */
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null; // 연결
		PreparedStatement ps = null; // 명령 선언할 객체
		ResultSet rs = null; // 결과를 담아낼 객체

		try {
			// 드라이버 로딩. mysql이 제공해주는 클래스가 메모리에 올라오는 작업을 해줘야 함
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 접속할 수 있는 Connection 객체를 얻어오기
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			// 쿼리문 작성
			String sql = "SELECT description, role_id From role WHERE role_id = ?";
			// 퀴리문의 물음표 부분 바뀜
			ps = conn.prepareStatement(sql);
			// 첫번째 물음표에 ~
			ps.setInt(1, roleId);
			// 실행해주세요, 결과값을 resultSet 객체에 담음
			rs = ps.executeQuery();

			if (rs.next()) {
				String description = rs.getString(1); // 첫번째 컬럼(description) 값 꺼내기
				int id = rs.getInt("role_id"); // role_id 컬럼의 값 꺼내기
				role = new Role(id, description);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 반드시 수행

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return role;
	}

	/* 모두 select문 */
	/* 새롭게 추가된 try with resource 문장. 알아서 객체를 닫아줌. finally 문장 X, 권장사항 */
	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			/* 바인딩하는 부분 여기선 필요 X */

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					// 하나씩 꺼내서
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					// Role 인스턴스를 생성하여 정보를 담고
					Role role = new Role(id, description);
					// list에 반복할 때마다 list에 추가한다.
					list.add(role);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/* insert문 */
	public int addRole(Role role) {
		int insertCount = 0; // insert한 건 수
		Connection conn = null;
		PreparedStatement ps = null;
		// iusert 문이기 때문에 resultset 객체는 보이지 않음
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // 트라이버 로딩
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // connection 객체 얻어오기
			String sql = "INSERT INTO role (role_id, description) VALUES (?, ?)";// 쿼리문, 물음표 -> 반드시 값을 바인딩하는 코드 있어야 함
			ps = conn.prepareStatement(sql); // connection객체로부터 prepareStatement 객체를 얻어오기
			ps.setInt(1, role.getRoleId()); // 1번 컬럼 == role_id
			ps.setString(2, role.getDescription()); // 2번 컬럼 == description

			insertCount = ps.executeUpdate(); // insert, update, delete는 executeUpdate라는 메서드 사용. 쿼리가 실행됐을 때 int값 return

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			}
		}

		return insertCount;
	}

	/* delete문 */
	public int deleteRole(Integer roleId) {
		int deleteCount = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);

			String sql = "DELETE FROM role WHERE role_id = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, roleId);

			deleteCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {
				}
			} // if

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			} // if
		} // finally

		return deleteCount;
	}

	/* update문 */
	public int updateRole(Role role) {
		int updateCount = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);

			String sql = "update role set description = ? where role_id = ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());

			updateCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {
				}
			} // if

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			} // if
		} // finally

		return updateCount;
	}
}
