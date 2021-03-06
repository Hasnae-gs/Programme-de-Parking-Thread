package Probleme_2;

import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class Baigneur implements Runnable{

    private int place = 3;
    private int id_baigneur;
    private Writer out;
    private int nb_Baingneur;
    private int etat;
    Baigneur(int i, Writer out){
        this.out= out;
        this.id_baigneur=i;
    }
    Random rand = new Random();
    public void run() {
       
        try {
            Thread.sleep(rand.nextInt(5000)  );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Baigneur : "+id_baigneur+" arrive");
        InformationBaigneur(0);
        try {
            Thread.sleep(rand.nextInt(5000)  );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Baigneur : "+id_baigneur+"  prend un panier");
        panier(1);
        InformationBaigneur(1);
        try {
            Thread.sleep(rand.nextInt(5000)  );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Baigneur : "+id_baigneur+" se déshabille");
        cabine(1);
        InformationBaigneur(2);
        try {
            Thread.sleep(rand.nextInt(5000)  );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Baigneur : "+id_baigneur+" se baigne");
        InformationBaigneur(3);
        cabine(2);
        try {
            Thread.sleep(rand.nextInt(5000)  );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cabine(1);
        System.out.println("Baigneur :  "+id_baigneur+"  s'habille");
        InformationBaigneur(4);
        try {
            Thread.sleep(rand.nextInt(5000)  );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Baigneur : "+id_baigneur+"  quitte la piscine.");
        InformationBaigneur(5);
        cabine(2);
        try {
            Thread.sleep(rand.nextInt(5000)  );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        panier(1);

    }
    void InformationBaigneur (int etat) {
        try {
            out.write (id_baigneur);
            out.write (etat);
            out.write('.');
        } catch ( IOException e) {
            System.out.println (e.getMessage());
        }
    }

    public void panier(int a){
        if(a==1){
            Plein();
        }else{
            Vide();
        }
    }
    public void cabine(int a){
        if(a==1){
            Plein();
        }else{
            Vide();
        }
    }
    synchronized public void Plein () {
        try {
            while (place ==0) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println (e);
        }
        place--; 
    }
    synchronized public void Vide () {
       
        place++;
        notifyAll();
    }
}