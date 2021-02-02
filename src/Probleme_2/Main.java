package Probleme_2;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class Main {
    static final  int place  = 3;
    public static void main(String args[]){
        try{
                PipedWriter out= new PipedWriter();
        PipedReader in ;
       
        Scanner sc = new Scanner(System.in);
        System.out.println("la piscine dispose de : " + place+" panier est de "+place+" cabine");
      
        System.out.println("Combien de Baigneur vous avez : ");
        int baigneur  = sc.nextInt();
        in = new PipedReader(out);
        Baigneur[] b= new Baigneur[baigneur];
        DessinBaigneur[] db = new DessinBaigneur[baigneur];
        Thread[] thread_baigneur= new Thread[baigneur];
        Thread[] thread_dessinbaigneur= new Thread[baigneur];
        for (int i = 0; i < baigneur; i++) {
            b[i] = new Baigneur(i,out);
            db[i] = new DessinBaigneur(in);
            thread_baigneur[i]= new Thread(b[i]);
            thread_dessinbaigneur[i]= new Thread(db[i]);
            thread_baigneur[i].start();
            thread_dessinbaigneur[i].start();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}