import java.rmi.Remote;
import java.rmi.RemoteException;



public interface Clothing extends Remote{

    public String getCategory() throws RemoteException;

    public String getColor() throws RemoteException;

    public String getSize() throws RemoteException;

    public void changeSize(String size) throws RemoteException;
    
    public void Print() throws RemoteException;
}