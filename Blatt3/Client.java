

import java.net.*;
import java.util.*;

public class Client {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
    try {

        while(true){

            DatagramSocket mySocket = new DatagramSocket();
            
            // adding new passenger object
            System.out.print("Enter 'Flight;Method;correspondingParameters' or 'Flight;Method': ");
            String data = sc.nextLine();
            
            
            byte [] buffer = data.getBytes();
            InetAddress ipAddress =  InetAddress.getByName("localhost");
            
            DatagramPacket myPacket = new DatagramPacket(buffer, buffer.length, ipAddress, 9999);
            
            System.out.println("\nSending message : " + data);
            mySocket.send(myPacket);
            
            System.out.println();
            
            
            // receive
            
            byte [] recieve = new byte[1000];
            DatagramPacket recievedPacket= new DatagramPacket(recieve, recieve.length);
            mySocket.receive(recievedPacket);
            System.out.println("Recieved message : " + new String(recievedPacket.getData()));
            System.out.println();
            mySocket.close();
        }


    } catch (Exception e) {
        // TODO: handle exception
    }

    }
    
}
