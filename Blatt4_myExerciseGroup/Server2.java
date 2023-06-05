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

        category.put(0, "Shirt");
        category.put(1, "Jeans");
        category.put(2, "Shorts");
        category.put(3, "Socks");
        category.put(4, "Hoodies");
        category.put(5, "Sweaters");
        category.put(6, "Trousers");
        category.put(7, "Hat");
        category.put(8, "Coat");
        category.put(9, "Sneakers");

        //colors

        color.put(0, "Black");
        color.put(1, "White");
        color.put(2, "Red");
        color.put(3, "Blue");
        color.put(4, "Green");
        color.put(5, "Yellow");
        color.put(6, "Pink");
        color.put(7, "Gray");
        color.put(8, "Purple");
        color.put(9, "Brown");

        //size

        size.put(0, "XS");
        size.put(1, "S");
        size.put(2, "M");
        size.put(3, "L");
        size.put(4, "XL");
        size.put(5, "XXS");
        size.put(6, "XXL");
        size.put(7, "XXXS");
        size.put(8, "XXXL");
        size.put(9, "OneSizeFitsAll");
        

        

        

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





