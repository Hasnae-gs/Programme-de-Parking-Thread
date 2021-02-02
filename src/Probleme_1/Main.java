package Probleme_1;

public class Main {

public static void main(String[] args) {
		
		int TailleParking=8;
		int nbVoitures=15; 
		Parking leParking = new Parking(TailleParking);

		Thread MesVoitures[] = new Thread[nbVoitures];

		for (int i =0; i< nbVoitures; i++){
			MesVoitures[i]= new Thread(new Voiture(String.format("Voit %d ", i) , leParking));
			MesVoitures[i].start();
		}
		
	}
}
