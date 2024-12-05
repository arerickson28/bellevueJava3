package com.example.scratch;


public class Enums {

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Charlie", 25);

        comparePeople(person1, person2);
        comparePeople(person3, person1);
        comparePeople(person2, person3);
    }

    public static void comparePeople(Person person1, Person person2) {
        System.out.println("---\nIs " + person1.name + " older than " + person2.name + "?");
        if (person1.compareTo(person2) > 0) {
            System.out.println("Yes, " + person1.name + " is older");
        } else if (person1.compareTo(person2) < 0) {
            System.out.println("No, " + person2.name + " is older");
        } else {
            System.out.println("Um, actually " + person1.name + " and " + person2.name + " are the same age");
        }
    }

    static class Person implements Comparable<Person> {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person other) {
            // Compare based on age
            return Integer.compare(this.age, other.age);
        }
    }

}


//        SpeedSetting currentSpeed = SpeedSetting.FAST;
//        System.out.println("The current speed is " + currentSpeed + " which is number " + currentSpeed.setting + " on the dial!");

//    enum SpeedSetting {
//        STOPPED(0),
//        SLOW(1),
//        MEDIUM(2),
//        FAST(3);
//
//        //    Enum attribute
//        public final int setting;
//
//        //    Constructor to tie a value to the enum constants' attribute
//        SpeedSetting(int setting) {
//            this.setting = setting;
//        }
//    }





