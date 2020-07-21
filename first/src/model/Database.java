package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList<Person> people;

    public Database() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
}
