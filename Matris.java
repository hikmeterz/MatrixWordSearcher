import java.util.*;		
public class Matris{

	private static char[][] matris;
	private static String kelime;
	private static int sonRow;
	private static int sonColumn;

	public static void main(String[] args){

		matrisOlustur();

	}

	public static void matrisOlustur(){

		boolean cikis=true;
		Scanner k = new Scanner(System.in);
		System.out.println("Matris boyutunu giriniz: ");
		String boyut= k.nextLine();//Odevde x oldugu icin String olarak aldım.

		String row= boyut.substring(0,boyut.indexOf('x'));// X e kadar alıyor xten sonrasını almıyor. Yani row u alıyor.
		row=row.replaceAll(" ","");
		int row1=  stringToInteger(row);			

		String column= boyut.substring(boyut.indexOf('x')+1); //Xten sonrasını alıyor yani columnu alıyor.
		column=column.replaceAll(" ","");
		int column1=  stringToInteger(column);

		matris = new char[row1][column1]; // Matris olsutu.
		System.out.println("Matrisi giriniz: ");
		String s="";
		for(int i=0;i<row1;i++){
			s=k.nextLine();
			s= s.replaceAll(" ","");
			for(int j=0;j<s.length();j++){
				matris[i][j]=s.charAt(j);
			
			}				

		}
		while(cikis==true){

			System.out.print("Aranacak kelime : " );
			kelime=k.next();
			if(kelime.equalsIgnoreCase("cik")||kelime.equalsIgnoreCase("çık")){
				cikis=false;
				System.out.println("Program sonlandı.");
				System.exit(0);
			}

			System.out.println(kelimeyiMatristeBul(kelime));

		}
	

	}



