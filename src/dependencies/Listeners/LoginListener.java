package dependencies.Listeners;

public interface LoginListener {
    void onLoginButtonEvent(String userhandle, String password);

    void onChatServerLogin(String userhandle);
}
