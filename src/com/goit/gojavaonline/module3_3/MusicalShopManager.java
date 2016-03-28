package com.goit.gojavaonline.module3_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicalShopManager {
    public static final int MUSICAL_INSTRUMENTS_COUNT = 20;

    public static void main(String[] args){
        MusicalShop musicalShop = new MusicalShop();
        int musicalInstrumentsSetCount = getMusicalInstrumentsCount(args);
        for(int i = 0; i < musicalInstrumentsSetCount; i++){
            musicalShop.receiveMusicalInstrument(MusicalInstrumentFactory.getRandomMusicalInstrument());
        }

        printMusicalShopsInstruments(musicalShop);

        Map<String, Integer> order = getRandomOrder(musicalShop);
        System.out.println("Order : " + order.toString());
        try {
            List<MusicalInstrument> preparedInstruments = musicalShop.prepareInstruments(order);
            System.out.println("Ordered instruments was prepared.");
            musicalShop.sellMusicalInstruments(preparedInstruments);
            System.out.println("Prepared instruments was sold.");
        }
        catch(IllegalMusicalInstrumentException e){
            System.err.println(e);
        }

        printMusicalShopsInstruments(musicalShop);

    }
    private static int getMusicalInstrumentsCount(String[] args){
        int musicalInstrumentsCount;
        if(args != null && args.length != 0){
            String musicalInstrumentsCountValue = args[0];
            try {
                musicalInstrumentsCount = Integer.parseInt(musicalInstrumentsCountValue);
                if(musicalInstrumentsCount <= 0){
                    System.out.println("Program argument should be positive integer value. Using default value "+ MUSICAL_INSTRUMENTS_COUNT);
                    musicalInstrumentsCount = MUSICAL_INSTRUMENTS_COUNT;
                }
            } catch (NumberFormatException e) {
                System.out.println("Specified program argument is not an integer value. Using default value "+ MUSICAL_INSTRUMENTS_COUNT);
                musicalInstrumentsCount = MUSICAL_INSTRUMENTS_COUNT;
            }
        } else {
            musicalInstrumentsCount = MUSICAL_INSTRUMENTS_COUNT;
        }
        return musicalInstrumentsCount;
    }

    private static void printMusicalShopsInstruments(MusicalShop musicalShop){
        if (musicalShop != null){
            System.out.println(musicalShop.toString());
        }
    }

    private static void sellRandomMusicalInstrumenntFromShop(MusicalShop musicalShop){
        MusicalInstrument musicalInstrument = musicalShop.getMusicalInstrumentByIndex(getRandomMusicalInstrumentsCount(musicalShop));

        if(musicalInstrument != null){
            musicalShop.sellMusicalInstrument(musicalInstrument);
        }
    }

    private static Map<String, Integer> getRandomOrder(MusicalShop musicalShop){
        Map<String, Integer> order = new HashMap<>();

        order.put(MusicalInstruments.GUITAR.toString(), getRandomMusicalInstrumentsCount(musicalShop));
        order.put(MusicalInstruments.TRUMPET.toString(), getRandomMusicalInstrumentsCount(musicalShop));
        order.put(MusicalInstruments.PIANO.toString(), getRandomMusicalInstrumentsCount(musicalShop));

        return order;
    }

    private static int getRandomMusicalInstrumentsCount(MusicalShop musicalShop){
        return (int)(Math.random()*musicalShop.getMusicalInstruments().size());
    }
}
