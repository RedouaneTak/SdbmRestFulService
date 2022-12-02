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

public class HelloRessourceTest {

    MockHttpRequest request;
    MockHttpResponse response;
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    POJOResourceFactory noDefaults = new POJOResourceFactory(HelloResource.class);

    @Test
    void direBonjour() throws UnsupportedEncodingException, URISyntaxException {


        dispatcher.getRegistry().addResourceFactory(noDefaults);

        {
            request = MockHttpRequest.get("/hello");
            response = new MockHttpResponse();

            dispatcher.invoke(request, response);
            assertEquals(HttpServletResponse.SC_OK, response.getStatus());
            assertEquals("Hello World!", response.getContentAsString());
        }
    }
}
