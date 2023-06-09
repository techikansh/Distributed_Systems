
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;

@Path("Man")
@Singleton
public class Manager{
    
//    List<MyDate> dateList = new ArrayList<MyDate>();
//    int id = 1;

//    @GET
//    @Path("/dates")
//    @Produces(MediaType.TEXT_XML)
//    public List<MyDate> getDates(){
//       return dateList;
//    }

//    @GET
//    @Path("/dates/{id}")
//    @Produces(MediaType.TEXT_XML)
@GET
@Path("/Flight1/{name}")
//   @Produces(MediaType.TEXT_PLAIN)
//   @Produces({ MediaType.TEXT_XML})
@Produces({ MediaType.APPLICATION_JSON})
   public Passenger getPassenger_S(@PathParam("name") String name) { 
        Passenger p = RESTServer.f1.getPassenger(name);
        if (p != null) {
        // String objectToReturn = "Name: " + p.getName() + ", Meal: " + p.getMeal() + ", Seat: " + p.getSeat();
        // return objectToReturn;
        return p;
        } else {
            // return "Passenger not found";
            throw new NotFoundException("Passenger not found!");
        }    
    
    }

//    public MyDate getDate(@PathParam("id") int id){
//       for(MyDate md : dateList){
//          if(md.id == id){
//             return md;
//          }
//       }
//       return null;
//    }

//    @POST
//    @Path("/dates/{hour}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String createDate(@PathParam("hour") int hour) {
//       Date d = new Date();
//       MyDate md = new MyDate();
//       md.id = id++;
//       md.hour = hour;
//       md.min = d.getMinutes();
//       md.sec = d.getSeconds();
//       dateList.add(md);
//       return "Date added";
//    }

//    @PUT
//    @Path("/dates/{id}/{hournew}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String updateHour(@PathParam("id") int id, @PathParam("hournew") int hournew ) {
//       for(MyDate md : dateList){
//          if(md.id == id){
//             md.hour = hournew;
//             return "Date changed";
//          }
//       }
//       return "Date not found";
//    }

//    @DELETE
//    @Path("/dates/{id}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String deleteDate(@PathParam("id") int id){
//       for(MyDate md : dateList){
//          if(md.id == id){
//             dateList.remove(md);
//             return "Date deleted";
//          }
//       }
//       return "Date not found";
//    }


}