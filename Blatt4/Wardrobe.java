import java.util.*;

class Wardrobes{
    private String name;
    private Set <Clothing> clothes = new HashSet<Clothing>();


    public Wardrobes(String name){
        this.name = name;
    }

    public Clothing searchClothing(String category, String color){
        
        for(Clothing c : clothes){

            if(category.isEmpty()){
                if(c.getColor() == color){
                    return c;
                }
            }

            if(!category.isEmpty()){                
                if(c.getCategory() == category && c.getColor() == color){
                    return c;
                }
            }
        }
        return null;
    }


    public void addClothing(String category, String color, String size){
        clothes.add(new Clothing(category, color, size));
    }

    // Return the set of all pieces of clothing objects of the wardrobe. 
    public Set<Clothing> collectionOfClothings(){
        return this.clothes;
    }

    //Return the name of the wardrobe
    public String getName(){
        return this.name;
    }

}