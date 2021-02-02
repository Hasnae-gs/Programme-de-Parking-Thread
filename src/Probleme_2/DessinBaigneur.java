package Probleme_2;

import java.io.IOException;
import java.io.Reader;

public class DessinBaigneur implements Runnable{
    private Reader in;
    private int fin;
    public DessinBaigneur(Reader in) {
        this.in= in;
        fin=0;
    }

    @Override
    public void run() {
        
        String information="";
        while(fin==0){
           
            try {
                information=information+"\n"+ AutreInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Info sur Baigneur :  "+"\n"+"Baigneur n°"+in.read()+" est dans l'état "+in.read());
            } catch (IOException e) {
                System.out.println("Fin de transmission des information pour ce baigneur.");
            }
        }
    }

    private String AutreInfo() throws IOException {
        char c='.';
        String s="";
        do{
            try {
                c=(char) in.read();
            }catch (Exception e){
                System.out.println("Transmission des informations.");
                fin=1;
                return "fin";
            }
            if(c!='.'){
                s=s+c;
            }

        }while(c!='.');
        try{
            return "message"+in.read();
        }catch (Exception e){
            e.getMessage();
            return "fin";
        }
    }
}