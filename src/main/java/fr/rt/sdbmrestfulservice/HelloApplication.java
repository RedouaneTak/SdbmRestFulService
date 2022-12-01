package fr.rt.sdbmrestfulservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "SDBM API",
                version = "1.0",
                description = "API pour l'application SDBM",
                contact = @Contact(url = "http://localhost:8080/",name = "Redouane",email = "redouane.takdjerad@gmail.com")
        )
)
@ApplicationPath("/api")
public class HelloApplication extends Application {

}