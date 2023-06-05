class Passenger{
    private String name;
    private String seat;
    private String meal;
    
    Passenger(String name, String seat, String meal){
        this.name = name;
        this.seat = seat;
        this.meal = meal;
    }

    public String getName(){
        return this.name;
    }
    public String getSeat(){
        return this.seat;
    }
    public String getMeal(){
        return this.meal;
    }
    public void changeMeal(String meal){
        this.meal = meal;
    }

    public void print(){
        System.out.println();
        System.out.println(this.name);
        System.out.println(this.seat);
        System.out.println(this.meal);
        System.out.println();
    }
}