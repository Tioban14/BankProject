package jmp.dto;

import java.time.LocalDate;

/**
 * @author Esteban_Lopez1
 */
public class User{
    private String name;
    private String surName;
    private LocalDate birthDay;

    public User(String name, String surName, LocalDate birthDay){
        this.name = name;
        this.surName = surName;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        return "USER=> " +
                "Name: " + name + "\t|" +
                " Surname:  " + surName + "\t|" +
                " BirthDay:" + birthDay;
    }
}