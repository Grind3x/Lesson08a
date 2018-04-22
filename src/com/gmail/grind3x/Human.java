package com.gmail.grind3x;

import java.io.Serializable;

public class Human implements Serializable {
    private String firstName;
    private String secondName;
    private int age;
    private boolean sex;

    public Human() {
    }

    public Human(String secondName, String firstName, int age, boolean sex) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.age = age;
        this.sex = sex;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "com.gmail.grind3x.Human{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
