package kr.or.connect.daoexam.dao;
// :(콜론)이 나오는 곳은 값이 나중에 바인딩 될 부분
public class RoleDaoSqls {
	public static final String SELECT_ALL = "Select role_id, description FROM role ORDER BY role_id";
	public static final String UPDATE = "UPDATE role set description = :description WHERE role_id = :roleId";
	public static final String SELECT_BY_ROLE_ID = "Select role_id, description FROM role WHERE role_id = :roleId";
	public static final String DELETE_BY_ROLE_ID = "DELETE FROM role WHERE role_id = :roleId";
}
