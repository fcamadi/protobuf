package org.francd.protobuf;

import org.francd.model.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {

        Person person = Person.newBuilder().build();

        System.out.println("City: "+person.getAddress().getCity()); // prints "City: " <- no NPE!

        System.out.println("City/Address exist?: "+person.hasAddress());  // prints false
        //There is a "hasAddress" method because Address is an user defined type
        //For age, name .. no, because these are Proto defined types
    }
}
