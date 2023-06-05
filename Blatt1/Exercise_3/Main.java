package Blatt1.Exercise_3;
import java.util.*;

public class Main {
    public static void main(String [] args){

    
        HashSet <String> set = new HashSet<String>();
            
        String word2 = "";
        int j = 0;
       
        while(j < args.length) {
            word2 = args[j];
            set.add(word2);
            j++;
        }

        for(String s : set){
            System.out.println(s);
        }

    }
}
