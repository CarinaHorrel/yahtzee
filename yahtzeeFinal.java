import java.util.Arrays;
import java.util.Scanner;
public class yahtzeeFinal{

	public static void main(String []args){
		Scanner input = new Scanner(System.in);

		// maak  5  objecten van class Dobbelsteen
		Dobbelsteen db1= new Dobbelsteen();
		Dobbelsteen db2= new Dobbelsteen();
		Dobbelsteen db3= new Dobbelsteen();
		Dobbelsteen db4= new Dobbelsteen();
		Dobbelsteen db5= new Dobbelsteen();

		// 1 keer gooien met 5 dobbelstenen	
		werpen(db1, db2, db3, db4, db5);

		// je mag maar maximaal 3 keer gooien
		int maxAantal=3;

		// zolang het maximale aantal keren gooien niet bereikt is mag men blijven gooien
		while (maxAantal>1){

			System.out.println("==> Met hoeveel dobbelstenen wilt u verder gooien?");

			int volgendeWorp=input.nextInt(); // inlezen via console
			int teller=1;	

			boolean doorGaan=true;            // men kan ook besluiten om niet meer te gooien

			while (teller<=volgendeWorp && doorGaan) {

				System.out.println("==> Welke dobbelsteen wilt u opnieuw gooien?");

				int dobbel = input.nextInt(); // welke dobbelsteen opnieuw gooien

				switch (dobbel){
				case 0: // men wil niet meer gooien
					doorGaan=false;
					break;
					// het resultaat van de verschillende dobbelstenen
				case 1:
					System.out.println();
					System.out.println("De waarde van dobbelsteen "+dobbel+" is "+db1.gooiDobbelsteen());
					break;
				case 2:
					System.out.println();
					System.out.println("De waarde van dobbelsteen "+dobbel+" is "+db2.gooiDobbelsteen());
					break;
				case 3:
					System.out.println();
					System.out.println("De waarde van dobbelsteen "+dobbel+" is "+db3.gooiDobbelsteen());
					break;
				case 4:
					System.out.println();
					System.out.println("De waarde van dobbelsteen "+dobbel+" is "+db4.gooiDobbelsteen());					
					break;
				case 5:
					System.out.println();
					System.out.println("De waarde van dobbelsteen "+dobbel+" is "+db5.gooiDobbelsteen());
					break;
				default: // verkeerde keuze van de speler
					System.out.println("Deze dobbelsteen bestaat niet");
					System.out.println("Doe een nieuwe poging");
					break;
				}
				// alleen in het geval dat de juiste, van de beschikbare dobvelstenen, mag de teller worden verhoogd
				// dus niet in het geval van de verkeerde keuze

				if (dobbel<=5) {
					teller++; // teller moet worden opgehoogd om een keer te eindigen
				}
			}
			System.out.println();
			System.out.println("==> U heeft "+volgendeWorp +" keer gegooid");
			System.out.println();

			showWorp(db1, db2, db3, db4, db5);

			teller=1;
			maxAantal--;

		} // einde while loop

		input.close(); //  sluit invoer via scanner af

		if (maxAantal==3) {
			System.out.println("U heeft maximaal drie worpen gedaan");
		}

		// zet het uiteindelijke resultaat van de vijf dobbelstenen in een array
		// ik maak een array van grootte 6, zodat ik 1 t/m 5 kan gebruiken voor het resultaat van de vijf dobbelstene
		int[] finalWorp = new int[] { 0, 0, 0, 0, 0, 0};// creates an array

		finalWorp[1] = db1.getValue(); // lees de waarde van dobbelsteen 1 in
		finalWorp[2] = db2.getValue(); // lees de waarde van dobbelsteen 2 in
		finalWorp[3] = db3.getValue(); // lees de waarde van dobbelsteen 3 in
		finalWorp[4] = db4.getValue(); // lees de waarde van dobbelsteen 4 in
		finalWorp[5] = db5.getValue(); // lees de waarde van dobbelsteen 5 in

		System.out.println();
		System.out.println("Het resultaat van de uiteidelijke worp is: ");
		System.out.println();

		// sorteer de array-elementen om de verschillende combinaties van het spel te kunnen maken
		Arrays.sort(finalWorp);

		// tel het aantal gelijke ogen van de 5 dobbelstenen
		// intializatie 
		int ones = 0,  twos= 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		for (int y = 1; y <= 5; y++) {
			if (finalWorp[y] == 1) {
				ones++;
			}
			if (finalWorp[y] == 2) {
				twos++;
			}
			if (finalWorp[y] == 3) {
				threes++;
			}
			if (finalWorp[y] == 4) {
				fours++;
			}
			if (finalWorp[y] == 5) {
				fives++;
			}
			if (finalWorp[y] == 6) {
				sixes++;
			}
		}

		System.out.println("Aantal enen gegooid: "+ones);
		System.out.println("Aantal tweeen gegooid: "+twos);
		System.out.println("Aantal drieen gegooid: "+threes);
		System.out.println("Aantal vieren gegooid: "+fours);
		System.out.println("Aantal vijven gegooid: "+fives);
		System.out.println("Aantal zessen gegooid: "+sixes);

		//Straten
		int winingsa = 0;
	    if ((finalWorp[1] == finalWorp[2] - 1) && (finalWorp[2] == finalWorp[3] - 1)
	        && (finalWorp[3] == finalWorp[4] - 1) && (finalWorp[4] == finalWorp[5] - 1)){
	      winingsa = 1;
	    } else if ((ones > 0) && (twos > 0) && (threes > 0) && (fours > 0)) {
	      winingsa = 2;
	    } else if ((threes > 0) && (fours > 0) && (fives > 0) && (sixes > 0)) {
	      winingsa = 2;
	    } else if ((twos > 0) && (threes > 0) && (fours > 0) && (fives > 0)) {
	      winingsa = 2;
	    }
	    
		// tel het aantal paren
		// Paren
	    int x = 1, winings = 0;
	    for (x = 1; x <= 5; x++) {
	      if (x != 1) {
	        if ((finalWorp[1] == finalWorp[x])) {
	          winings++;
	        }
	      }
	      if ((x != 1) && (x != 2)) {
	        if ((finalWorp[2] == finalWorp[x])) {
	          winings++;
	        }
	      }
	      if ((x != 1) && (x != 2) && (x != 3)) {
	        if ((finalWorp[3] == finalWorp[x])) {
	          winings++;
	        }
	      }
	      if ((x != 1) && (x != 2) && (x != 3) && (x != 4)) {
	        if ((finalWorp[4] == finalWorp[x])) {
	          winings++;
	        }
	      }
	    }	    
	    
	    if ((winingsa == 1)) {
		      System.out.println("Je hebt een grote straat.");
	    }else if ((winingsa == 2)) {
		      System.out.println("Je hebt een kleine straat.");
		}else if (winings == 10) {
		     System.out.println("Yatzee!");
		}else if (winings >= 3) {
		      System.out.println("Je hebt drie van dezelfde soort.");
		}else if (winings>0) {
			System.out.println("Je hebt een paar.");
		}else if (winings==2) {
			System.out.println("Je hebt zelfs twee paren!");
		}else if (winings == 4)  {
		      System.out.println("Je hebt een full house.");
		}else if(winings >= 6) {
		      System.out.println("Je hebt vier van dezelfde soort.");		      
		}else {
		      System.out.println("Je hebt niets.");
		}
	}

	static void werpen(Dobbelsteen d1, Dobbelsteen d2, Dobbelsteen d3, Dobbelsteen d4, Dobbelsteen d5){
		// show result voor elke dobbelsteen
		System.out.print("Het resultaat van eerste keer gooien is: ");
		System.out.print(d1.gooiDobbelsteen()+"\t");
		System.out.print(d2.gooiDobbelsteen()+"\t");
		System.out.print(d3.gooiDobbelsteen()+"\t");
		System.out.print(d4.gooiDobbelsteen()+"\t");
		System.out.print(d5.gooiDobbelsteen()+"\t");
		System.out.println();
	}

	static void showWorp(Dobbelsteen d1, Dobbelsteen d2, Dobbelsteen d3, Dobbelsteen d4, Dobbelsteen d5){
		// show result voor elke dobbelsteen
		System.out.print("Het resultaat van deze worp is: ");
		System.out.print(d1.getValue()+"\t");
		System.out.print(d2.getValue()+"\t");
		System.out.print(d3.getValue()+"\t");
		System.out.print(d4.getValue()+"\t");
		System.out.print(d5.getValue()+"\t");
		System.out.println();
	}
}