	private static String kelimeyiMatristeBul(String s){

	
		String str = s;
		String yazdir="";
		int baslangicRow=0;
		int baslangicColumn=0;

		//jokersiz+
		for(int i=0;i<matris.length;i++){
			for(int j=0;j<matris[i].length;j++){
				if(s.charAt(0)==matris[i][j]){
					baslangicRow=i;
					baslangicColumn=j;
					if(kelimeKarsilastir1(baslangicRow,baslangicColumn,s)||kelimeKarsilastir2(baslangicRow,baslangicColumn,s)||
					   kelimeKarsilastir3(baslangicRow,baslangicColumn,s)||kelimeKarsilastir4(baslangicRow,baslangicColumn,s)||
					   kelimeKarsilastir5(baslangicRow,baslangicColumn,s)||kelimeKarsilastir6(baslangicRow,baslangicColumn,s)||
					   kelimeKarsilastir7(baslangicRow,baslangicColumn,s)||kelimeKarsilastir8(baslangicRow,baslangicColumn,s) ){
						return yazdir= kelime + ":" + "(" + baslangicRow + "," + baslangicColumn + ")" + " (" + sonRow + "," + sonColumn + ")";
					
					}
					
				}
								
			}
		}
		//tek jokerli +
		for(int i=0;i<matris.length;i++){//+
			for(int j=0;j<matris[i].length;j++){
				if(s.charAt(0)==matris[i][j]){
					baslangicRow=i;
					baslangicColumn=j;
					if(kelimeJokerliMi1(baslangicRow,baslangicColumn,s)||kelimeJokerliMi2(baslangicRow,baslangicColumn,s)||
					  	 kelimeJokerliMi3(baslangicRow,baslangicColumn,s)||kelimeJokerliMi4(baslangicRow,baslangicColumn,s)||
					  	 kelimeJokerliMi5(baslangicRow,baslangicColumn,s)||kelimeJokerliMi6(baslangicRow,baslangicColumn,s)||
					  	 kelimeJokerliMi7(baslangicRow,baslangicColumn,s)||kelimeJokerliMi8(baslangicRow,baslangicColumn,s) ){
						 return yazdir=kelime + ":" + "(" + baslangicRow + "," + baslangicColumn + ")" + " (" + sonRow + "," + sonColumn + ")";
						 	
					}
				
				}
							
			}
		}
	
		//ilk harf joker ve tek joker
	
		s = str.substring(1);//+
		for(int i=0;i<matris.length;i++){
			for(int j=0;j<matris[i].length;j++){
				if(s.charAt(0)==matris[i][j]){
					baslangicRow=i;
					baslangicColumn=j;
					if(kelimeKarsilastir1(baslangicRow,baslangicColumn,s)||kelimeKarsilastir2(baslangicRow,baslangicColumn,s)||
					   kelimeKarsilastir3(baslangicRow,baslangicColumn,s)||kelimeKarsilastir4(baslangicRow,baslangicColumn,s)||
					   kelimeKarsilastir5(baslangicRow,baslangicColumn,s)||kelimeKarsilastir6(baslangicRow,baslangicColumn,s)||
					   kelimeKarsilastir7(baslangicRow,baslangicColumn,s)||kelimeKarsilastir8(baslangicRow,baslangicColumn,s) ){
					
						if(sonColumn  > baslangicColumn){// saga dogru gitmistir.3 yone gidebilir.
							if(baslangicRow==sonRow){// saga yan
								 baslangicColumn--;
							}else if (baslangicRow>sonRow){//sag capraz yukarı +
								baslangicRow++;
								baslangicColumn--;
							}else if(baslangicRow<sonRow){// sag capraz asagı+
								baslangicRow--;
								baslangicColumn--;
							}
						}else if(sonColumn < baslangicColumn){//sola dogru gitmistir.
							if(baslangicRow==sonRow){//sol yana gitmistir.+
								baslangicColumn++;	
							}else if(baslangicRow>sonRow){//sol capraz yukarı gitmisir.+
								baslangicRow++;
								baslangicColumn++;
							}else if(baslangicRow<sonRow) {//sol capraz asagı+
								baslangicRow--;
								baslangicColumn++;
							}
						}else if(sonColumn==baslangicColumn){//Asagı duz veya yukarı duz gitmistir.
							if(baslangicRow>sonRow) {//Yukarı dogru gitmistir.
								baslangicRow++;
							}else if(baslangicRow<sonRow)//Asagı gitmistir.
								baslangicRow--;
						}
						
						return yazdir= '?' + kelime + ":" + "(" + baslangicRow + "," + baslangicColumn + ")" + " (" + sonRow + "," + sonColumn + ")"; 

					}
				}

					
			}

		}
	

		//çift joker
	
		s = str;//+
		for(int i=0;i<matris.length;i++){
			for(int j=0;j<matris[i].length;j++){
				if(s.charAt(0)==matris[i][j]){
					baslangicRow=i;
					baslangicColumn=j;
					if(kelimeJokerliMi21(baslangicRow,baslangicColumn,s)||kelimeJokerliMi22(baslangicRow,baslangicColumn,s)||
					   kelimeJokerliMi23(baslangicRow,baslangicColumn,s)||kelimeJokerliMi24(baslangicRow,baslangicColumn,s)||
					   kelimeJokerliMi25(baslangicRow,baslangicColumn,s)||kelimeJokerliMi26(baslangicRow,baslangicColumn,s)||
					   kelimeJokerliMi27(baslangicRow,baslangicColumn,s)||kelimeJokerliMi28(baslangicRow,baslangicColumn,s) ){
					   return yazdir=kelime + ":" + "(" + baslangicRow + "," + baslangicColumn + ")" + " (" + sonRow + "," + sonColumn + ")";
				
					}
				
				}
							
			}
		}


		//ilk harf joker ve çift joker
	
		s = str.substring(1);//+
		for(int i=0;i<matris.length;i++){
			for(int j=0;j<matris[i].length;j++){
				if(s.charAt(0)==matris[i][j]){
					baslangicRow=i;
					baslangicColumn=j;
					if(kelimeJokerliMi1(baslangicRow,baslangicColumn,s)||kelimeJokerliMi2(baslangicRow,baslangicColumn,s)||
					  	 kelimeJokerliMi3(baslangicRow,baslangicColumn,s)||kelimeJokerliMi4(baslangicRow,baslangicColumn,s)||
					  	 kelimeJokerliMi5(baslangicRow,baslangicColumn,s)||kelimeJokerliMi6(baslangicRow,baslangicColumn,s)||
					  	 kelimeJokerliMi7(baslangicRow,baslangicColumn,s)||kelimeJokerliMi8(baslangicRow,baslangicColumn,s) ){
					
						if(sonColumn > baslangicColumn){// saga dogru gitmistir.3 yone gidebilir.
							if(baslangicRow==sonRow){// saga yan
								 baslangicColumn--;
							}else if (baslangicRow>sonRow){//sag capraz yukarı 
								baslangicRow++;
								baslangicColumn--;
							}else if(baslangicRow<sonRow){// sag capraz asagı
								baslangicRow--;
								baslangicColumn--;
							}
						}else if(sonColumn < baslangicColumn){//sola dogru gitmistir.
							if(baslangicRow==sonRow){//sol yana gitmistir.
								baslangicColumn++;	
							}else if(baslangicRow>sonRow){//sol capraz yukarı gitmisir.
								baslangicRow++;
								baslangicColumn++;
							}else if(baslangicRow<sonRow) {//sol capraz asagı
								baslangicRow--;
								baslangicColumn++;
							}
						}else if(sonColumn==baslangicColumn){//Asagı duz veya yukarı duz gitmistir.
							if(baslangicRow>sonRow) {//Yukarı dogru gitmistir.
								baslangicRow++;
							}else if(baslangicRow<sonRow)//Asagı gitmistir.
								baslangicRow--;
						}
						 return yazdir= '?' + kelime + ":" + "(" + baslangicRow + "," + baslangicColumn + ")" + " (" + sonRow + "," + sonColumn + ")";
						 
					}
				
				}
							
			}
		}
	
		//ilk iki harf joker
	
		s = str.substring(2);
		for(int i=0;i<matris.length;i++){
			for(int j=0;j<matris[i].length;j++){
				if(s.charAt(0)==matris[i][j]){
					baslangicRow=i;
					baslangicColumn=j;
					if(kelimeKarsilastir1(baslangicRow,baslangicColumn,s)||kelimeKarsilastir2(baslangicRow,baslangicColumn,s)||
					   kelimeKarsilastir3(baslangicRow,baslangicColumn,s)||kelimeKarsilastir4(baslangicRow,baslangicColumn,s)||
					   kelimeKarsilastir5(baslangicRow,baslangicColumn,s)||kelimeKarsilastir6(baslangicRow,baslangicColumn,s)||
					   kelimeKarsilastir7(baslangicRow,baslangicColumn,s)||kelimeKarsilastir8(baslangicRow,baslangicColumn,s) ){
						if(sonColumn  > baslangicColumn){// saga dogru gitmistir.3 yone gidebilir.
							if(baslangicRow==sonRow){// saga yan
								 baslangicColumn-=2;
							}else if (baslangicRow>sonRow){//sag capraz yukarı 
								baslangicRow+=2;
								baslangicColumn-=2;
							}else if(baslangicRow<sonRow){// sag capraz asagı
								baslangicRow-=2;
								baslangicColumn-=2;
							}
						}else if(sonColumn < baslangicColumn){//sola dogru gitmistir.
							if(baslangicRow==sonRow){//sol yana gitmistir.
								baslangicColumn++;	
							}else if(baslangicRow>sonRow){//sol capraz yukarı gitmisir.
								baslangicRow+=2;
								baslangicColumn+=2;
							}else if(baslangicRow<sonRow) {//sol capraz asagı
								baslangicRow-=2;
								baslangicColumn+=2;
							}
						}else if(sonColumn==baslangicColumn){//Asagı duz veya yukarı duz gitmistir.
							if(baslangicRow>sonRow) {//Yukarı dogru gitmistir.
								baslangicRow+=2;
							}else if(baslangicRow<sonRow)//Asagı gitmistir.
								baslangicRow=-2;
						}
						return yazdir= '?'+  "" + '?' + kelime + ":" + "(" + baslangicRow + "," + baslangicColumn + ")" + " (" + sonRow + "," + sonColumn + ")"; 
					
					}
				}

							
			}

		}

		return yazdir = "Kelime Bulunamadı.";
	}

				
	private static boolean kelimeKarsilastir1(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int row=0;
		int column=0;

		for(sayac=1;sayac<s2.length();sayac++){
			y++;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					return false;
				}

			}else{
				return false;
			
			}

		}

		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;

	}
	private static boolean kelimeKarsilastir2(int a,int b,String s1){//Row sabit column azalıyor.
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			y--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					return false;
				}


			}else{
				return false;
			
			}

		}

		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		}

		return kelimeBulundu;

	}
	private static boolean kelimeKarsilastir3(int a,int b,String s1){//Row artıyor column sabit.
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x++;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu= true;
					continue;		
				}else{
					return false;
				}


			}else{
				return false;
			
			}

		}

		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		}

		return kelimeBulundu;

	}
	private static boolean kelimeKarsilastir4(int a,int b,String s1){//Row azalıyor column sabit.
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int row=sonRow;
		int column=sonColumn;
		for(sayac=1;sayac<s2.length();sayac++){
			x--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					return false;
				}


			}else{
				return false;
			
			}

		}

		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		}

		return kelimeBulundu;

	}
	private static boolean kelimeKarsilastir5(int a,int b,String s1){//Row azalıyor column azalıyor.
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x--;
			y--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					return false;
				}


			}else{
				return false;
			
			}

		}

		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		}

		return kelimeBulundu;

	}
	private static boolean kelimeKarsilastir6(int a,int b,String s1){//Row azalıyor column artıyor.
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x--;
			y++;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					return false;
				}


			}else{
				return false;
			
			}

		}

		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		}

		return kelimeBulundu;

	}
	private static boolean kelimeKarsilastir7(int a,int b,String s1){//Row artıyor column artıyor.
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x++;
			y++;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					return false;
				}


			}else{
				return false;
			
			}

		}

		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		}

		return kelimeBulundu;

	}
	private static boolean kelimeKarsilastir8(int a,int b,String s1){//Row artıyor column azalıyor.
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x++;
			y--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					return false;
				}


			}else{
				return false;
			
			}

		}

		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		}

		return kelimeBulundu;

	}
	//1 jokerli.
	private static boolean kelimeJokerliMi1(int a,int b,String s1){//Jokerli saga dogru.
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			y++;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>1){
						return false;
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;


	}

	private static boolean kelimeJokerliMi2(int a,int b,String s1){//Jokerli sola dogru.
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			y--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>1){
						return false;
		
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;

			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;


	}
	private static boolean kelimeJokerliMi3(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x++;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>1){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
		
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;


	}
	private static boolean kelimeJokerliMi4(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu= true;
					continue;		
				}else{
					joker++;
					if(joker>1){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;


	}
	private static boolean kelimeJokerliMi5(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			y--;
			x--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>1){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;


	}
	private static boolean kelimeJokerliMi6(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			y++;
			x--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>1){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;


	}
	private static boolean kelimeJokerliMi7(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			y++;
			x++;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>1){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;


	}
	private static boolean kelimeJokerliMi8(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x++;
			y--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>1){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;

	}
	// iki jokerli.
	private static boolean kelimeJokerliMi21(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){			
			y++;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>2){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;
	}
	private static boolean kelimeJokerliMi22(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			y--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>2){
						return false;
				
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
	
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;
	}
	private static boolean kelimeJokerliMi23(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x++;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>2){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;
	}
	private static boolean kelimeJokerliMi24(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>2){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;
	}
	private static boolean kelimeJokerliMi25(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x--;
			y--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>2){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
		
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;
	}
	private static boolean kelimeJokerliMi26(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			y++;
			x--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>2){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
	
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;
	}
	private static boolean kelimeJokerliMi27(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x++;
			y++;		
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>2){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;
	}
	private static boolean kelimeJokerliMi28(int a,int b,String s1){
		String s2=s1;
		boolean kelimeBulundu=false;
		int x=a;//row
		int y=b;//column
		int sayac=0;
		int joker=0;
		int row=0;
		int column=0;
		for(sayac=1;sayac<s2.length();sayac++){
			x++;
			y--;			
			if(uygunMu(x,y)){
				if(s2.charAt(sayac)==matris[x][y]){
					row=x;
					column=y;
					kelimeBulundu=true;
					continue;		
				}else{
					joker++;
					if(joker>2){
						return false;
					
					}else{
						kelimeBulundu=true;
						row=x;
						column=y;
						s2 = s2.substring(0,sayac)+'?'+ s2.substring(sayac+1);	
					}

				}

			}else{
				return false;
			
			}

		}
		if(kelimeBulundu==true){
			sonRow=row;
			sonColumn=column;
			kelime=s2;
		
		}

		return kelimeBulundu;
	}

	private  static boolean uygunMu(int row,int column){ // is in bounds of the matrix?

		boolean uygun=false;

		if(row>=0 && row<matris.length && column>=0 && column<matris[row].length)
			uygun=true;

		return uygun;

	}
	private static int stringToInteger(String s){//Stringi integera ceviren metod.
	
		int sonuc = 0, carpim = 1;
		for (int i = s.length()-1; i >= 0; i--) {
			 	sonuc += (s.charAt(i) - '0') * carpim;
				carpim *= 10;
		 }			
		 return sonuc;
	}


}
