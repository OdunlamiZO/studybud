package odunlamizo.util;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;

public final class PasswordUtils {

    private static PasswordEncryptor encryptor;

    static {
        encryptor = new BasicPasswordEncryptor();
    }

    private PasswordUtils() {}

    public static String encryptPassword(String password) {
        return encryptor.encryptPassword(password);
    }

    public static boolean checkPassword(String plainPassword, String encryptedPassword) {
        return encryptor.checkPassword(plainPassword, encryptedPassword);
    }
    
}