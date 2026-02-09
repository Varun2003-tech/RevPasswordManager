package com.revpasswordmanager.service;

import com.revpasswordmanager.dao.UserDAO;
import com.revpasswordmanager.dao.SecurityDAO;
import com.revpasswordmanager.util.EncryptionUtil;
import com.revpasswordmanager.validation.PasswordValidator;

public class UserService {

    private UserDAO dao = new UserDAO();
    private SecurityDAO securityDAO = new SecurityDAO();

    // ================= REGISTER =================
    public void registerWithSecurityQuestion(
            String name,
            String email,
            String password,
            String question,
            String answer
    ) throws Exception {

        if (!PasswordValidator.isStrong(password)) {
            throw new IllegalArgumentException(
                "Password must be strong (8 chars, upper, lower, digit, special)"
            );
        }

        if (dao.emailExists(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        dao.register(name, email, password);

        int userId = dao.getUserIdByEmail(email);
        securityDAO.addQuestion(userId, question, answer);
    }
    
    public boolean emailExists(String email) throws Exception {
        return dao.emailExists(email);
    }


    // ================= LOGIN =================
    public int login(String email, String password) throws Exception {
        return dao.login(email, password);
    }

    // ================= UPDATE NAME =================
    public boolean updateName(int userId, String name) throws Exception {
        return dao.updateName(userId, name);
    }

    // ================= UPDATE EMAIL =================
    public void updateEmail(int userId, String newEmail) throws Exception {

        String currentEmail = dao.getEmailByUserId(userId);

        if (currentEmail != null && currentEmail.equalsIgnoreCase(newEmail)) {
            throw new IllegalArgumentException("Email already exists (same as current)");
        }

        if (dao.emailExists(newEmail)) {
            throw new IllegalArgumentException("Email already in use by another account");
        }

        dao.updateEmail(userId, newEmail);
    }

    // ================= RESET PASSWORD =================
    public void resetPassword(int userId, String newPassword) throws Exception {

        if (!PasswordValidator.isStrong(newPassword)) {
            throw new IllegalArgumentException("Weak password");
        }

        dao.updatePassword(userId, newPassword);
    }

    // ================= VERIFY MASTER PASSWORD =================
    public boolean verifyMasterPassword(int userId, String inputPassword) throws Exception {
        String storedHash = dao.getMasterPasswordHash(userId);
        return EncryptionUtil.verify(inputPassword, storedHash);
    }

    // ================= FIND USER =================
    public int findUserByEmail(String email) throws Exception {
        return dao.getUserIdByEmail(email);
    }
}
