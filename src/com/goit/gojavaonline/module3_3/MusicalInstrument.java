package com.goit.gojavaonline.module3_3;

public abstract class MusicalInstrument {
    private String id;
    private float price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public abstract MusicalInstruments getMusicalInstrumentName();
}
