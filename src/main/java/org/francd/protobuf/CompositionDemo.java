package org.francd.protobuf;

import org.francd.model.Address;
import org.francd.model.Car;
import org.francd.model.Person;

public class CompositionDemo {

    public static void main(String[] args) {

        Address address = Address.newBuilder()
                .setZipcode(11222)
                .setStreet("Avda. Sr. Matanza")
                .setCity("Chao City")
                .build();

        Car car = Car.newBuilder()
                .setMaker("Susuki")
                .setModel("Mokon")
                .setYear(2002)
                .build();

        Person menganito = Person.newBuilder()
                .setName("Menganito")
                .setAge(33)
                .setAddress(address)
                .setCar(car)
                .build();

        System.out.println(menganito);
    }
}

