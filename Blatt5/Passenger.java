import java.rmi.Remote;
import java.rmi.RemoteException;


interface Passenger extends Remote{

    public String getName() throws RemoteException;
    public String getSeat() throws RemoteException;
    public String getMeal() throws RemoteException;
    public void changeMeal(String meal) throws RemoteException;
}

