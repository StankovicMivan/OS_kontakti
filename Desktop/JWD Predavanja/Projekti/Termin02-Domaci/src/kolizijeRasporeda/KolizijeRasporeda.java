package kolizijeRasporeda;

/***
 * @uthor = Sinisa Nikolic
 */

public class KolizijeRasporeda {

	public static void kreirajRaspored(String [][][] raspored){
		//ukupno 8 kolona za opis: Kabinet, Predavac, odSati, odMinuta, doSati, doMinuta, Predmet, Mesto
		raspored[0] = new String [8][8]; 			//ponedeljak 8 predavanja
		raspored[1] = new String [4][8];			//utorak 4 predavanja
		raspored[2] = new String [6][8];			//sreda 6 predavanja

		// 										PONEDELJAK
		//Ponedeljak predavanje 1.
		raspored [0][0][0] = "L6";
		raspored [0][0][1] = "Zeljko Vukovic";
		raspored [0][0][2] = "7";
		raspored [0][0][3] = "0";
		raspored [0][0][4] = "8";
		raspored [0][0][5] = "30";
		raspored [0][0][6] = "Internet mreze";
		raspored [0][0][7] = "Novi Sad";
		//Ponedeljak predavanje 2.
		raspored [0][1][0] = "MI2";
		raspored [0][1][1] = "Zeljko Vukovic";
		raspored [0][1][2] = "9";
		raspored [0][1][3] = "45";
		raspored [0][1][4] = "11";
		raspored [0][1][5] = "15";
		raspored [0][1][6] = "Internet mreze";
		raspored [0][1][7] = "Novi Sad";
		//Ponedeljak predavanje 3.
		raspored [0][2][0] = "L6";
		raspored [0][2][1] = "Sinisa Nikolic";
		raspored [0][2][2] = "17";
		raspored [0][2][3] = "30";
		raspored [0][2][4] = "19";
		raspored [0][2][5] = "0";
		raspored [0][2][6] = "Internet mreze";
		raspored [0][2][7] = "Novi Sad";
		//Ponedeljak predavanje 4.
		raspored [0][3][0] = "PC6";
		raspored [0][3][1] = "Aleksandar Kaplar";
		raspored [0][3][2] = "17";
		raspored [0][3][3] = "30";
		raspored [0][3][4] = "20";
		raspored [0][3][5] = "0";
		raspored [0][3][6] = "Web prorgamiranje";
		raspored [0][3][7] = "Novi Sad";
		//Ponedeljak predavanje 5.
		raspored [0][4][0] = "PC5";
		raspored [0][4][1] = "Sinisa Nikolic";
		raspored [0][4][2] = "9";
		raspored [0][4][3] = "45";
		raspored [0][4][4] = "10";
		raspored [0][4][5] = "15";
		raspored [0][4][6] = "Sistemi bazirani na znanju";
		raspored [0][4][7] = "Novi Sad";
		//Ponedeljak predavanje 6.
		raspored [0][5][0] = "PC5";
		raspored [0][5][1] = "Sinisa Nikolic";
		raspored [0][5][2] = "15";
		raspored [0][5][3] = "15";
		raspored [0][5][4] = "17";
		raspored [0][5][5] = "45";
		raspored [0][5][6] = "Sistemi bazirani na znanju";
		raspored [0][5][7] = "Novi Sad";
		//Ponedeljak predavanje 7.
		raspored [0][6][0] = "K1";
		raspored [0][6][1] = "Aleksandar Kaplar";
		raspored [0][6][2] = "9";
		raspored [0][6][3] = "0";
		raspored [0][6][4] = "11";
		raspored [0][6][5] = "45";
		raspored [0][6][6] = "Web programiranje";
		raspored [0][6][7] = "Loznica";
		//Ponedeljak predavanje 8.
		raspored [0][7][0] = "K2";
		raspored [0][7][1] = "Aleksandar Kaplar";
		raspored [0][7][2] = "12";
		raspored [0][7][3] = "15";
		raspored [0][7][4] = "15";
		raspored [0][7][5] = "0";
		raspored [0][7][6] = "Sistemi bazirani na znanju";
		raspored [0][7][7] = "Loznica";
		//														UTORAK
		//Utorak predavanje 1.
		raspored [1][0][0] = "MI2";
		raspored [1][0][1] = "Zeljko Vukovic";
		raspored [1][0][2] = "10";
		raspored [1][0][3] = "30";
		raspored [1][0][4] = "12";
		raspored [1][0][5] = "0";
		raspored [1][0][6] = "Internet mreze";
		raspored [1][0][7] = "Novi Sad";
		//Utorak predavanje 2.
		raspored [1][1][0] = "MI2";
		raspored [1][1][1] = "Valentin Penca";
		raspored [1][1][2] = "9";
		raspored [1][1][3] = "45";
		raspored [1][1][4] = "11";
		raspored [1][1][5] = "15";
		raspored [1][1][6] = "Web prorgamiranje";
		raspored [1][1][7] = "Novi Sad";
		//Utorak predavanje 3.
		raspored [1][2][0] = "PCA";
		raspored [1][2][1] = "Segedinac Milan";
		raspored [1][2][2] = "14";
		raspored [1][2][3] = "15";
		raspored [1][2][4] = "16";
		raspored [1][2][5] = "0";
		raspored [1][2][6] = "XML i WEB servisi";
		raspored [1][2][7] = "Novi Sad";
		//Utorak predavanje 4.
		raspored [1][3][0] = "PC3";
		raspored [1][3][1] = "Segedinac Milan";
		raspored [1][3][2] = "16";
		raspored [1][3][3] = "10";
		raspored [1][3][4] = "17";
		raspored [1][3][5] = "30";
		raspored [1][3][6] = "Web prorgamiranje";
		raspored [1][3][7] = "Novi Sad";
		//														SREDA
		//Sreda predavanje 1.
		raspored [2][0][0] = "L6";
		raspored [2][0][1] = "Sinisa Nikolic";
		raspored [2][0][2] = "12";
		raspored [2][0][3] = "30";
		raspored [2][0][4] = "16";
		raspored [2][0][5] = "0";
		raspored [2][0][6] = "Objektno programiranje";
		raspored [2][0][7] = "Novi Sad";
		//Sreda predavanje 2.
		raspored [2][1][0] = "L3";
		raspored [2][1][1] = "Sinisa Nikolic";
		raspored [2][1][2] = "7";
		raspored [2][1][3] = "0";
		raspored [2][1][4] = "8";
		raspored [2][1][5] = "30";
		raspored [2][1][6] = "Internet mreze";
		raspored [2][1][7] = "Novi Sad";
		//Sreda predavanje 3.
		raspored [2][2][0] = "MI2";
		raspored [2][2][1] = "Zeljko Vukovic";
		raspored [2][2][2] = "10";
		raspored [2][2][3] = "30";
		raspored [2][2][4] = "12";
		raspored [2][2][5] = "0";
		raspored [2][2][6] = "Internet mreze";
		raspored [2][2][7] = "Novi Sad";
		//Sreda predavanje 4.
		raspored [2][3][0] = "L3";
		raspored [2][3][1] = "Sinisa Nikolic";
		raspored [2][3][2] = "10";
		raspored [2][3][3] = "30";
		raspored [2][3][4] = "12";
		raspored [2][3][5] = "0";
		raspored [2][3][6] = "Internet mreze";
		raspored [2][3][7] = "Novi Sad";
		//Sreda predavanje 5.
		raspored [2][4][0] = "MI2";
		raspored [2][4][1] = "Zeljko Vukovic";
		raspored [2][4][2] = "11";
		raspored [2][4][3] = "30";
		raspored [2][4][4] = "13";
		raspored [2][4][5] = "0";
		raspored [2][4][6] = "Internet mreze";
		raspored [2][4][7] = "Novi Sad";
		//Sreda predavanje 6.
		raspored [2][5][0] = "L6";
		raspored [2][5][1] = "Zeljko Vukovic";
		raspored [2][5][2] = "14";
		raspored [2][5][3] = "0";
		raspored [2][5][4] = "15";
		raspored [2][5][5] = "30";
		raspored [2][5][6] = "XML i WEB servisi";
		raspored [2][5][7] = "Novi Sad";
	}

