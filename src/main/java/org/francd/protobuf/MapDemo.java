package org.francd.protobuf;

import org.francd.model.common.BodyStyle;
import org.francd.model.common.Car;
import org.francd.model.Dealer;

public class MapDemo {

    public static void main(String[] args) {

        Car car = Car.newBuilder()
                .setMaker("Susuki")
                .setModel("Mokon")
                .setYear(2002)
                .setBodyStyle(BodyStyle.COUPE)
                .build();

        Car car2 = Car.newBuilder()
                .setMaker("BMB")
                .setModel("1m23")
                .setYear(2012)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(2002, car)
                .putModel(2012, car2)
                .build();

        System.out.println(dealer.getModelOrThrow(2002));
        System.out.println(dealer.getModelOrDefault(2002, car));
        System.out.println(dealer.getModelOrThrow(2002).getBodyStyle());
    }
}

