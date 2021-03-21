package org.douifi.Exercice17;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.function.Function;

import org.douifi.Exercice16.Person;




public class PersonOutputStream extends FileOutputStream {

	private FileOutputStream fos;
	
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

    public PersonOutputStream(FileOutputStream fos) {
        super(FileDescriptor.in);
        this.fos = fos;
    }

    public void writeFields(List<Person> people) {

        int size = people.size();

        try (FileOutputStream fos = this.fos;
             DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeInt(size); // write the size first
            for (Person person : people) {
                dos.write(personToBytes.apply(person));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("[OK] File written successfully");
    }

    public  void writePeople(List<Person> people) {

        try (OutputStream os = this.fos;
             ObjectOutputStream oos = new ObjectOutputStream(os)) {

            oos.writeObject(people);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("[OK] File written successfully");
    }
	
}


