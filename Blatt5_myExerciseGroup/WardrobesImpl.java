import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class WardrobesImpl extends UnicastRemoteObject implements Wardrobes{
    
    private String name;
    private Set <Clothing> clothes = new HashSet<Clothing>();


    public WardrobesImpl(String name) throws RemoteException{
        this.name = name;
    }

    public Clothing searchClothing(String category, String color) throws RemoteException{
        for(Clothing c : clothes){

                if(c.getCategory().equals(category) && c.getColor().equals(color)){
                    return c;
                }

                // if( category.equals(c.getCategory()) && color.equals(c.getColor()) )
                // {
                //     return c;
                // }
        }
        return null;
    }


    public void addClothing(String category, String color, String size) throws RemoteException{
        clothes.add(new ClothingImpl(category, color, size));
    }

    // Return the set of all pieces of clothing objects of the wardrobe. 
    public Set <Clothing> collectionOfClothings() throws RemoteException{
        return clothes;
    }

    //Return the name of the wardrobe
    public String getName() throws RemoteException{
        return this.name;
    }

}
