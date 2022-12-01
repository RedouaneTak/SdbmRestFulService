package fr.rt.sdbmrestfulservice.endpoints;

import fr.rt.sdbmrestfulservice.dao.DaoFactory;
import fr.rt.sdbmrestfulservice.metier.Continent;
import fr.rt.sdbmrestfulservice.metier.Pays;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Tag(name="pays")
@Produces(MediaType.APPLICATION_JSON)
@Path("/countries")
public class PaysRessource {

    @GET
    @Operation(summary = "Récupère la liste des pays.")
    public Response getAll(){
        ArrayList<Pays> countries = DaoFactory.getPaysDAO().getAll();
        return Response.ok(countries).build();
    }

    @GET
    @Operation(summary = "Récupère le pays selon son ID.")
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id) {
        Pays countrie = DaoFactory.getPaysDAO().getByID(id);
        return Response.ok(countrie).build();
    }



}
