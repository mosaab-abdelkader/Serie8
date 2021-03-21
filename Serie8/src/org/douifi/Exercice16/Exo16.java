package org.douifi.Exercice16;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Exo16 {


	public static void main(String[] args) {

		// Serialization
		
		

		List<Person> persons = Arrays.asList(
				 new Person("Rikardo","Kaka",41),
				 new Person("Lio","Messi",31),
				 new Person("Michel","Jakson",41),
				 new Person("Michel","Amande",41),
				 new Person("Michel","Zidane",41),
				 new Person("Thom","Hanks",51),
				 new Person("Harry","Jakson",61),
				 new Person("Mo","Sun",24));
		
		PersonReader pr= new PersonReader();
		PersonWriter pr1= new PersonWriter();

		System.out.println("\nQ1   \n ficher .txt crée ");
		//Person deja crée et fichier Equipe.txt dans files 
		System.out.println("\nQ2 \nTest de la Focntion crée:"); 
		Function <String, Person> personfromstring = (String s) -> {
			Person p = new Person();
			String sprtr= ", ";
			String[] words = s.split(sprtr);
			p.setLastName(words[0]);
			p.setFirstName(words[1]);
			p.setAge(Integer.parseInt(words[2]));
			return p;
		};
		
		

		String s=" Ryad, Mahrez, 23";
		Person p1 =personfromstring.apply(s);
		System.out.println(" Person  created from String s :"+p1);
		System.out.println("\nQ3 \nList of Persons returned from file:\n");
		System.out.println(pr.read("files/Equipe.txt"));
		System.out.println("\nQ4 Q5 \nClass PersonWrite created \nFor test check file1.txt \n");
		pr1.write(persons,"files/file1.txt");

		
	}

}
