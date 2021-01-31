package springMVC.member;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("SELECT * FROM MEMBER WHERE EMAIL = ?", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Long id = rs.getLong("ID");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				String name = rs.getString("NAME");
				LocalDateTime redDate = rs.getTimestamp("REGDATE").toLocalDateTime();

				Member member = new Member(email, password, name, redDate);
				member.setId(id);

				return member;
			}
		}, email);

		return results.isEmpty() ? null : results.get(0);
	}

	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("SELECT * FROM MEMBER", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Long id = rs.getLong("ID");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				String name = rs.getString("NAME");
				LocalDateTime redDate = rs.getTimestamp("REGDATE").toLocalDateTime();

				Member member = new Member(email, password, name, redDate);
				member.setId(id);

				return member;
			}
		});

		return results;
	}

	public int getCount() {
		Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Integer.class);
		return count;
	}

	public void updateMember(Member member) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE MEMBER");
		sql.append("   SET NAME = ?");
		sql.append("       , PASSWORD = ?");
		sql.append(" WHERE EMAIL = ?");
		jdbcTemplate.update(sql.toString(), member.getName(), member.getPassword(), member.getEmail());
	}

	public void insertMember(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO MEMBER (EMAIL, PASSWORD, NAME, REGDATE) VALUES (?, ?, ?, ?)", new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, String.valueOf(Timestamp.valueOf(member.getRegisterDateTime())));

				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
}