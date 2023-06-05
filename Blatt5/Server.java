import java.rmi.*;


public class Server{
    
    // public static FlightImpl f1, f2;
    
    public static void main(String args[]){

        
        try {

        
            FlightImpl f1 = new FlightImpl("Air India");
            f1.addPassenger("Devansh", "11G","vegetarian");
            f1.addPassenger("vansh", "112G","vegetarian");
            
            FlightImpl f2 = new FlightImpl("Lufthansa");
            f2.addPassenger("Ekta", "113G","non-vegetarian");
            f2.addPassenger("Nancy", "114G","vegetarian");
            f2.addPassenger("Nancy", "114G","vegetarian");
            f2.addPassenger("Nancy", "114G","vegetarian");

            Naming.rebind("f1", f1);
            Naming.rebind("f2", f2);

            System.out.println("Server is up!");

        } catch (Exception e) {
            System.out.println("Server: " + e.getMessage());
		    e.printStackTrace();
        }
        

    }
}