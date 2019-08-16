/**
 *
 */
package dependencies.lib;

import java.io.Serializable;

public class UserBean extends User implements Serializable {
    private boolean valid;
    private STATUS status;
    private int message = 0;

    /**
     *
     */
    public UserBean() {
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

    @Override
    public String toString() {
        return this.userHandle + "~" + this.firstName + "~" + this.lastName;
    }

    public void addMessage() {
        this.message++;
    }

    public void resetMessage() {
        this.message = 0;
    }

    public int getMessage() {
        return message;
    }
}
