package fr.rt.sdbmrestfulservice;

import fr.rt.sdbmrestfulservice.dao.DaoFactory;
import fr.rt.sdbmrestfulservice.metier.Article;
import fr.rt.sdbmrestfulservice.metier.Continent;
import fr.rt.sdbmrestfulservice.metier.Couleur;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Tag(name="articles")
@Produces(MediaType.APPLICATION_JSON)
@Path("/articles")
public class ArticleRessource {

    @Operation(summary = "Récupère la liste des artciles.")
    @GET
    public Response getAll() {
        ArrayList<Article> articles = DaoFactory.getArticleDAO().getAll();
        return Response.ok(articles).build();
    }

    @Operation(summary = "Récupère un article selon son ID.")
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id) {
        Article article = DaoFactory.getArticleDAO().getByID(id);
        return Response.ok(article).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Article article){

        if(DaoFactory.getArticleDAO().insert(article))
            return Response.ok(article).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }



    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id")Integer id,Article article){

        if(article == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(article.getId() == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(DaoFactory.getArticleDAO().update(article)){

            return Response.ok(article).build();

        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id){
        if(DaoFactory.getArticleDAO().delete(new Article(id,""))){
            return Response.status(Response.Status.ACCEPTED).build();
        }else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }


}
