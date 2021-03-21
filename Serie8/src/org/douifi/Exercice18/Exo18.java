package org.douifi.Exercice18;

import org.douifi.Exercice16.Person;
import org.douifi.Exercice17.PersonInputStream;
import org.douifi.Exercice17.PersonOutputStream;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Exo18 {

	public static void main(String[] args) {


		List<Person> persons = Arrays.asList(
				 new Person("Rikardo","Kaka",41),
				 new Person("Lio","Messi",31),
				 new Person("Thom","Hanks",51),
				 new Person("Harry","Jakson",61),
				 new Person("Mo","Sun",24));
        // Q.a  We need to <serialize> objects
		
       // Q.b    we have to implment Serializable Interface into Person class
       
        String fileName = "files/E18Persons.bin";

        try (PersonOutputStream personOutputStream1 = new PersonOutputStream(new FileOutputStream(fileName))) {
            personOutputStream1.writePeople(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }


       try (PersonInputStream personInputStream1 = new PersonInputStream(new FileInputStream(fileName))) {
            List<Person> people = personInputStream1.readPeople();
            System.out.println("Print the people list:");
            people.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
}
