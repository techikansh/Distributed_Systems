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
            
            dataToSend = operateOnData(Server2.myWardrobes, finalReceivedData);
        }

        if(data.charAt(0) == '2'){
            
            dataToSend = operateOnData(Server2.myWardrobes2, finalReceivedData);
        }



        

        out.writeUTF(dataToSend);
        
        System.out.println("Sent data: " + dataToSend);	  
      } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
      } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}
    }



    public String operateOnData(Wardrobes obj, ArrayList<Integer> data){
        
        String dataToSend = "";

        if(data.get(1) == 0){
                
            String _cat = Server2.category.get(data.get(2));
            String _color = Server2.color.get(data.get(3));
            String _size = Server2.size.get(data.get(4));
            obj.addClothing(_cat, _color, _size);

            dataToSend = dataToSend + _cat + ";" + _color + ";" + _size + ";" + "added";

        }

        if(data.get(1) == 1){
            Set <Clothing> c  = new HashSet <Clothing>();
            c = obj.collectionOfClothings();
            for(Clothing clthng : c){
                dataToSend = dataToSend + clthng.getCategory() + ";";
            }
        }


        if(data.get(1) == 2){
            dataToSend = dataToSend + "Wardrobe name : " + obj.getName() + ";";
        }

        return dataToSend;
    }


}