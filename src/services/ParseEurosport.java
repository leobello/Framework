package services;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ParseEurosport {
	
	static public void get() {
		String url = "http://www.eurosport.fr";
		Document document;
		
		try {
			document = Jsoup.connect(url).get();
			Elements element = document.getElementsByClass("ajax-container with-calendar");
			Element el = element.first();
			int nb = el.childNodeSize();
			
			for(int i=0;i<nb;i++) {
				Element e = ((Element)  el.childNode(i));
				int nb1= e.childNodeSize();
				for(int j=0;j<nb1;j++){
					int nb2= e.childNode(j).childNodeSize();
					for(int k=0; k<nb2; k++) {
						int nb3 =e.childNode(j).childNode(k).childNodeSize();
						for(int m=1;m<nb3;m++){		
							int nb4= e.childNode(j).childNode(k).childNode(m).childNodeSize();						
							for(int n=1; n<nb4; n++) {
								String aff = ((Element) e.childNode(j).childNode(k).childNode(m).childNode(n-1)).text();
							 	System.out.println(aff);
								System.out.println("\n");
							 }			
						}
					}	
				}
			}		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}	
}