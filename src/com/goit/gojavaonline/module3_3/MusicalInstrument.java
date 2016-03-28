package com.goit.gojavaonline.module3_3;

import com.goit.gojavaonline.Printable;

public abstract class MusicalInstrument implements Printable {
    private String id;
    private int price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String print(){
        return getMusicalInstrumentName().name();
    }

    public abstract MusicalInstruments getMusicalInstrumentName();
}
