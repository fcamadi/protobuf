package org.francd.protobuf;

import org.francd.model.Person;

public class PersonDemo {

    public static void main(String[] args) {

        Person fulanito = org.francd.model.Person.newBuilder()
                .setName("Fulanito")
                .setAge(33)
                .build();
        System.out.println(fulanito);

        Person menganito = org.francd.model.Person.newBuilder()
                .setName("Fulanito")
                .setAge(33)
                .build();
        System.out.println(fulanito.equals(menganito));
    }
}

