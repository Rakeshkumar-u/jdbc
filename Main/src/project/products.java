package project;

import java.sql.*;
import java.util.*;

public class products {
	Scanner sc = new Scanner(System.in);

	public void login() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:8888/admin", "root", "123456789");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			String login = "select * from admin.products where pname = ? and pprice = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(login);
			System.out.println("Admin Login");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Password: ");
			int pass = sc.nextInt();
			ps.setString(1, name);
			ps.setInt(2, pass);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Login");
			} else {
				System.out.println("Couldn't Login");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}