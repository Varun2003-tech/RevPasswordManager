package com.revpasswordmanager.dao;

import com.revpasswordmanager.util.DBConnection;
import com.revpasswordmanager.util.EncryptionUtil;

import java.sql.*;

public class PasswordDAO {

    public void add(int userId, String account, String username, String password) throws Exception {
        String sql = "INSERT INTO password_entries(user_id,account_name,username,encrypted_password) VALUES(?,?,?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setString(2, account);
            ps.setString(3, username);
            ps.setString(4, EncryptionUtil.encrypt(password));
            ps.executeUpdate();
        }
    }
    public boolean deletePassword(int userId, String accountName) throws Exception {

        String sql =
            "DELETE FROM password_entries " +
            "WHERE user_id = ? AND account_name = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, accountName);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean updatePassword(int userId, String accountName, String newPassword) throws Exception {

        String sql =
            "UPDATE password_entries " +
            "SET encrypted_password = ? " +
            "WHERE user_id = ? AND account_name = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, EncryptionUtil.encrypt(newPassword));
            ps.setInt(2, userId);
            ps.setString(3, accountName);

            return ps.executeUpdate() > 0;
        }
    }

    public void list(int userId) throws Exception {

        String sql = "SELECT account_name, username FROM password_entries WHERE user_id=?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            // Header
            System.out.printf("%-20s | %-20s%n", "Account name", "Username");
            System.out.println("---------------------+---------------------");

            // Rows
            while (rs.next()) {
                System.out.printf(
                    "%-20s | %-20s%n",
                    rs.getString("account_name"),
                    rs.getString("username")
                );
            }
        }
    }

    public String getEncryptedPassword(int userId, String accountName) throws Exception {

        String sql =
            "SELECT encrypted_password FROM password_entries " +
            "WHERE user_id = ? AND account_name = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, accountName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("encrypted_password");
            }
        }
        return null;
    }

}
