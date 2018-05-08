
package parser;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
 
 
public class CalendrierFoot {
 
 
 
	private static Document lireDocument(String url) {
 
 
		try {
			Document doc = Jsoup.connect(url).get();
			return doc;
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return null;
	}
	public static String html2text(String toto) {
	    return Jsoup.parse(toto).text();
	    
	}
 
	
 
	/**
         * @param args
         */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	/*	System.out.println("Veuillez saisir ce que vous voulez chercher :");
		Scanner sc = new Scanner(System.in);
        String test = sc.nextLine();
		
		*/
		
	Document doc = lireDocument("http://www.footmercato.net/programme-tv");
	
		String title = doc.title(); 
		System.out.println(title +" "+"Pour les 3 prochains jours"+"\n");
		int tmpIndiceDate = 0;
		int HeureActuel=-1;
		int HeureStocke=0;
		for(int i=0;i<50;i++){
		System.out.println(" ");
    	String toto=doc.getElementsByClass("programTv-team txtright txtover").get(i).html().toString();
    	String titi=doc.getElementsByClass("programTv-team txtleft txtover").get(i).html().toString();
    	String tata=doc.getElementsByClass("programTv-hour txtcenter").get(i).html().toString();
     	
    	
     	if(HeureStocke==0)
    		HeureStocke=HeureActuel;
     	HeureActuel = Integer.parseInt(tata.substring(0,2));
     	if(HeureActuel<HeureStocke)
     		tmpIndiceDate++;
     	
     	HeureStocke=HeureActuel;
     	
     	String tutu=doc.getElementsByTag("caption").get(tmpIndiceDate).html().toString();
    	System.out.println(tutu);
    	System.out.print(tata+"   ");
    	System.out.print(toto+"   ");
    	System.out.print(titi+"   "+"\n");
    	
    	
    }
}
	
}
	

 
		

 
	