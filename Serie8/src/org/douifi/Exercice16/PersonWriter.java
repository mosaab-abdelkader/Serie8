package org.douifi.Exercice16;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.function.Function;

public class PersonWriter {
	Function <Person, String> strFromPerson= (Person p) -> {
		StringBuilder str= new StringBuilder();
		str.append(p.getFirstName()+", ");
		str.append(p.getLastName()+", ");
		str.append(p.getAge()+"\n");
		return str.toString();
	};
	
	
	public void write (List <Person> people, String fileName) {
		File file=new File(fileName);
		try(Writer writer =new FileWriter(file,true);
			BufferedWriter bufferedwriter=new BufferedWriter(writer))
				{
			for(Person p:people) {
				bufferedwriter.write(strFromPerson.apply(p));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
}
}