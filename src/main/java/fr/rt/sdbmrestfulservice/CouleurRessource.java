package fr.rt.sdbmrestfulservice;

import fr.rt.sdbmrestfulservice.dao.DaoFactory;
import fr.rt.sdbmrestfulservice.metier.Continent;
import fr.rt.sdbmrestfulservice.metier.Couleur;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Tag(name="couleurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/couleurs")
public class CouleurRessource {



    @GET
    @Operation(summary = "Récupère la liste des couleurs.")
    public Response getAll() {
        ArrayList<Couleur> couleurs = DaoFactory.getCouleurDAO().getAll();
        return Response.ok(couleurs).build();
    }

    @GET
    @Operation(summary = "Récupère la couleur selon son ID.")
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id) {
        Couleur couleur = DaoFactory.getCouleurDAO().getByID(id);
        return Response.ok(couleur).build();
    }

    @POST
    public Response insert(Couleur couleur){

        if(couleur == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(DaoFactory.getCouleurDAO().insert(couleur))
            return Response.ok(couleur).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{id}")
    public Response update( @PathParam("id")Integer id, Couleur couleur){

        if(couleur == null || id==null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(id != couleur.getId()){
            return Response.status(Response.Status.CONFLICT).entity(couleur).build();
        }

        if(DaoFactory.getCouleurDAO().update(couleur))
            return Response.ok(couleur).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id){

        Couleur couleur = new Couleur(id,"");

        if(DaoFactory.getCouleurDAO().delete(couleur))
            return Response.ok(couleur).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }




}
