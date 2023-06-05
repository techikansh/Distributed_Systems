import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class RESTServer {

    // static final String BASE_URI = "http://localhost:8080/";
    static final String BASE_URI = "http://localhost:9067/";
    public static Flight f1, f2;
    
    public static void main(String args[]) throws Exception{

        f1 = new Flight("Delta");
        f1.addPassenger("Devansh", "11G","vegetarian");
        f1.addPassenger("vansh", "112G","vegetarian");
        
        

        f2 = new Flight("Lufthansa");
        f2.addPassenger("Ekta", "113G","non-vegetarian");
        f2.addPassenger("Nancy", "114G","vegetarian");



        HttpServer server = null ;

        ResourceConfig rc = new ResourceConfig(Service.class, Manager.class);
        URI endpoint = new URI(BASE_URI);

        server = GrizzlyHttpServerFactory.createHttpServer(endpoint,rc);
        System.out.println("Press Enter to stop the server. ");
        System.in.read();
        server.shutdownNow();
    }
    
}
