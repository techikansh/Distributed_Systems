import java.util.*;


class Clothing{
    private String category;
    private String color;
    private String size;

    public Clothing(String category, String color, String size){
        this.category = category;
        this.color = color;
        this.size = size;
    }

    public String getCategory(){
        return this.category;
    }

    public String getColor(){
        return this.color;
    }

    public String getSize(){
        return this.size;
    }

    public void changeSize(String size){
        this.size = size;
    }

    public void Print(){
        System.out.println(this.category);
        System.out.println(this.color);
        System.out.println(this.size);
    }
}

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

public class Main{
    public static void main(String args[]){
        
        Wardrobes myWardrobes = new Wardrobes("Devansh");

        myWardrobes.addClothing("Shirt","Blue","XL");
        myWardrobes.addClothing("Jeans","Red","XXL");
        myWardrobes.addClothing("Shorts","Green","S");
        myWardrobes.addClothing("Socks","Red","M");

        // Clothing myClothing = myWardrobes.searchClothing("", "Blue");
        Clothing myClothing = myWardrobes.searchClothing("Shirt", "Blue");
        System.out.println("\nSearching with 'CATEGORY' + 'COLOR' : ");
        myClothing.Print();

        Set<Clothing> mySet = new HashSet<Clothing>(0);
        mySet = myWardrobes.collectionOfClothings();

        int count = 0;

        System.out.println("\nSearching only with 'COLOR' : ");
        for(Clothing c : mySet){
            if(c.getColor() == "Red"){
                c.Print();
                System.out.println();
                count++;
            }
        }

        System.out.println("No. of red clothes : " + count);
        System.out.println();

    }
}
