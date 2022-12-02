package fr.rt.sdbmrestfulservice.endpoints;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
@Tag(name="hello")
@Path("/hello")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello World!";
    }
}