import java.rmi.*;

public class RMIServer {

    public static void main(String args[]){

        try {
        
            WardrobesImpl w1 = new WardrobesImpl("Devansh");
    
            w1.addClothing("Shirt","Blue","XL");
            w1.addClothing("Jeans","Red","XXL");
            w1.addClothing("Shorts","Green","S");
            w1.addClothing("Socks","Red","M");
            
            
            WardrobesImpl w2 = new WardrobesImpl("Adriana");
    
            w2.addClothing("Coat","Blue","XL");
            w2.addClothing("Jeans","Red","XXL");
            w2.addClothing("Sneakers","Green","S");
            w2.addClothing("Socks","Red","M");
    
            Naming.rebind("w1", w1);
            Naming.rebind("w2", w2);
            System.out.println("Server is up!");
    
    
        } catch (Exception e) {
            System.out.println("Server : " + e.getMessage());
            e.printStackTrace();
        }

    }

    
    
}
