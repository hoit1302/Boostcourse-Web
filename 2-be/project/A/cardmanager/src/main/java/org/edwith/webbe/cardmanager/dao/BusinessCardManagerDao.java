package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;
import org.edwith.webbe.cardmanager.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardManagerDao {

	public List<BusinessCard> searchBusinessCard(String keyword) {
		List<BusinessCard> businessCards = new ArrayList<>();
		SimpleDateFormat f1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		String sql = "SELECT name, phone, companyName, date FROM card WHERE name like '%" + keyword + "%'";

		try (Connection conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String name = rs.getString(1);
				String phone = rs.getString(2);
				String companyName = rs.getString(3);
				String date = rs.getString(4);

				BusinessCard businessCard = new BusinessCard(name, phone, companyName);
				businessCard.setCreateDate(f1.parse(date));

				businessCards.add(businessCard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return businessCards;
	}

	public BusinessCard addBusinessCard(BusinessCard businessCard) {

		SimpleDateFormat f1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		String sql = "INSERT INTO card (name, phone, companyName, date) VALUES (?, ?, ?, ?)";

		try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, businessCard.getName());
			ps.setString(2, businessCard.getPhone());
			ps.setString(3, businessCard.getCompanyName());
			ps.setString(4, f1.format(businessCard.getCreateDate()));
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return businessCard;
	}
}
