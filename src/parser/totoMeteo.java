package parser;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

 
public class totoMeteo {
 
 
 
	private static Document lireDocument(String url) {
 
 
		try {
			Document doc = Jsoup.connect(url).get();
			return doc;
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return null;
	}
	public static String html2text(String e) {
	    return Jsoup.parse(e).text();
	    
	}
 
	
 
	/**
         * @param args
         */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	System.out.println("Veuillez saisir la ville que vous voulez chercher (Premiere lettre en Maj) :");
	

	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	String  NumVille = sc.nextLine();
	
        @SuppressWarnings("unused")
		String NomVille;
        switch (NumVille) {
            case "Grenoble": NomVille = "Grenoble";
            Document doc = lireDocument("http://www.meteoconsult.fr/meteo-france/ville/previsions-meteo-grenoble-2065-0.php");
        	
    		String title = doc.title();  
    		
        	System.out.println(title +"\n");
        	String e=doc.getElementsByClass("nom_jour").html().toString();
        	String ee=doc.getElementsByClass("tempe").html().toString();
          	String elem=Jsoup.parse(e).text();
          String eleme=Jsoup.parse(ee).text();
        	
      
    		System.out.println(elem);
    		System.out.println(eleme);
   
            
                     break;
            case "Lyon":  NomVille = "Lyon";
			 Document doc1 = lireDocument("http://www.meteoconsult.fr/meteo-france/ville/previsions-meteo-lyon-3090-0.php"); 
			 	String title1 = doc1.title();  
				
			 	System.out.println(title1 +"\n");

        	String e1=doc1.getElementsByClass("nom_jour").html().toString();
        	String ee1=doc1.getElementsByClass("tempe").html().toString();
          	String elem1=Jsoup.parse(e1).text();
          String eleme1=Jsoup.parse(ee1).text();
        	
      
    		System.out.println(elem1);
    		System.out.println(eleme1);
            
                     break;
            case "Paris":  NomVille = "Paris";
	            	Document doc2 = lireDocument("http://www.meteoconsult.fr/meteo-france/ville/previsions-meteo-paris-3903-0.php");
				  
				 String title2 = doc2.title();  
					
					System.out.println(title2 +"\n");
	        	String e2=doc2.getElementsByClass("nom_jour").html().toString();
	        	String ee2=doc2.getElementsByClass("tempe").html().toString();
	          	String elem2=Jsoup.parse(e2).text();
	          String eleme2=Jsoup.parse(ee2).text();
	        	
	      
	    		System.out.println(elem2);
	    		System.out.println(eleme2);
            
            
                     break;
            case "Lille":  NomVille = "Lille";
            Document doc3 = lireDocument("http://www.meteoconsult.fr/meteo-france/ville/previsions-meteo-lille-2948-0.php");
             
               		
            String title3 = doc3.title();  
			
			System.out.println(title3 +"\n");
                   	String e3=doc3.getElementsByClass("nom_jour").html().toString();
                   	String ee3=doc3.getElementsByClass("tempe").html().toString();
                     	String elem3=Jsoup.parse(e3).text();
                     String eleme3=Jsoup.parse(ee3).text();
                   	
                 
               		System.out.println(elem3);
               		System.out.println(eleme3);
                       
                     break;
            case "Marseille":  NomVille = "Lille";
            Document doc4 = lireDocument("http://www.meteoconsult.fr/meteo-france/hippodrome/previsions-meteo-marseille-266-0.php");
            
            String title4 = doc4.title();  
			System.out.println(title4 +"\n");
                   	String e4=doc4.getElementsByClass("nom_jour").html().toString();
                   	String ee4=doc4.getElementsByClass("tempe").html().toString();
                     	String elem4=Jsoup.parse(e4).text();
                     String eleme4=Jsoup.parse(ee4).text();
                   	
                 
               		System.out.println(elem4);
               		System.out.println(eleme4);
                       
                     break;
         
         
            default: NomVille = "Invalid city";
                     break;
        }
      
    }
}
 
	