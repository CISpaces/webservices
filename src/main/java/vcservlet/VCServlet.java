package vcservlet;

import javax.servlet.ServletConfig;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/hello")
public class VCServlet {

//    private boolean PRINT;
    private static Logger log;

    public VCServlet(){
        log = Logger.getLogger(getClass().getName());
    }

    @GET
    @Produces("text/html")
    public String sayHello(){
        return "Hello Jersey";
    }

    @Context
    ServletConfig context;
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getJSONInput(String input){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - New Request ***");

        VCForkControl vcControl = new VCForkControl();
        String out = vcControl.evalJSON(input);

        log.log(Level.INFO,"*** VERSION CONTROL SERVICE - Request Handled ***");

        return out;
    }

}
