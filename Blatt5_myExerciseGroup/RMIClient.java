import java.util.*;
import java.rmi.*;


public class RMIClient {
    public  static void main(String args[]) throws Exception{

        try {

            Wardrobes newWardrobe1 = (Wardrobes) Naming.lookup("rmi://localhost/w1");
            Wardrobes newWardrobe2 = (Wardrobes) Naming.lookup("rmi://localhost/w2");

        
            
            System.out.println();
            
            //adding clothes to wardrobe
            newWardrobe1.addClothing("Socks", "Pink", "XXXS");
            newWardrobe1.addClothing("Socks", "Red", "XXXS");
            
            //getting name of the wardrobe
            System.out.println(newWardrobe1.getName());
            System.out.println(newWardrobe2.getName());
            
            
            //CALCULATING total no. of red clothes
            int count = 0;
            Set<Clothing> newClothingImpl1 = newWardrobe1.collectionOfClothings();
            Set<Clothing> newClothingImpl2 = newWardrobe2.collectionOfClothings();
            
            
            for(Clothing c : newClothingImpl1){
                if(c.getColor().equals("Red")){
                    count++;
                }
            }
            
            for(Clothing c : newClothingImpl2){
                if(c.getColor().equals("Red")){
                    count++;
                }
            }
            
            System.out.println("Count : " + count);

            //searchClothing
            Clothing c = newWardrobe1.searchClothing("Socks", "Red");
            System.out.println("Category & color : " + c.getCategory() + " " + c.getColor());



            
        } catch (Exception e) {
            System.out.println("Client : " + e.getMessage());
            e.printStackTrace();
        }
        
        
    }
    
}
