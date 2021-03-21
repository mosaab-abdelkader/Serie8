package org.douifi.Exercice16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonReader {

	Function <String, Person> personfromstring = (String s) -> {
		Person p = new Person();
		String sprtr= ", ";
		String[] words = s.split(sprtr);
		p.setLastName(words[0]);
		p.setFirstName(words[1]);
		p.setAge(Integer.parseInt(words[2]));
		return p;
	};
	

	public List<Person> read (String fileName) {
		File file= new File (fileName);
		List <Person> persons = new ArrayList <>();
		try(Reader reader=new FileReader(file);BufferedReader bufferedreader=new BufferedReader(reader);)
				{
			List <String> lines= bufferedreader.lines()
											   .filter(s -> s.startsWith("#")==false)
											   .collect(Collectors.toList());
			for (String str: lines) {
				persons.add(personfromstring.apply(str));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return persons;
	}



}
