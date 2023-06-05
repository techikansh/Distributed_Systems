package Blatt1.Exercise_2;

class publication {
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


public class Main{
    public static void main(String args[]){
        System.out.println("");

        publication [] pub = new publication[10];

        Book b1 = new Book("Jordan Peterson", 12233445L, "12 Rules of Life", "English", 10.99 );
       
        publication p1 = new publication("Harry Potter", "English", 20.99 );

        pub[0] = b1;
        pub[1] = p1;

        for(int i = 0; i < 2; i++){
            pub[i].print();
            System.out.println("");
        }

        // b1.print();

    }
}
