package filters;


import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class KeyGenerator {
    public static Key generateKey() {
        //FIXME - This needs to be generated randomly at install time.
        String keyString = "4egte#;!";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        return key;
    }
}
