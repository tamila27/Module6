package com.goit.gojavaonline.module3_3;

public class MusicalInstrumentFactory {
    public static MusicalInstrument getRandomMusicalInstrument(){
        MusicalInstrument musicalInstrument = new Guitar();

        if(MusicalInstruments.values()!=null && MusicalInstruments.values().length > 0){
            int musicalInstrumentsOrdinal = (int)(Math.random()*MusicalInstruments.values().length);
            MusicalInstruments musicalInstruments = MusicalInstruments.values()[musicalInstrumentsOrdinal];
            switch (musicalInstruments){
                case GUITAR:
                    musicalInstrument = new Guitar();
                    break;
                case PIANO:
                    musicalInstrument = new Piano();
                    break;
                case TRUMPET:
                    musicalInstrument = new Trumpet();
                    break;
            }
        }

        return musicalInstrument;
    }
}
