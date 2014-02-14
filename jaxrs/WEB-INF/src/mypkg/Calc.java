package mypkg;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Sets the path to base URL + /hello
@Path("/calc")
public class Calc {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/help")
    public String help() {
        return "Faça a sua parte.";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/soma")
    public String doSoma(@QueryParam("arg1") String arg1, @QueryParam("arg2") String arg2) {
        return String.format("A soma de %s e %s é %s.", arg1, arg2,
            (Integer.parseInt(arg1) + Integer.parseInt(arg2)));
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/subt")
    public String doSubt(@QueryParam("arg1") String arg1, @QueryParam("arg2") String arg2) {
        return String.format("%s - %s resulta em %s.", arg1, arg2,
            (Integer.parseInt(arg1) - Integer.parseInt(arg2)));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/mult")
    public String doMult(@QueryParam("arg1") String arg1, @QueryParam("arg2") String arg2) {
        return String.format("%s multiplicado por %s resulta em %s.", arg1, arg2,
            (Integer.parseInt(arg1) * Integer.parseInt(arg2)));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/div")
    public String doDiv(@QueryParam("arg1") String arg1, @QueryParam("arg2") String arg2) {
        if ( Integer.parseInt(arg2) == 0 ) {
            return "Impossível dividir por zero.";
        }
        else {
          return String.format("%s dividiro por %s resulta em %s.", arg1, arg2,
              (Integer.parseInt(arg1) / Integer.parseInt(arg2)));
        }
    }
}

