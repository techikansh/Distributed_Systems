import java.io.*;
import java.net.*;
import java.util.*;


public class Client2 {


    public static void main(String args[]){
        // args[0]: Message
        // args[1]: Server
        

        
        Scanner sc = new Scanner(System.in);

        while(true){
          System.out.print("\nEnter 'Wardrobe;Method;correspondingParameters' or 'Wardrobe;Method': ");
          Integer input = sc.nextInt(); 
  
          // 1  = devansh, 2 = parth ||  0 = addClothing, 1 = getClothes ||  0..9 = Category || 0..9 = Color || 0..9 = Size
          
            try{
  
              int serverPort = 7896;
              Socket s = new Socket ("localhost", serverPort);
              DataOutputStream out = new DataOutputStream ( s.getOutputStream());
              DataInputStream in = new DataInputStream ( s.getInputStream());
              out.writeInt (input); 
              String data = in.readUTF ();
              System.out.println("Received: "+ data) ;
              System.out.println();
              s.close();
  
            }catch (UnknownHostException e){
              System.out.println(" Sock:"+ e.getMessage());
            }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
            }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());}
        }

        
    }
    
}
