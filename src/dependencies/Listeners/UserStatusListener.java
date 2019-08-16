package dependencies.Listeners;

import dependencies.lib.UserBean;

public interface UserStatusListener {
    void online(UserBean login);

    void offline(UserBean login);
}
