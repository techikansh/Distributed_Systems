import java.util.HashSet;
import java.util.Set;

class Flight{
    private String name;
    private Set <Passenger> passengers = new HashSet<Passenger>();

    Flight(String name){
        this.name = name;
    }

    // searching passenger
    public Passenger getPassenger(String name){
        for(Passenger p1 : passengers){
            if(p1.getName() == name){
                return p1;
            }
        }
        return null;
    }
    // adding passenger
    public void addPassenger(String name, String seat, String meal){
        passengers.add(new Passenger(name, seat, meal));
    }
    // returning the set
    public Set <Passenger> getCollectionofPassengers(){
        return passengers;
    }
    // return name of flight
    public String getName(){
        return this.name;
    }


}