package dependencies.Listeners;

import dependencies.lib.User;

public interface UserStatusListener {
    void online(User login);

    void offline(User login);
}
