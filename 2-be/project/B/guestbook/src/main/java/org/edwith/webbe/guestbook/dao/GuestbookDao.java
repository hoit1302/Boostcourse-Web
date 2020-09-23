package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDao {


	public List<Guestbook> getGuestbooks() {
		List<Guestbook> guestbooks = new ArrayList<>();
		String sql = "SELECT * FROM guestbook ORDER BY id DESC";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Guestbook guestbook = new Guestbook(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4));
				guestbooks.add(guestbook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return guestbooks;
	}


	public void addGuestbook(Guestbook guestbook) {

		String sql = "INSERT INTO guestbook (name, content, regdate) VALUES (?, ?, NOW())";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, guestbook.getName());
			ps.setString(2, guestbook.getContent());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
