import java.io.*;
import java.net.*;
import java.util.*;


class Connection extends Thread {
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
  
    public Connection (Socket aClientSocket) {
      try {
        clientSocket = aClientSocket;
        out = new DataOutputStream ( clientSocket.getOutputStream() );
        in = new DataInputStream ( clientSocket.getInputStream() );     
        this.start();
      } catch( IOException e) {System. out. println(" Connection:"+ e.getMessage());}
    }
  
    public void run(){
      try {
        // String data = in.readUTF ();

        int integer_data = in.readInt();

        String data = String.valueOf(integer_data);
        String [] _data = data.split("");
        
        ArrayList <Integer> finalReceivedData = new ArrayList <Integer>();

        for(String s : _data){
            finalReceivedData.add(Integer.parseInt(s));
        }
        
        String dataToSend = "";   
        
        if(data.charAt(0) == '1'){
            
            if(data.charAt(1) == '0'){
                
                Server2.myWardrobes.addClothing(Server2.category.get(finalReceivedData.get(2)), Server2.color.get(finalReceivedData.get(3)) , Server2.size.get(finalReceivedData.get(4)));
                
                dataToSend = dataToSend + Server2.category.get(finalReceivedData.get(2)) + ";" +  Server2.color.get(finalReceivedData.get(3)) + ";" +  Server2.size.get(finalReceivedData.get(4)) + ";" +"added";
                   
            }

            if(data.charAt(1) == '1'){
                //to do
                Set <Clothing> _clothing = new HashSet <Clothing>();
                _clothing = Server2.myWardrobes.collectionOfClothings();

                ArrayList <String> cats = new ArrayList <String> ();
                // dataToSend = dataToSend + "Categories : ";
                for(Clothing c : _clothing){
                    cats.add(c.getCategory());
                    dataToSend = dataToSend + c.getCategory() + ", ";
                }
            }


            if(data.charAt(1) == '2'){
                dataToSend = dataToSend + "Wardrobe name : " + Server2.myWardrobes.getName() + ";";
            }

        }

        if(data.charAt(0) == '2'){
            
            if(data.charAt(1) == '0'){
                
                Server2.myWardrobes2.addClothing(Server2.category.get(finalReceivedData.get(2)), Server2.color.get(finalReceivedData.get(3)) , Server2.size.get(finalReceivedData.get(4)));
                
                dataToSend = dataToSend + Server2.category.get(finalReceivedData.get(2)) + ";" +  Server2.color.get(finalReceivedData.get(3)) + ";" +  Server2.size.get(finalReceivedData.get(4)) + ";" +"added";   
            
            }

            if(data.charAt(1) == '1'){
                //to do
                Set <Clothing> _clothing = new HashSet <Clothing>();
                _clothing = Server2.myWardrobes2.collectionOfClothings();

                ArrayList <String> cats = new ArrayList <String> ();
                
                for(Clothing c : _clothing){
                    cats.add(c.getCategory());
                    dataToSend = dataToSend + c.getCategory() + ";";
                }
            }


            if(data.charAt(1) == '2'){
                dataToSend = dataToSend + "Wardrobe name : " + Server2.myWardrobes2.getName() + ";";
            }

        }

        out.writeUTF(dataToSend);
        
        System.out.println("Sent data: " + dataToSend);	  
      } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
      } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}
    }
}