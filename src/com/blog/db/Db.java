package com.blog.db;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.enity.User;

public class Db {
	public static void main(String[] args) {

		String sql="select  * from t_user";
		List<User> list = Db.select1(sql, User.class);
		for (User user : list) {
			System.out.println(user);
		}
	}

	public static <T> List<T> select1(String sql, Class<T> cl) {
		List<T> list = new ArrayList<>();
		try {
			Connection conn = DbConnection.getConnection();
			// 创建一个"小手"
			Statement statement = conn.createStatement();
			// 通过我们这个小手执行我们的sql拿回数据
			ResultSet resultSet = statement.executeQuery(sql);
			// 遍历结果集

			try {
				while (resultSet.next()) {
					T t = cl.newInstance();
					Field[] declaredFields = cl.getDeclaredFields();
					AccessibleObject.setAccessible(declaredFields, true);
					for (Field field : declaredFields) {
						field.set(t, resultSet.getObject(field.getName()));
					}
					list.add(t);
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
