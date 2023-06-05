
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path( "Flights" )
public class Service {

  @GET
  @Path("/Flight1/{name}")
//   @Produces(MediaType.TEXT_PLAIN)
//   @Produces({ MediaType.TEXT_XML})
  @Produces({ MediaType.APPLICATION_JSON})
  
  public String getPassenger_S(@PathParam("name") String name) { 
        Passenger p = RESTServer.f1.getPassenger(name);

        if (p != null) {
            String objectToReturn = "Name: " + p.getName() + ", Meal: " + p.getMeal() + ", Seat: " + p.getSeat();
            return objectToReturn;
            // return p;
        } else {
            return "Passenger not found";
            // throw new NotFoundException("Passenger not found!");
        }    
        
    }


    
//   public String getDate() {
//     Date d = new Date();
//     MyDate md = new MyDate();
//     md.hour = d.getHours();
//     md.min = d.getMinutes();
//     md.sec = d.getSeconds();
//     return md.toString();
//   }
  
//   @GET
//   @Produces( { MediaType.TEXT_XML, MediaType.APPLICATION_JSON } )          
//   public MyDate getDateXML() {
//     Date d = new Date();
//     MyDate md = new MyDate();
//     md.hour = d.getHours();
//     md.min = d.getMinutes();
//     md.sec = d.getSeconds();
//     return md;
//   }
  
//    @GET
//    @Path("/part/{partid}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getTimePart(@PathParam("partid") String pid){
//    Date d = new Date();
//       if (pid.equals("hour")) return  "" + d.getHours();
//       if (pid.equals("min")) return  "" + d.getMinutes();
//       if (pid.equals("sec")) return  "" + d.getSeconds();
//       return "illegal argument";
//    }

//    @GET
//    @Path("/part2")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getTimePart2(@QueryParam("partid") String pid){
//       Date d = new Date();
//       if (pid.equals("hour")) return  "" + d.getHours();
//       if (pid.equals("min")) return  "" + d.getMinutes();
//       if (pid.equals("sec")) return  "" + d.getSeconds();
//       return "illegal argument";
//    }
   
}