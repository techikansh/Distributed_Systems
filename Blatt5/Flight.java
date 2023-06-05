import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

interface Flight extends Remote{

    public PassengerImpl getPassenger(String name) throws RemoteException;
    public void addPassenger(String name, String seat, String meal) throws RemoteException;
    public Set <PassengerImpl> getCollectionofPassengers() throws RemoteException;
    public String getName() throws RemoteException;

}