	public static void ispisiRaspored(String [][][] raspored){

		for (int i = 0; i < raspored.length; i++) {
			ispisiDan(i);
			//zaglavlje
			System.out.printf("%6s\t%7s\t%-20s\t%7s\t%7s\t%7s\t%7s\t%-30s\t%-20s\n","Termin","Kabinet","Predavac", "Poc-Sat", "Poc-Min", "Kra-Sat", "Kra-Min", "Predmet", "Mesto");
			System.out.printf("%6s\t%7s\t%-20s\t%7s\t%7s\t%7s\t%7s\t%-30s\t%-20s\n","======","=======","========", "=======", "=======", "=======", "=======", "=======", "=====");

			for (int j = 0; j < raspored[i].length; j++) {
				ispisiTermin((j+1), raspored[i][j]);
			}
		}
	}

	public static void ispisiDan(int i){
		switch (i) {
		case 0:
			System.out.println("\n-----------------------------Ponedeljak-----------------------------\n");
			break;
		case 1:
			System.out.println("\n-------------------------------Utorak-------------------------------\n");
			break;
		case 2:
			System.out.println("\n-------------------------------Sreda--------------------------------\n");
			break;
		}
	}

	public static void ispisiTermin(int redBr, String [] termin){
		System.out.printf("%6s\t%7s\t%-20s\t%7s\t%7s\t%7s\t%7s\t%-30s\t%-20s\n",redBr,termin[0], termin[1],
				termin[2], termin[3], termin[4], termin[5], termin[6], termin[7]);
	}

