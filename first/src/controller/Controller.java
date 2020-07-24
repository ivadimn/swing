package controller;

import model.*;
import ui.FormEvent;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {

    Database db = new Database();

    public void addPerson(FormEvent ev) {
        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCat = ev.getAgeCategory();
        String empCat = ev.getEmpCategory();
        String taxId = ev.getTaxId();
        boolean usCitizen = ev.isUsCitizen();
        String gender = ev.getGender();

        AgeCategory ageCategory = null;
        switch(ageCat) {
            case 0:
                ageCategory = AgeCategory.child;
                break;
            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.senior;
                break;
        }
        EmploymentCategory employmentCategory;
        if (empCat.equals("Employed")) {
            employmentCategory = EmploymentCategory.employed;
        }
        else if (empCat.equals("Self-employed")) {
            employmentCategory = EmploymentCategory.selfEmployed;
        }
        else if (empCat.equals("Unemployed")) {
            employmentCategory = EmploymentCategory.unemployed;
        }
        else {
            employmentCategory = EmploymentCategory.other;
        }

        Gender genderCat;
        if (gender.equals("male")) {
            genderCat = Gender.male;
        }
        else {
            genderCat = Gender.female;
        }
        Person person = new Person(name, occupation, ageCategory,
                employmentCategory, taxId, usCitizen, genderCat);

        db.addPerson(person);

    }
    public void removePerson(int index) {
        db.removePerson(index);
    }

    public List<Person> getPeople() {
        return db.getPeople();
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
