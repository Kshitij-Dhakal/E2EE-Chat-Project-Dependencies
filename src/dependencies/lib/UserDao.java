package dependencies.lib;

import dependencies.functions.SecureHash;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

public class UserDao {

    public static UserBean login(String user_handle, String password, String db_username, String db_password) throws ClassNotFoundException, SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        System.out.println("UserDao Login : SQL exectued by " + db_username);
        UserBean userBean = new UserBean();
        userBean.setUser_handle(user_handle);
        userBean.setPassword(password);
        return login(userBean, db_username, db_password);
    }

    public static UserBean login(UserBean bean, String db_username, String db_password) throws SQLException,
            ClassNotFoundException, InvalidKeySpecException, NoSuchAlgorithmException {
        System.out.println("UserDao Login : SQL exectued by " + db_username);
        Connection con = ConnectionManager.getConnection(db_username, db_password);
        String userHandle = bean.getUser_handle();
        String originalPassword = bean.getPassword();
        String sql = "SELECT * FROM users WHERE user_handle='" + userHandle + "'";
//        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            String storedPassword = rs.getString("password");
            boolean validatePassword = SecureHash.validatePassword(originalPassword, storedPassword);
            if (validatePassword) {
                bean.setFirst_name(rs.getString("first_name"));
                bean.setLast_name(rs.getString("last_name"));
                bean.setStatus(STATUS.getStatus(rs.getString("status")));
                bean.setValid(true);
            }
        } else {
            bean.setValid(false);
        }
//		rs.close();
//		st.close();
        con.close();
        return bean;
    }

    public static User getUserInformation(String userHandle, String db_username, String db_password) throws SQLException, ClassNotFoundException {
        System.out.println("UserDao : SQL exectued by " + db_username);
        User user = new User();
        user.setUserHandle(userHandle);
        Connection con = ConnectionManager.getConnection(db_username, db_password);
        String sql = "SELECT user_handle, first_name, last_name FROM users WHERE user_handle='" + userHandle + "'";
//        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
        }
//		rs.close();
//		st.close();
        con.close();
        return user;
    }

    public static UserBean register(UserBean bean, String db_username, String db_password) throws ClassNotFoundException, SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        System.out.println("UserDao : SQL exectued by " + db_username);
        Connection con = ConnectionManager.getConnection(db_username, db_password);
        String userHandle = bean.getUser_handle();
        String sql = "SELECT user_handle FROM users WHERE user_handle='" + userHandle + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            bean.setValid(false);
        } else {
            sql = "INSERT INTO users(user_handle, first_name, last_name, password) VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bean.getUser_handle());
            pst.setString(2, bean.getFirst_name());
            pst.setString(3, bean.getLast_name());
            pst.setString(4, SecureHash.generateStorngPasswordHash(bean.getPassword()));
//			pst.setString(5, "user");
            pst.execute();
            bean.setValid(true);
        }
//		rs.close();
//		st.close();
        con.close();
        return bean;
    }

}