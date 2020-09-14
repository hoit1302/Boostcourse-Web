package kr.or.connect.daoexam.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.*; 
//static import를 사용하면 RoleDaoSqls 객체에 선언된 변수를 클래스 이름 없이 그냥 바로 가져다가 사용할 수 있음

@Repository // 나는 저장소야
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert inserAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	// BeanPropertyRowMapper 객체를 이용해서 column의 값을 자동을 DTO에 담아줌.
	
//	DateSource는 커넥션 풀을 관리하는 목적으로 사용되는 객체. 커넥션을 얻어오고 반납하는 작업 수행
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
//		Spring 버전 4.3부터는 
//		ComponentScan으로 객체를 찾았을 때 기본 생성자가 없다면 자동으로 객체를 주입해줌.
//		DBConfig에서 이렇게 Bean으로 등록했던 DataSource가 파라미터로 전달이 됨.
		this.inserAction = new SimpleJdbcInsert(dataSource)
				.withTableName("role"); //어떤 테이블에 넣을 것인지
	}
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
//	파라미터1 sql: query문을 RoleDaoSqls에 작성해뒀는데 꺼내쓰기
//	파라미터2 paramMap: 비어있는 map객체 선언. 하는 일은 sql 문에 바인딩 할 값이 있을 경우에 바인딩 할 값을 전달할 목적
//	파라미터3 rowMapper: select 한 건 한 건을 Dto에 저장할 목적
//	query() 메서드: 결과가 여러 건이었을 때 내부적으로 반복하면서 DTO를 생성, 생성한 DTO를 List에 담아주는 일을 함.
//	DBMS에서는 column 명이 단어와 단어를 구분할 때 '_'를 사용 (대소문자를 구분하지 않기 때문에)
//	Java에서는 camel 표기법을 이용 (대소문자를 구분하기에)
	}
	
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role); 
		// role 객체를 map으로 바꿔. roleId를 알아서 role_id로 바꿔서 Map 객체 생성 (우와!)
		return inserAction.execute(params);
//		인서트는 좀 다른 친구들과 다름
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
//		SqlParameterSource가 객체에 들어있는 것을 알아서 db column 명에 맞춰 map으로 바꿔주는 일을 수행.
		return jdbc.update(UPDATE, params); // 두번째 파라미터는 맵객체
	}
	
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
//		delete 같은 경우에는 값이 딱 하나만 들어오잖아요. 그랬을 때 또 굳이 객체를 만들어서 이렇게 쓰기는 조금 복잡함.
//		Collections.singletonMap 같은 경우는 값이 여러 개 들어가지 않고 딱 1 건만 넣어서 사용할 때 사용할 수 있음.
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	// 1건 select
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
			// select했는데 해당 조건에 맞는 값이 없다 -> exception 발생. 예외 처리하기
		}catch (EmptyResultDataAccessException e) { 
			return null;
		}
	}

}
//JdbcTemplate은 바인딩할 때 ?를 사용하는데 sql 문자열만 봤을 때 어떤 값이 매핑되는지 알아보기 힘든 문제
//그래서 NamedParameterJdbcTemplate 활용.

//처음들어보는 단축키: ctrl + shift + o import할 때 같은데
//참고사항
//java는 camel 표기법 -> 단어와 단어가 만날 때 대문자를 사용 roleId
//dbms는 단어와 단어가 만날 때 _ 이용(대소문자를 거의 구분하지 않기에) role_id