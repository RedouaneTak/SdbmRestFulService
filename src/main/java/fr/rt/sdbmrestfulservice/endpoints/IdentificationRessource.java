package fr.rt.sdbmrestfulservice.endpoints;


import fr.rt.sdbmrestfulservice.security.MyToken;
import fr.rt.sdbmrestfulservice.security.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static fr.rt.sdbmrestfulservice.security.Tokened.TOKEN;

@Tag(name="identificaton")
@Path("/identification")
public class IdentificationRessource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(User user){

        if(user == null){

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(user.getLogin().equals("Admin") && user.getPassword().equals("Admin")){
            return Response.ok().header(TOKEN,"Bearer "+new MyToken("Admin","Admin")).build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }


    }
}
