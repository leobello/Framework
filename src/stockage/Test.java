package stockage;

import java.io.FileNotFoundException;
import java.io.IOException;

import users.User;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		
		User T = new User("mouataz", 22);
		Serialization sz = new Serialization("test.txt",T);
		
		Deserialization dsz = new Deserialization("test.txt");
		System.out.println( ((User)dsz.ObjectLu()).getName());
		
		
	}

}
 