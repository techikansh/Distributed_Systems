import java.util.*;
import java.net.*;

public class UDPServer {
    public static void main(String [] args){
        try {
            System.out.println("The Server is up");
            DatagramSocket aSocket = new DatagramSocket(6789);
            byte [] buffer = new byte[1000];
            while(true){
                DatagramPacket request = new DatagramPacket(buffer,buffer.length);
                aSocket.receive(request);
                System.out.println("Client Message : " + new String(request.getData(), 0, request.getLength()));
                
                // replying message
                DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
                aSocket.send(reply);
            }



        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
