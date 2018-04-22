package pokusaj_prvi.com;
import java.util.ArrayList;
public class Raspored {

	public static ArrayList<ArrayList<ArrayList<String>>> dani= new ArrayList<>();
	public static ArrayList<ArrayList<String>> ponedeljak = new ArrayList<>();
	public static ArrayList<ArrayList<String>> utorak = new ArrayList<>();
	public static ArrayList<ArrayList<String>> sreda = new ArrayList<>();
	public static ArrayList<String> pred1 = new ArrayList<>();
	public static ArrayList<String> pred2 = new ArrayList<>();
	public static ArrayList<String> pred3 = new ArrayList<>();
	public static ArrayList<String> pred4 = new ArrayList<>();
	public static ArrayList<String> pred5 = new ArrayList<>();
	public static ArrayList<String> pred6 = new ArrayList<>();
	public static ArrayList<String> pred7 = new ArrayList<>();
	public static ArrayList<String> pred8 = new ArrayList<>();
	public static ArrayList<String> pred9 = new ArrayList<>();
	public static ArrayList<String> pred10 = new ArrayList<>();
	public static ArrayList<String> pred11 = new ArrayList<>();
	public static ArrayList<String> pred12 = new ArrayList<>();
	public static ArrayList<String> pred13 = new ArrayList<>();
	public static ArrayList<String> pred14 = new ArrayList<>();
	public static ArrayList<String> pred15 = new ArrayList<>();
	public static ArrayList<String> pred16 = new ArrayList<>();
	public static ArrayList<String> pred17 = new ArrayList<>();
	public static ArrayList<String> pred18 = new ArrayList<>();


	public static void ponedeljak(){
		//ponedeljak
		pred1.add("L6");
		pred1.add("Zeljko Vukovic");
		pred1.add("7");
		pred1.add("0");
		pred1.add("8");
		pred1.add("30");
		pred1.add("Internet mreze");
		pred1.add("Novi Sad");

		pred2.add("MI2");
		pred2.add("Zeljko Vukovic");
		pred2.add("9");
		pred2.add("45");
		pred2.add("11");
		pred2.add("15");
		pred2.add("Internet mreze");
		pred2.add("Novi Sad");

		pred3.add("L6");
		pred3.add("Sinisa Nikolic");
		pred3.add("17");
		pred3.add("30");
		pred3.add("19");
		pred3.add("0");
		pred3.add("Internet mreze");
		pred3.add("Novi Sad");

		pred4.add("PC6");
		pred4.add("Aleksandar Kaplar");
		pred4.add("17");
		pred4.add("30");
		pred4.add("20");
		pred4.add("0");
		pred4.add("Web programiranje");
		pred4.add("Novi Sad");

		pred5.add("PC5");
		pred5.add("Sinisa Nikolic");
		pred5.add("9");
		pred5.add("45");
		pred5.add("10");
		pred5.add("15");
		pred5.add("Sis. baz. na znanju");
		pred5.add("Novi Sad");

		pred6.add("PC5");
		pred6.add("Sinisa Nikolic");
		pred6.add("15");
		pred6.add("15");
		pred6.add("17");
		pred6.add("45");
		pred6.add("Sis. baz. na znanju");
		pred6.add("Novi Sad");

		pred7.add("K1");
		pred7.add("Aleksandar Kaplar");
		pred7.add("9");
		pred7.add("0");
		pred7.add("11");
		pred7.add("45");
		pred7.add("Web programiranje");
		pred7.add("Loznica");

		pred8.add("K2");
		pred8.add("Aleksandar Kaplar");
		pred8.add("12");
		pred8.add("15");
		pred8.add("15");
		pred8.add("0");
		pred8.add("Sis. baz. na znanju");
		pred8.add("Loznica");

	}
	public static void utorak(){
		//Utorak
		pred9.add("MI2");
		pred9.add("Zeljko Vukovic");
		pred9.add("10");
		pred9.add("30");
		pred9.add("12");
		pred9.add("0");
		pred9.add("Internet mreze");
		pred9.add("Novi Sad");

		pred10.add("MI2");
		pred10.add("Valentin Penca");
		pred10.add("9");
		pred10.add("45");
		pred10.add("11");
		pred10.add("15");
		pred10.add("Web prorgamiranje");
		pred10.add("Novi Sad");

		pred11.add("PCA");
		pred11.add("Segedinac Milan");
		pred11.add("14");
		pred11.add("15");
		pred11.add("16");
		pred11.add("0");
		pred11.add("XML i WEB servisi");
		pred11.add("Novi Sad");


		pred12.add("PC3");
		pred12.add("Segedinac Milan");
		pred12.add("16");
		pred12.add("10");
		pred12.add("17");
		pred12.add("30");
		pred12.add("Web prorgamiranje");
		pred12.add("Novi Sad");
	}
	public static void sreda(){		
		//sreda

		pred13.add("L6");
		pred13.add("Sinisa Nikolic");
		pred13.add("12");
		pred13.add("30");
		pred13.add("16");
		pred13.add("0");
		pred13.add("Obj. programiranje");
		pred13.add("Novi Sad");

		pred14.add("L3");
		pred14.add("Sinisa Nikolic");
		pred14.add("7");
		pred14.add("0");
		pred14.add("8");
		pred14.add("30");
		pred14.add("Internet mreze");
		pred14.add("Novi Sad");

		pred15.add("MI2");
		pred15.add("Zeljko Vukovic");
		pred15.add("10");
		pred15.add("30");
		pred15.add("12");
		pred15.add("0");
		pred15.add("Internet mreze");
		pred15.add("Novi Sad");

		pred16.add("L3");
		pred16.add("Sinisa Nikolic");
		pred16.add("10");
		pred16.add("30");
		pred16.add("12");
		pred16.add("0");
		pred16.add("Internet mreze");
		pred16.add("Novi Sad");

		pred17.add("MI2");
		pred17.add("Zeljko Vukovic");
		pred17.add("11");
		pred17.add("30");
		pred17.add("13");
		pred17.add("0");
		pred17.add("Internet mreze");
		pred17.add("Novi Sad");

		pred18.add("L6");
		pred18.add("Zeljko Vukovic");
		pred18.add("14");
		pred18.add("0");
		pred18.add("15");
		pred18.add("30");
		pred18.add("XML i WEB servisi");
		pred18.add("Novi Sad");


	}

