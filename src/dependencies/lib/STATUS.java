package dependencies.lib;

/**
 * @author dhaka
 *
 */
public enum STATUS {
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
