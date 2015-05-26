package by.zverugo.bsuir.ppvis.workerwithdate.model;


/**
 * Created by Alex on 23.05.2015.
 */
public class Human {

    private String surname;
    private String name;
    private String secondName;

    public Human(String surname, String name, String secondName) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + secondName;
    }

    public String getSurname() {

        return surname;
    }

    public String getName() {

        return name;
    }

    public String getSecondName() {

        return secondName;
    }
}
