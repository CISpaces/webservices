package filters;


import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class KeyGenerator {
    public static Key generateKey() {
        String keyString = "simplekey";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        return key;
    }
}
