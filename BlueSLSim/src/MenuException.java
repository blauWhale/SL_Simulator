/**
 * A simple Exception Class that will catch and throw if the Menu has an Exception
 */
public class MenuException extends Exception {
    public MenuException(String message) {
        super (message);
    }

    public MenuException(Throwable cause) {
        super (cause);
    }

    public MenuException(String message, Throwable cause) {
        super (message, cause);
    }
}