	public static void unosPreUDane(){ //unos lista predavanja u dane, a zatim listu dane u listu dani
		ponedeljak.add(pred1);
		ponedeljak.add(pred2);
		ponedeljak.add(pred3);
		ponedeljak.add(pred4);
		ponedeljak.add(pred5);
		ponedeljak.add(pred6);
		ponedeljak.add(pred7);
		ponedeljak.add(pred8);

		utorak.add(pred9);
		utorak.add(pred10);
		utorak.add(pred11);
		utorak.add(pred12);

		sreda.add(pred13);
		sreda.add(pred14);
		sreda.add(pred15);
		sreda.add(pred16);
		sreda.add(pred17);
		sreda.add(pred18);

		dani.add(ponedeljak);
		dani.add(utorak);
		dani.add(sreda);
	}
	//	pred1.clear();  // ne moze da se koristi posto koristi istu listu, ne pravi kopiju

	public static void stampa() {

		for(int i =0;i<dani.size();i++) {
			if(i==0){
				//		System.out.println("_________________________________________________________________________________________________________________________________________________________");
				System.out.println("_________________________________________________________________________________________________________________________________________________________");

				//		System.out.println();

				System.out.println("********************************************************************* PONEDELjAK ************************************************************************");


			}else if(i==1) {

				System.out.println("_________________________________________________________________________________________________________________________________________________________");
				System.out.println("_________________________________________________________________________________________________________________________________________________________");

				System.out.println();

				System.out.println("*********************************************************************   UTORAK   ************************************************************************");

			}else if(i==2) {
				System.out.println("_________________________________________________________________________________________________________________________________________________________");
				System.out.println("_________________________________________________________________________________________________________________________________________________________");

				System.out.println();
				System.out.println("*********************************************************************    SREDA    ************************************************************************");

			}
			//		System.out.println("_________________________________________________________________________________________________________________________________________________________");

			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

			System.out.printf("%7s\t%17s\t%23s\t%15s\t%15s\t%15s\t%16s\t%22s\n","Kabinet","Predavac", "Od-Sat", "Od-Min", "Do-Sat", "Do-Min", "Predmet", "Mesto");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
			//System.out.println("_________________________________________________________________________________________________________________________________________________________");

			for(int j=0;j<dani.get(i).size();j++) {
				for(int k=0;k<dani.get(i).get(j).size();k++) {
					System.out.print(dani.get(i).get(j).get(k) + " \t\t "); 
				}
				System.out.println();

			}

		}
		System.out.println("_________________________________________________________________________________________________________________________________________________________");
		System.out.println("_________________________________________________________________________________________________________________________________________________________");
		System.out.println();
	}

