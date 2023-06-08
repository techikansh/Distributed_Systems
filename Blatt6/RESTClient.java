import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RESTClient {

    static final String BASE_URI = "http://localhost:9067/";

    public static void main(String[] args) throws Exception {
        String name = "Devansh"; // Set the name parameter value

        Client client = ClientBuilder.newClient();
		
		WebTarget target;
		Invocation.Builder invocationBuilder;
		
        target = client.target(BASE_URI).path("Flights/Flight1").path(name);
        // invocationBuilder = target.request().accept(MediaType.TEXT_PLAIN);
        // invocationBuilder = target.request(MediaType.TEXT_XML);
        invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        
        System.out.println(response.getStatus());
        // System.out.println(response.readEntity(String.class));
		Passenger p = response.readEntity(Passenger.class);
		p.print();
        

    }
}
