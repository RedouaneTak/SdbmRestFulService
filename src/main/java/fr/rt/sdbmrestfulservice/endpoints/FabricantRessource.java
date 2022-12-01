package fr.rt.sdbmrestfulservice.endpoints;

import fr.rt.sdbmrestfulservice.dao.DaoFactory;
import fr.rt.sdbmrestfulservice.metier.Couleur;
import fr.rt.sdbmrestfulservice.metier.Fabricant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
@Tag(name="fabricants")
@Produces(MediaType.APPLICATION_JSON)
@Path("/fabricants")
public class FabricantRessource {

    @GET
    @Operation(summary = "Récupère la liste des fabricants.")
    public Response getAll() {
        ArrayList<Fabricant> fabricants = DaoFactory.getFabricantDAO().getAll();
        return Response.ok(fabricants).build();
    }

    @GET
    @Operation(summary = "Récupère le fabricant selon son ID.")
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id) {
        Fabricant fabricant = DaoFactory.getFabricantDAO().getByID(id);
        return Response.ok(fabricant).build();
    }
}
