import java.io.*;
import java.net.*;
import java.util.*;


public class Server2{
    
    public static Wardrobes myWardrobes;
    public static Wardrobes myWardrobes2;
    
    
    
    public static HashMap <Integer, String> category;
    public static HashMap <Integer,String> color;
    public static HashMap <Integer, String> size;

    public static void main(String args[]){
        
        myWardrobes = new Wardrobes("Hoffman");

        myWardrobes.addClothing("Shirt","Blue","XL");
        myWardrobes.addClothing("Jeans","Red","XXL");
        myWardrobes.addClothing("Shorts","Green","S");
        myWardrobes.addClothing("Socks","Red","M");



        myWardrobes2 = new Wardrobes("Mueller");

        myWardrobes2.addClothing("Shirt","Blue","XL");
        myWardrobes2.addClothing("Jeans","Red","XXL");
        myWardrobes2.addClothing("Shorts","Green","S");
        myWardrobes2.addClothing("Socks","Red","M");

        category = new HashMap<Integer, String>();
        color = new HashMap<Integer, String>();
        size = new HashMap<Integer, String>();


        category.put(0,"Shirt");
        category.put(1,"Hoodie");
        category.put(2,"SWeatshirt");
        category.put(3,"Jeans");
        category.put(4,"Shorts");
        category.put(5,"Jacket");
        category.put(6,"Coat");
        category.put(7,"Sweater");
        category.put(8,"Pants");
        category.put(9,"Hat");
        color.put(0,"Red");
        color.put(1,"Orange");
        color.put(2,"Purple");
        color.put(3,"Green");
        color.put(4,"Blue");
        color.put(5,"BLack");
        color.put(6,"White");
        color.put(7,"Grey");
        color.put(8,"Yellow");
        color.put(9,"Pink");
        size.put(0,"XS");
        size.put(1,"S");
        size.put(2,"M");
        size.put(3,"L");
        size.put(4,"XL");
        size.put(5,"XXL");
        size.put(6,"3XL");
        size.put(7,"4XL");
        size.put(8,"5XL");
        size.put(9,"6XL");
        

        

        // Clothing myClothing = myWardrobes.searchClothing("", "Blue");
        // Clothing myClothing = myWardrobes.searchClothing("Shirt", "Blue");
        // System.out.println("\nSearching with 'CATEGORY' + 'COLOR' : ");
        // myClothing.Print();

        // Set<Clothing> mySet = new HashSet<Clothing>(0);
        // mySet = myWardrobes.collectionOfClothings();

        // int count = 0;

        // System.out.println("\nSearching only with 'COLOR' : ");
        // for(Clothing c : mySet){
        //     if(c.getColor() == "Red"){
        //         c.Print();
        //         System.out.println();
        //         count++;
        //     }
        // }

        // System.out.println("No. of red clothes : " + count);
        // System.out.println();




        //Server stuff

        try{
            System.out.println("The Server is running");
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket (serverPort);
            while(true) {
              Socket clientSocket = listenSocket.accept();
              System. out.println("New Connection");
              Connection c = new Connection(clientSocket);
            }
          } catch( IOException e) {System.out.println(" Listen :"+ e.getMessage());}
        }// main


    }





