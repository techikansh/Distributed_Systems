

import java.util.*;
import java.util.Set;

import javax.xml.transform.Source;

import java.net.*;


public class Server{
    public static void main(String args[]) throws Exception{

        Flight f1 = new Flight("Air India");
        f1.addPassenger("Devansh", "11G","vegetarian");
        f1.addPassenger("vansh", "112G","vegetarian");
        
        

        Flight f2 = new Flight("Lufthansa");
        f2.addPassenger("Ekta", "113G","non-vegetarian");
        f2.addPassenger("Nancy", "114G","vegetarian");

        Flight f3 = new Flight("Delta");
        f3.addPassenger("Parth", "55G","non-vegetarian");
        f3.addPassenger("Kartik", "99G","vegetarian");



        Set <Passenger> p1 = f1.getCollectionofPassengers();

        for(Passenger p : p1){
            if(p.getMeal() == "vegetarian"){
                p.print();

            }
        }

        // getting passenger
        // Passenger me = f1.getPassenger("Ekta");
        // me.print();


        // Passenger me1 = f1.getPassenger("Idli");
        // me.print();




        // Exercise 4




        try {

            System.out.println("The Server is up");
            DatagramSocket aSocket = new DatagramSocket(9999);
            
            while(true){
                
                byte [] buffer = new byte[1000];
                DatagramPacket request = new DatagramPacket(buffer,buffer.length);
                aSocket.receive(request);
                
                String receivedMessage = new String(request.getData());
                System.out.println("Client Message : " + receivedMessage);

                String data[] = receivedMessage.split(";");

                //adding passenger object to the flight

                





                // ArrayList <String> names = new ArrayList <String> ();
                String names = "";
                String addedPassenger = "";

                if(data[0].equals("Air India")){

                    if(data[1].equals("addPassenger")){
                        
                        f1.addPassenger(data[2], data[3], data[4]);
                        addedPassenger = addedPassenger + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";";
                    }

                    if(data[1].equals("getNames")){

                        Set <Passenger> passengers = new HashSet<Passenger>();
                        passengers = f1.getCollectionofPassengers();

                        for(Passenger p : passengers){
                            names = names + (p.getName()) + ";";
                        }

                    }
                }

                if(data[0].equals("Lufthansa")){
                    
                    if(data[1].equals("addPassenger")){
                        
                        f2.addPassenger(data[2], data[3], data[4]);
                        addedPassenger = addedPassenger + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";";                    }

                    if(data[1].equals("getNames")){
                        
                        Set <Passenger> passengers = new HashSet<Passenger>();
                        passengers = f2.getCollectionofPassengers();

                        for(Passenger p : passengers){
                            names = names + (p.getName()) + ";";
                        }
                    }
                }

                if(data[0].equals("Delta")){
                    
                    if(data[1].equals("addPassenger")){
                        
                        f3.addPassenger(data[2], data[3], data[4]);
                        addedPassenger = addedPassenger + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";";
                    }

                    if(data[1].equals("getNames")){
                        
                        Set <Passenger> passengers = new HashSet<Passenger>();
                        passengers = f3.getCollectionofPassengers();

                        for(Passenger p : passengers){
                            names = names + (p.getName()) + ";";
                        }
                    }
                }




                byte [] newBuffer = new byte[1000];

                if(data[1].equals("addPassenger")){
                    String message = addedPassenger + " added to the Flight";
                    newBuffer = message.getBytes();
                }
                
                if(data[1].equals("getNames")){
                    newBuffer = names.getBytes();
                }

                
                // replying message
                DatagramPacket reply = new DatagramPacket(newBuffer, newBuffer.length, request.getAddress(), request.getPort());
                aSocket.send(reply);

            }



        } catch (Exception e) {
            // TODO: handle exception
        }








    }
}