package storage;

import Gui.models.Person;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Person> personArrayList = new ArrayList<>();

    public static void addPerson(Person person){
        personArrayList.add(person);
    }

    public static ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }
}
