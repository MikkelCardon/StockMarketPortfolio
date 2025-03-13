package Gui.models;

public class Person {
    int person_id;
    String name;

    public Person(int person_id, String name) {
        this.person_id = person_id;
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
