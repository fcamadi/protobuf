package org.francd.protobuf;

import org.francd.model.common.Address;
import org.francd.model.common.Car;
import org.francd.model.Person;

import java.util.List;

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

        Car car2 = Car.newBuilder()
                .setMaker("BMB")
                .setModel("1m23")
                .setYear(2012)
                .build();

        Person menganito = Person.newBuilder()
                .setName("Menganito")
                .setAge(33)
                .setAddress(address)
                .addAllCar(List.of(car, car2))
                .build();

        System.out.println(menganito);
    }
}

