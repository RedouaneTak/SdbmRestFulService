package fr.rt.sdbmrestfulservice;

import fr.rt.sdbmrestfulservice.dao.DaoFactory;
import fr.rt.sdbmrestfulservice.metier.Fabricant;
import fr.rt.sdbmrestfulservice.metier.Marque;
import fr.rt.sdbmrestfulservice.metier.Pays;
import fr.rt.sdbmrestfulservice.metier.TypeBiere;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Tag(name="marques")
@Produces(MediaType.APPLICATION_JSON)
@Path("/marques")
public class MarqueRessource {


    @GET
    @Operation(summary = "Récupère la liste des marques.")
    public Response getAll() {
        ArrayList<Marque> marques = DaoFactory.getMarqueDAO().getAll();
        return Response.ok(marques).build();
    }

    @GET
    @Operation(summary = "Récupère la marque selon son ID.")
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id) {
        Marque marque = DaoFactory.getMarqueDAO().getByID(id);
        return Response.ok(marque).build();
    }

    @GET
    @Operation(summary = "Récupère le pays de la marque séléctionné.")
    @Path("{id}/countrie")
    public Response getPaysByMarque(@PathParam("id") Integer id) {
        Pays pays = DaoFactory.getMarqueDAO().getPaysByIdMarque(id);
        return Response.ok(pays).build();
    }

    @GET
    @Operation(summary = "Récupère le fabricant de la marque séléctionné.")
    @Path("{id}/fabricant")
    public Response getFabricantByMarque(@PathParam("id") Integer id) {
        Fabricant fabricant = DaoFactory.getMarqueDAO().getFabricantByMarque(id);
        return Response.ok(fabricant).build();
    }
}
