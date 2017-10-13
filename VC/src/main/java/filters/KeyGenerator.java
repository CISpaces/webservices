package filters;

import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.security.Key;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyGenerator {

    private final static Logger log = Logger.getLogger(KeyGenerator.class.getName());

    public static Key generateKey() {

        Properties prop = new Properties();
        InputStream input = null;

        try{

            ClassLoader classLoader = KeyGenerator.class.getClassLoader();
            input = classLoader.getResourceAsStream("key.properties");
            prop.load(input);

            String keyString = prop.getProperty("keyString");
            log.info("#### Read JWT authentication key from file");

            Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
            return key;

        } catch (java.io.IOException exc) {

            log.severe("#### Failed to load JWT key from file" + exc);
            exc.printStackTrace();

        } finally {

            if (input != null) {
                try {
                    input.close();
                } catch (java.io.IOException exc) {
                    log.log(Level.SEVERE, "#### Failed to close properties file", exc);
                    exc.printStackTrace();
                }
            }

        }

        return null;
    }
}
