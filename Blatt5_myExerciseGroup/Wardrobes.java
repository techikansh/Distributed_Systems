import java.rmi.*;
import java.util.*;

public interface Wardrobes extends Remote{


    public Clothing searchClothing(String category, String color) throws RemoteException;


    public void addClothing(String category, String color, String size) throws RemoteException;
    
    // Return the set of all pieces of clothing objects of the wardrobe. 
    public Set<Clothing> collectionOfClothings() throws RemoteException;

    //Return the name of the wardrobe
    public String getName() throws RemoteException;

}
