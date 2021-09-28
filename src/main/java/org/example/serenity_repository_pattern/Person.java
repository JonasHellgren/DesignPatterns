package org.example.serenity_repository_pattern;

public class Person {
    public long id;
    public String name;
    public int age;
    public String livingCity;
    public String email;
    public String job;
    public Gender gender;
    public boolean isMarried;

    public Person() {
    }

    public Person(long id, String name, int age, String livingCity, String email, String job, Gender gender, boolean isMarried) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.livingCity = livingCity;
        this.email = email;
        this.job = job;
        this.gender = gender;
        this.isMarried = isMarried;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", livingCity='" + livingCity + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", gender=" + gender +
                ", isMarried=" + isMarried +
                '}';
    }
}