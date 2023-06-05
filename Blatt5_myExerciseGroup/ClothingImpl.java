import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ClothingImpl extends UnicastRemoteObject implements Clothing{

    private String category;
    private String color;
    private String size;

    public ClothingImpl(String category, String color, String size) throws RemoteException{
        this.category = category;
        this.color = color;
        this.size = size;
    }

    public String getCategory() throws RemoteException{
        return this.category;
    }

    public String getColor() throws RemoteException{
        return this.color;
    }

    public String getSize() throws RemoteException{
        return this.size;
    }

    public void changeSize(String size) throws RemoteException{
        this.size = size;
    }
    
    public void Print() throws RemoteException{
        System.out.println(this.category);
        System.out.println(this.color);
        System.out.println(this.size);
    }
    
}
