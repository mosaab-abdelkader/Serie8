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
        /* Comments: Serialization
        * Question 18.a
        * We need to <serialize> objects
        * it is about creating a portable representation of an object
        * a portable representation (i.e: XML, JSON, binary Representation)
        *
        *      ObjectOutputStream is used to write Java objects in binary files
        *
        * Question 18.b
        * We need to make the class Person serializable by implementing
        * Serializable Interface into Person class
        *       public class Person implements Serializable
        * Optional : We could add a serialVersionUID
         */
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
