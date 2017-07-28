package vcservlet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/")
public class VCServlet {

//    private boolean PRINT;
    private static Logger log;

    public VCServlet(){
        log = Logger.getLogger(getClass().getName());
    }

    @GET
    @Path("/getInfo")
    @Produces("text/html")
    public String sayHello(){
        return "Hello Jersey";
    }


    @Path("/postEdge")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getJSONInputEdge(String input){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - New Edge Request ***");

        VCForkControl vcControl = new VCForkControl();
        String out = vcControl.evalJSONEdge(input);

        log.log(Level.INFO,"*** VERSION CONTROL SERVICE - Edge Request Handled ***");

        return out;
    }

    @Path("/postNode")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getJSONInputNode(String input){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - New Node Request ***");

        VCForkControl vcControl = new VCForkControl();
        String out = vcControl.evalJSONNode(input);

        log.log(Level.INFO,"*** VERSION CONTROL SERVICE - Node Request Handled ***");

        return out;
    }

}
