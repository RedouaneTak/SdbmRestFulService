package fr.rt.sdbmrestfulservice;

import fr.rt.sdbmrestfulservice.dao.DaoFactory;
import fr.rt.sdbmrestfulservice.metier.Continent;
import fr.rt.sdbmrestfulservice.metier.Couleur;
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

@Tag(name="types")
@Produces(MediaType.APPLICATION_JSON)
@Path("types")
public class TypeBiereRessource {

    @GET
    @Operation(summary = "Récupère la liste des types de bière.")
    public Response getAll() {
        ArrayList<TypeBiere> typeBieres = DaoFactory.getTypeBiereDAO().getAll();
        return Response.ok(typeBieres).build();
    }

    @GET
    @Operation(summary = "Récupère le type de biere selon son ID.")
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id) {
        TypeBiere typeBiere = DaoFactory.getTypeBiereDAO().getByID(id);
        return Response.ok(typeBiere).build();
    }
}
