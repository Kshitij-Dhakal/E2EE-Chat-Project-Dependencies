package dependencies.Listeners;

import dependencies.User.User;

public interface UserStatusListener {
    void online(User login);

    void offline(User login);
}
