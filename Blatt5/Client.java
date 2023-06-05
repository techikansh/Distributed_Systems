import java.rmi.*;
import java.util.*;

public class Client {
    public static void main(String args[]){

        
        try {

            Flight _f1 = (Flight)Naming.lookup("rmi://"+ "localhost" +"/f1");
            Flight _f2 = (Flight)Naming.lookup("rmi://"+ "localhost" +"/f2");

            Set <PassengerImpl> p1 = (Set<PassengerImpl>)_f1.getCollectionofPassengers();
            Set <PassengerImpl> p2 = (Set<PassengerImpl>)_f2.getCollectionofPassengers();
            
            int count = 0;

            for(Passenger p : p1){
                if(p.getMeal().equals("vegetarian")){
                    count++;
                }
            }


            for(Passenger p : p2){
                if(p.getMeal().equals("vegetarian")){
                    count++;
                }
            }

            System.out.println("count : " + count);

        } catch (Exception e) {
            System.out.println("Client: " + e.getMessage());
		    e.printStackTrace();
        }

    }
    
}
