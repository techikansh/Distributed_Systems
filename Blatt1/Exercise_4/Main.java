package Blatt1.Exercise_4;

import java.lang.Thread;
import java.util.*;

class myThread extends Thread{

    private int number;
    myThread(int number){
        this.number = number;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(number);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }    
}

public class Main{
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a integer : ");
        while(true){
            
            String input  = sc.nextLine();
            if(input.equals("exit")){
                break;
            }
            
            // while(true){
                int number = Integer.parseInt(input);
                // myThread t = new myThread(number);
                new myThread(number).start();
                // Thread.start();
                // break;
                continue;
            // }
            
            
            // System.out.print("Enter a integer : ");
        }
    }
}



