
package Blatt1.Exercise_1;

import java.util.Scanner;

public class factorial{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number to calculate factorial : ");
        int number = sc.nextInt();
        System.out.println(fact(number));
    }

    static int fact(int n){
        
        int product = 1;
        for(int i = n; i > 0; i--){
            product = product * i;
        }
        return product;
    }
}




