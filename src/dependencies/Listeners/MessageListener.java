package dependencies.Listeners;

public interface MessageListener extends UserStatusListener {
    void onMessage(String fromLogin, String messageText);

    void onSend();
}
