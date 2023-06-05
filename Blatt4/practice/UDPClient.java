import java.net.*;
import java.io.*;

public class UDPClient{
    public static void main(String args[]){

        try{
            System.out.println("Cleint Message : " + args[0]);
    
            DatagramSocket aSocket = new DatagramSocket();
            byte [] m = args[0].getBytes();
            
            InetAddress aHost = InetAddress.getByName(args[1]);
            int serverPort = 6789;

            DatagramPacket request = new DatagramPacket(m, m.length,  aHost, serverPort);
            aSocket.send(request);


            // recieve

            byte[] buffer = new byte[1000­];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Server Message : " + new String(reply.getData()));
            aSocket.close();

        }catch(SocketException e){
            System.out.println("socket : " + e.getMessage());
        }catch(IOException e){
            System.out.println("IO : " + e.getMessage());
        }
    }
}



