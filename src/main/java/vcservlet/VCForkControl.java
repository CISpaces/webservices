package vcservlet;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VCForkControl {

    Logger log;
//    private JsonHelper jsh;

    public VCForkControl(){
//        jsh = new JsonHelper();
        log = Logger.getLogger(getClass().getName());
    }

    public String evalJSON(String input) {
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - SPLIT JSON ***");


        return "";
    }
}
