package org.douifi.Exercice17;

import org.douifi.Exercice16.Person;
import java.io.*;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Exo17 {

	static Function<Person,byte[]> personToBytes = (person) -> {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(bos)) {

            dos.writeUTF(person.getLastName());
            dos.writeUTF(person.getFirstName());
            dos.writeInt(person.getAge());
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[0];
    };

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        // Q1
        Person p = new Person("Ryad","Mahrez",22);
        byte[] personBytes = personToBytes.apply(p);
        String fileName = "files/PersonBytes.bin";
        System.out.println("Print the written bytes:");
        System.out.println(MessageFormat.format("personBytes= {0}", personBytes));
        InputStream is = new ByteArrayInputStream(personBytes);
        DataInputStream dis = new DataInputStream(is);
        String firstName = dis.readUTF();
        String  lastName= dis.readUTF();
        int  age= dis.readInt();
        
        Person person=new Person(" Ryad"," Mahrez", 23);
    		Class<?> clss2 = Class.forName("org.douifi.Exercice16.Person");
    		Class<?> clss1 = person.getClass();
    		System.out.println("clss1 == clss2 " + (clss1 == clss2));

        
        System.out.println("Print the conversion of the bytes:");
        System.out.println(firstName+" "+lastName+" "+age);

        // create a List of Person to test the method writeFields from PersonOutputStream
       
        

		List<Person> people = Arrays.asList(
				 new Person("Rikardo","Kaka",41),
				 new Person("Lio","Messi",31),
				 new Person("Michel","Jakson",41),
				 new Person("Michel","Amande",41),
				 new Person("Michel","Zidane",41),
				 new Person("Thom","Hanks",51),
				 new Person("Harry","Jakson",61),
				 new Person("Mo","Sun",24));
        

        try (PersonOutputStream personOutput = new PersonOutputStream(new FileOutputStream(fileName))) {
            personOutput.writeFields(people);
        }


        try (PersonInputStream personInput = new PersonInputStream(new FileInputStream(fileName))) {
            List<Person> people1;
            people1 = personInput.readFields();
            people1.forEach(System.out::println);
        }

    }

}

