package Serialization;
import java.io.*;

public class Main{

    public static void main (String[] args){
        try {
            FileOutputStream fs = new FileOutputStream("Serialization/test.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeInt(123); 
            os.writeObject( "Hallo");
            os.close();
        } 
        catch (IOException e) { 
            System.err.println(e.toString()); 
        }
    }

}