	public static void ispisiDvaTermina(String [] termin1, String [] termin2){

		System.out.printf("\t%7s\t%-20s\t%7s\t%7s\t%7s\t%7s\t%-30s\t%-20s\n",termin1[0], termin1[1],
				termin1[2], termin1[3], termin1[4], termin1[5], termin1[6], termin1[7]);
		System.out.printf("\t%7s\t%-20s\t%7s\t%7s\t%7s\t%7s\t%-30s\t%-20s\n",termin2[0], termin2[1],
				termin2[2], termin2[3], termin2[4], termin2[5], termin2[6], termin2[7]);
	}

	public static void odrediKolizije(String [][][] raspored){
		for (int i = 0; i < raspored.length; i++) { //dani
			ispisiDan(i);

			for (int j = 0; j < raspored[i].length-1; j++) { //termin koji se uzima kao referentni

				for (int k = j+1; k < raspored[i].length; k++) { //termini koji se porede sa referentnim terminom

					if(raspored[i][j][1].equals(raspored[i][k][1])){ //ako su u pitanju isti predavaci

						int dodatnoVremeIzmedjuPredavanjaUMinutima = 15;  //ako se nastava odvija u istom gradu onda mora biti minimum 15min izmeÄ‘u predavanja da bi se nastavnik pripremio
						if(!raspored[i][j][7].equals(raspored[i][k][7])){ //ako nisu isti gradovi onda mora biti minimum 3h i 15min izmeÄ‘u predavanja da bi se nastavnik pripremio
							dodatnoVremeIzmedjuPredavanjaUMinutima = 195;
						}
						//1 dan ima 24 sati po 60 minuta to je 1440 minuta za ceo dan
						//sve prebacujemo u minute da bi lakse poredili

						int pocetak1 = Integer.parseInt(raspored[i][j][2])*60 + Integer.parseInt(raspored[i][j][3])-dodatnoVremeIzmedjuPredavanjaUMinutima; //pre poÄ�etka predavanja predavaÄ� mara da ima 15 minuta slobodno
						int kraj1 = Integer.parseInt(raspored[i][j][4])*60 + Integer.parseInt(raspored[i][j][5])+dodatnoVremeIzmedjuPredavanjaUMinutima; //posle kraja predavanja predavaÄ� mara da ima 15 minuta slobodno

						int pocetak2 = Integer.parseInt(raspored[i][k][2])*60 + Integer.parseInt(raspored[i][k][3]);
						int kraj2 = Integer.parseInt(raspored[i][k][4])*60 + Integer.parseInt(raspored[i][k][5]);

						//sledeci kod obezbeÄ‘uje poreÄ‘enje vremena u kome su uracunati dodatni minuti izmeÄ‘u termina
						if((pocetak2>pocetak1 && pocetak2<kraj1) || (kraj2>pocetak1 && kraj2<kraj1)){
							System.out.println("****PREKLAPANJA TERMINA PROFESORA***********");
							System.out.println("Profesor: " + raspored[i][j][1] + " ima preklapanja u rasporedu.");
							if(pocetak1<pocetak2){
								ispisiDvaTermina(raspored[i][j], raspored[i][k]);
							} else {
								ispisiDvaTermina(raspored[i][k], raspored[i][j]);
							}	
						}
					}
					if(raspored[i][j][0].equals(raspored[i][k][0])){ //ako su u pitanju isti kabineti

						int dodatnoVremeIzmedjuPredavanjaUMinutima = 15;  //ako se nastava odvija u istom gradu onda mora biti minimum 15min izmeÄ‘u predavanja da bi se ispraznio kabinet i usli novi studenti

						//pocetak i kraj prevedeno u minute
						int pocetak1 = Integer.parseInt(raspored[i][j][2])*60 + Integer.parseInt(raspored[i][j][3])-dodatnoVremeIzmedjuPredavanjaUMinutima;
						int kraj1 = Integer.parseInt(raspored[i][j][4])*60 + Integer.parseInt(raspored[i][j][5])+dodatnoVremeIzmedjuPredavanjaUMinutima;

						int pocetak2 = Integer.parseInt(raspored[i][k][2])*60 + Integer.parseInt(raspored[i][k][3]);
						int kraj2 = Integer.parseInt(raspored[i][k][4])*60 + Integer.parseInt(raspored[i][k][5]);

						if((pocetak2>pocetak1 && pocetak2<kraj1) || (kraj2>pocetak1 && kraj2<kraj1)){
							System.out.println("****PREKLAPANJA ZAUZECA KABINETA***********");
							System.out.println("Kabinet: " + raspored[i][j][0] + " ima preklapanja u rasporedu.");
							if(pocetak1<pocetak2){
								ispisiDvaTermina(raspored[i][j], raspored[i][k]);
							} else {
								ispisiDvaTermina(raspored[i][k], raspored[i][j]);
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		/*10. DomaÄ‡i zadatak
		-------------------
		U xls fajlu rasporedKolizije prikazana je inicijalna verzija rasporeda predavanja. 
		Raspored sadrzi kolizije koje se ogledaju u preklapanju zauzeÄ‡a kabineta, preklapanju angazmana predavaca.
		Potrebno je detektovati i ispisati sve kolizije ako je pretpostavka da su termini sortirani po poÄ�etku odrÅ¾avanja. 
		1. Sve kolizije preklapanja zauzeÄ‡a kabineta
		2. Sve kolizije preklapanja zauzeÄ‡a predavaca
		3. Sve kolizije preklapanja zauzeÄ‡a predavaca (Voditi raÄ�una da izmeÄ‘u termina predavanja mora postojati 15 minuta pauze)
		4. Sve kolizije preklapanja zauzeÄ‡a predavaca ako se razmatra i kartica SIT - Lozica, pri Ä�emu put Novi Sad - Loznica traje 3 h

		Za kreiranje zadatka koristiti matrice.
		Sugestija: Vrste neka predstavljau dane u nedelji, dok Ä‡e kolone predstavljati termin u rasporedu. 
		Termin u rasporedu mogao bi se opisati osmorkom u fomratu: Kabinet, Predavac, odSati, odMinuta, doSati, doMinuta, Predmet, Mesto*/

		String [][][] raspored = new String [3][][]; //samo za tri dana je dato u zadatku zato samo tri vrste

		kreirajRaspored(raspored);
		System.out.println("********************************************************************");
		System.out.println("|               Ispisivanje trenutnog rasporeda                    |");
		System.out.println("********************************************************************");
		ispisiRaspored(raspored);
		System.out.println("\n\n\n");
		System.out.println("********************************************************************");
		System.out.println("|               Identifikacija Kolizija rasporeda                  |");
		System.out.println("********************************************************************");
		odrediKolizije(raspored);
	}
}
