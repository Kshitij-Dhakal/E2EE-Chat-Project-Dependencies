/**
 *
 */
package dependencies.lib;

import java.io.Serializable;

/**
 * @author dhaka
 *
 */
enum STATUS {
    ADMIN, MODERATOR, USER;

    public static STATUS getStatus(String status) {
        if (status.equalsIgnoreCase("admin")) {
            return ADMIN;
        } else if (status.equalsIgnoreCase("moderator")) {
            return MODERATOR;
        } else {
            return USER;
        }
    }
}

public class UserBean implements Serializable {
    private boolean valid;
    private String user_handle;
    private String first_name;
    private String last_name;
    private String password;
    private STATUS status;

    /**
     *
     */
    public UserBean() {
    }

    /**
     * @return the user_handle
     */
    public String getUser_handle() {
        return user_handle;
    }

    /**
     * @param user_handle the user_handle to set
     */
    public void setUser_handle(String user_handle) {
        this.user_handle = user_handle;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the status
     */
    public STATUS getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(STATUS status) {
        this.status = status;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @param valid the valid to set
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
