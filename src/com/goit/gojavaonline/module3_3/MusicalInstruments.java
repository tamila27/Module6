package com.goit.gojavaonline.module3_3;

public enum MusicalInstruments {
    GUITAR,
    PIANO,
    TRUMPET;

    public static MusicalInstruments isSupportedInstrument(String instrumentName){
        for(MusicalInstruments musicalInstrumentType: values()){
            if(musicalInstrumentType.name().equals(instrumentName)){
                return musicalInstrumentType;
            }
        }
        return null;
    }
}
