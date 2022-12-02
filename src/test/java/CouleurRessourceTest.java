import fr.rt.sdbmrestfulservice.endpoints.CouleurRessource;
import fr.rt.sdbmrestfulservice.endpoints.HelloResource;
import jakarta.servlet.http.HttpServletResponse;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.jboss.resteasy.spi.Dispatcher;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CouleurRessourceTest {

    MockHttpRequest request;
    MockHttpResponse response;
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    POJOResourceFactory noDefaults = new POJOResourceFactory(CouleurRessource.class);

    @Test
    void getCouleurs() throws UnsupportedEncodingException, URISyntaxException {


        dispatcher.getRegistry().addResourceFactory(noDefaults);

        {
            request = MockHttpRequest.get("/couleurs");
            response = new MockHttpResponse();

            dispatcher.invoke(request, response);
            assertEquals(HttpServletResponse.SC_OK, response.getStatus());

        }
    }

    @Test
    void getCouleurById() throws UnsupportedEncodingException, URISyntaxException {


        dispatcher.getRegistry().addResourceFactory(noDefaults);

        {
            request = MockHttpRequest.get("/couleurs/1");
            response = new MockHttpResponse();

            dispatcher.invoke(request, response);
            assertEquals(HttpServletResponse.SC_OK, response.getStatus());
            System.out.println(response.getContentAsString());
            assertTrue(response.getContentAsString().contains("\"id\":1"));
        }
    }
}
