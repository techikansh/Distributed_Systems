package Blatt2.Exercise_5;

import java.io.*;

interface Display extends Serializable{
    void print();
}




class Car implements Display{
    private String color;
    private float horsepower;
    private float weight;

    public Car(String color, float horsepower, float weight){
        this.color  = color;
        this.horsepower = horsepower;
        this.weight = weight;
    }

    public void print(){
        System.out.println(color);
        System.out.println(horsepower);
        System.out.println(weight);
    }
}


class publication implements Display{
    private String title;
    private String language;
    private Double price;

    publication(String _title, String _language, Double _price){
        title = _title;
        language = _language;
        price = _price;
    }

    public void print(){
        System.out.println(title);
        System.out.println(language);
        System.out.println(price);
    }
}


class Book extends publication{

    private String author;
    private Long isbn;
    
     Book(String _author, Long _isbn, String _title, String _language, Double _price) {
        super(_title, _language, _price);
        author = _author;
        isbn = _isbn;
    }
    
    public void print(){
        super.print();
        System.out.println(author);
        System.out.println(isbn);
    }
    
}


public class Main {

    public static void main(String args[]) throws IOException{

        // creating array
        publication [] pub = new publication[10];

        Book b1 = new Book("Jordan Peterson", 12233445L, "12 Rules of Life", "English", 10.99 );
       
        publication p1 = new publication("Harry Potter", "English", 20.99 );

        Car c1 = new Car("Blue", 400, 1000);

        pub[0] = b1;
        pub[1] = p1;


        // creating array of Interface display
        Display []d = new Display[10];
        d[0] = b1;
        d[1] = p1;
        d[2] = c1;



        for(int i = 0; i < 3; i++){
            d[i].print();
            System.out.println("");
        }


        System.out.println("\n*******Exercise 6******\n");


        try {

            FileOutputStream fs = new FileOutputStream("Blatt2/Exercise_5/output.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(d);
            os.close();
            System.out.println("Serializaiton done\n");
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        System.out.println("*******Reading the data through txt file*********\n");
        
        
        
        
        try {
            FileInputStream fis = new FileInputStream("Blatt2/Exercise_5/output.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Display [] d1 = (Display[])ois.readObject();
            ois.close();
            for(int i = 0; i < 3; i++){
                d1[i].print();
                System.out.println();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
        
        
        System.out.println("Deserializaiton done");



      
        
      
    }
    
}
