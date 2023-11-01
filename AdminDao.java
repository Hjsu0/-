package com.gec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gec.model.Admin;
import com.gec.model.Student;
import com.gec.utils.JdbcUtils;

public class AdminDao {
	public Admin getAdminByName(String name) 
		throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from admin s where name=?";
		PreparedStatement psmt = conn.prepareStatement( sql );
		psmt.setString(1, name);
		ResultSet rs = psmt.executeQuery();
		Admin admin = null;
		if ( rs.next() ) {
			admin = packageAdmin(rs);
		}
		JdbcUtils.closeRES(psmt,rs);
		return admin;
	}
	
	private Admin packageAdmin(ResultSet rs) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getInt("id"));
		admin.setName(rs.getString("name"));
		admin.setPassword(rs.getString("password"));
		admin.setCreateDate(rs.getString("createDate"));
		return admin;
	}
	
	
	
}
