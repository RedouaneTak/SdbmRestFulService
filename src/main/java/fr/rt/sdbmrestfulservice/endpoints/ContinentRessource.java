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
@Tag(name="continents")
@Produces(MediaType.APPLICATION_JSON)
@Path("/continents")
public class ContinentRessource {
    @GET
    @Operation(summary = "Récupère la liste des continents.")
    public Response getAll() {
        ArrayList<Continent> continents = DaoFactory.getContinentDAO().getAll();
        return Response.ok(continents).build();
    }

    @GET
    @Operation(summary = "Récupère le continent selon son ID.")
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id) {
        Continent continent = DaoFactory.getContinentDAO().getByID(id);
        return Response.ok(continent).build();
    }

    @GET
    @Operation(summary = "Récupère la liste des pays du continent sélectionné.")
    @Path("{id}/countries")
    public Response getPaysByContinent(@PathParam("id") Integer id) {
        ArrayList<Pays> countries = DaoFactory.getPaysDAO().getByContinent(id);
        return Response.ok(countries).build();
    }

}
