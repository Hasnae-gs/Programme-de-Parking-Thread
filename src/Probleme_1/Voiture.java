package Probleme_1;

public class Voiture implements Runnable { 
	String nom; 
	Parking park;
	
	public Voiture(String name, Parking park){
		this.nom=name; 
		this.park=park; 
	}
	public String toString(){ return this.nom;} 
	
	public void rentrer() throws InterruptedException{	
		while (!(this.park.accept(this)))
		{
            Thread.sleep((long)  (1000* Math.random()));
    		System.out.format("[%s]  : Je redemande à  rentrer  \n", this.nom);
		}
	}
	
	public void run(){ 
	System.out.format("[%s]: Je débute !  \n", this.nom);
	try {
		
	while(true){
		Thread.sleep((long)  (50000* Math.random()));
		System.out.format("[%s]: Je demande à  rentrer  \n", this.nom);
		this.rentrer();
		System.out.format("[%s]: Je viens d'entrer \n", this.nom);
		Thread.sleep((long)  (50000* Math.random()));
	    System.out.format("[%s]: Je demande à  sortir  \n", this.nom);
	    this.park.leave(this);  

	}}
	catch (InterruptedException e) {
		e.printStackTrace();	}
	}
	
	
	
}