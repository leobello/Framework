package parser;
import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
 
 
public class Sport {
 
 
 
	private static Document lireDocument(String url) {
 
 
		try {
			Document doc = Jsoup.connect(url).get();
			return doc;
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return null;
	}
 
 
 
	/**
         * @param args
         */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc = lireDocument("http://www.maxifoot.fr/football/article-35931.htm");
		String title = doc.title();  
    	System.out.println(title +"\n");
		System.out.println(doc.getElementsByClass("decla").html().toString());
		System.out.println(doc.select("item-publish-date").html().toString());	
		/* Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
         for (Element image : images) {

             System.out.println("\nsrc : " + image.attr("src"));

         }*/
     	

 
		}
 
 
	}