	public static void kolizije() {
		System.out.println("************************************************************** PRONADJENE KOLIZIJE *****************************************************************");

		for(int i =0;i<dani.size();i++) {
			if(i==0){
				//		System.out.println("_________________________________________________________________________________________________________________________________________________________");
				System.out.println("_________________________________________________________________________________________________________________________________________________________");

				//		System.out.println();

				System.out.println("********************************************************************* PONEDELjAK ************************************************************************");


			}else if(i==1) {

				System.out.println("_________________________________________________________________________________________________________________________________________________________");
				System.out.println("_________________________________________________________________________________________________________________________________________________________");

				System.out.println();

				System.out.println("*********************************************************************   UTORAK   ************************************************************************");

			}else if(i==2) {
				System.out.println("_________________________________________________________________________________________________________________________________________________________");
				System.out.println("_________________________________________________________________________________________________________________________________________________________");

				System.out.println();
				System.out.println("*********************************************************************    SREDA    ************************************************************************");

			}
			//		System.out.println("_________________________________________________________________________________________________________________________________________________________");

			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

			//		System.out.printf("%7s\t%17s\t%23s\t%15s\t%15s\t%15s\t%16s\t%22s\n","Kabinet","Predavac", "Od-Sat", "Od-Min", "Do-Sat", "Do-Min", "Predmet", "Mesto");
			//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
			//System.out.println("_________________________________________________________________________________________________________________________________________________________");

			for(int j= 0; j<dani.get(i).size()-1; j++){

				for(int k = j+1 ; k< dani.get(i).size();k++) {

					if(dani.get(i).get(j).get(1).equals(dani.get(i).get(k).get(1))) {

						int pauza = 15; //15minuta pauze izmedju svih predavanja

						if(!dani.get(i).get(j).get(7).equals(dani.get(i).get(k).get(7))) {

							//ako je isti grad onda se koristi pauza od 15 min, ako nije onda se koristi pauza od 195min	
							pauza = 195; // 3 sata puta 60 min +15 min pauze = 195 min

						}
						//prebacivbanje svih predavanja, pocetka i graja u minute,
						//u prvom pokusaju sam imao double, pa je bilo dosta teze preracunati u sve minute u podeoke sata.
						//pre toga moramo vrsiti konverziju iz stringa u int, posto su mi sve liste, liste stringova.
						//i. ulazi u listu dana, j. ulazi u odredjeni dan, (2)na poziciji 2 je vreme u statima, na poziciji (3) su minuti. 
						//dani.get(i).get(j).get(2)
						//ako ima pauze izmedju predavanja, mora znaciti da imate pre svakog predavanja pauzu.

						int od1 = Integer.parseInt(dani.get(i).get(j).get(2))*60 + Integer.parseInt(dani.get(i).get(j).get(3)) - pauza;
						int do1 = Integer.parseInt(dani.get(i).get(j).get(4))*60 + Integer.parseInt(dani.get(i).get(j).get(5)) + pauza;

						int od2 = Integer.parseInt(dani.get(i).get(k).get(2))*60 + Integer.parseInt(dani.get(i).get(k).get(3));
						int do2 = Integer.parseInt(dani.get(i).get(k).get(4))*60 + Integer.parseInt(dani.get(i).get(k).get(5));

						if((od2>od1 && od2<do1) || (do2>od1 && do2<do1)) {
							System.out.println();
							System.out.println("POSTOJE PREKLAPANJA ZA ODREDJENOG PROFESORA");
							System.out.println();
							System.out.println(dani.get(i).get(j).get(1) + " IMA PROBLEM SA RASPOREDOM ZBOG VREMENA");
							System.out.println();
							// pozicija profesora u listi
							//treba i prikazati koji su to termini
							//imam mali problem oko prikaza;
							if(od1<od2) {
								//			System.out.printf("%7s\t%17s\t%23s\t%15s\t%15s\t%15s\t%16s\t%22s\n","Kabinet","Predavac", "Od-Sat", "Od-Min", "Do-Sat", "Do-Min", "Predmet", "Mesto");
								for(int x =0 ; x< dani.get(i).get(j).size();x++) {
									System.out.print(dani.get(i).get(j).get(x) + "\t\t");

								}

								//System.out.println(dani.get(i).get(j).get(0) +dani.get(i).get(j).get(1) + dani.get(i).get(j).get(1) +dani.get(i).get(j).get(3) + );
								System.out.println(); 
								for(int x =0 ; x< dani.get(i).get(j).size();x++) {
									System.out.print(dani.get(i).get(k).get(x) + "\t\t");

								}
							}else {
								//				System.out.printf("%7s\t%17s\t%23s\t%15s\t%15s\t%15s\t%16s\t%22s\n","Kabinet","Predavac", "Od-Sat", "Od-Min", "Do-Sat", "Do-Min", "Predmet", "Mesto");
								for(int x =0 ; x< dani.get(i).get(j).size();x++) {
									System.out.print(dani.get(i).get(k).get(x) + "\t\t");

								}

								//System.out.println(dani.get(i).get(j).get(0) +dani.get(i).get(j).get(1) + dani.get(i).get(j).get(1) +dani.get(i).get(j).get(3) + );
								System.out.println(); 
								for(int x =0 ; x< dani.get(i).get(j).size();x++) {
									System.out.print(dani.get(i).get(j).get(x) + "\t\t");

								}
							}
							System.out.println();
						}

					}
					//nakon provere zauzeca profesora treba prveriti da li su u pitanju iste prostorije
					//posto je to jos jedan slucaj kolizije
					if(dani.get(i).get(j).get(0).equals(dani.get(i).get(k).get(0))) {
						int pauza =15;
						int od1 = Integer.parseInt(dani.get(i).get(j).get(2))*60 + Integer.parseInt(dani.get(i).get(j).get(3)) - pauza;
						int do1 = Integer.parseInt(dani.get(i).get(j).get(4))*60 + Integer.parseInt(dani.get(i).get(j).get(5)) + pauza;

						int od2 = Integer.parseInt(dani.get(i).get(k).get(2))*60 + Integer.parseInt(dani.get(i).get(k).get(3));
						int do2 = Integer.parseInt(dani.get(i).get(k).get(4))*60 + Integer.parseInt(dani.get(i).get(k).get(5));

						if((od2>od1 && od2<do1) || (do2>od1 && do2<do1)) {
							
							System.out.println("SLEDECI KABINETI SU ZAUZETI U TO VREME");
							System.out.println(dani.get(i).get(j).get(0) + " JE DODELJEN SLEDECIM PROFESORIMA I TI TERMINI SE PREKLAPAJU");
							if(od1<od2) {
								//			System.out.printf("%7s\t%17s\t%23s\t%15s\t%15s\t%15s\t%16s\t%22s\n","Kabinet","Predavac", "Od-Sat", "Od-Min", "Do-Sat", "Do-Min", "Predmet", "Mesto");
								for(int x =0 ; x< dani.get(i).get(j).size();x++) {
									System.out.print(dani.get(i).get(j).get(x) + "\t\t");

								}

								//System.out.println(dani.get(i).get(j).get(0) +dani.get(i).get(j).get(1) + dani.get(i).get(j).get(1) +dani.get(i).get(j).get(3) + );
								System.out.println(); 
								for(int x =0 ; x< dani.get(i).get(j).size();x++) {
									System.out.print(dani.get(i).get(k).get(x) + "\t\t");

								}
							}else {
								///			System.out.printf("%7s\t%17s\t%23s\t%15s\t%15s\t%15s\t%16s\t%22s\n","Kabinet","Predavac", "Od-Sat", "Od-Min", "Do-Sat", "Do-Min", "Predmet", "Mesto");
								for(int x =0 ; x< dani.get(i).get(j).size();x++) {
									System.out.print(dani.get(i).get(k).get(x) + "\t\t");

								}

								//System.out.println(dani.get(i).get(j).get(0) +dani.get(i).get(j).get(1) + dani.get(i).get(j).get(1) +dani.get(i).get(j).get(3) + );
								System.out.println(); 
								for(int x =0 ; x< dani.get(i).get(j).size();x++) {
									System.out.print(dani.get(i).get(j).get(x) + "\t\t");

								}
							}
						}
					}

				}
			}

		}
	}


	public static void main(String[] args) {

		ponedeljak();
		utorak();
		sreda();
		unosPreUDane();
		stampa();
		kolizije();



	}



}
