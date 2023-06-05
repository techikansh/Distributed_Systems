import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class PassengerImpl extends UnicastRemoteObject implements Passenger{
    private String name;
    private String seat;
    private String meal;
    
    public PassengerImpl(String name, String seat, String meal) throws RemoteException{
        this.name = name;
        this.seat = seat;
        this.meal = meal;
    }

    public String getName() throws RemoteException{
        return this.name;
    }
    public String getSeat() throws RemoteException{
        return this.seat;
    }
    public String getMeal() throws RemoteException{
        return this.meal;
    }
    public void changeMeal(String meal) throws RemoteException{
        this.meal = meal;
    }
}