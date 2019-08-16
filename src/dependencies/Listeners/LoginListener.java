package dependencies.Listeners;

import dependencies.lib.UserBean;

public interface LoginListener {
    void onLoginButtonEvent(UserBean bean);

    void onChatServerLogin(UserBean bean);
}
