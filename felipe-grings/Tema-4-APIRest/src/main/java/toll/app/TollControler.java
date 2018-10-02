package toll.app;

import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("toll")
public class TollControler {
    TollCalculator toll = new TollCalculator();

    @GET
    @Path("/calculate")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculate(@QueryParam("type") String type, @DefaultValue("0")@QueryParam("axis") int axis, @QueryParam("money") double money ) {
        return String.valueOf(toll.finalCalculation(type,axis,money));
    }

    @GET
    @Path("/pricelist")
    @Produces(MediaType.TEXT_PLAIN)
    public String price() {
        return toll.priceList();
    }
}
