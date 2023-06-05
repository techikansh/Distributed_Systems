import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

public class FlightImpl extends UnicastRemoteObject implements Flight{
    private String name;
    private Set <PassengerImpl> passengers = new HashSet<PassengerImpl>();

    public FlightImpl(String name) throws RemoteException{
        this.name = name;
    }

    // searching passenger
    public PassengerImpl getPassenger(String name) throws RemoteException{
        for(PassengerImpl p1 : passengers){
            if(p1.getName().equals(name)){
                return p1;
            }
        }
        return null;
    }
    // adding passenger
    public void addPassenger(String name, String seat, String meal) throws RemoteException{
        passengers.add(new PassengerImpl(name, seat, meal));
    }
    // returning the set
    public Set <PassengerImpl> getCollectionofPassengers() throws RemoteException{
        return passengers;
    }
    // return name of flight
    public String getName() throws RemoteException{
        return this.name;
    }


}