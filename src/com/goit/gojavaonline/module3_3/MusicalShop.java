package com.goit.gojavaonline.module3_3;

import java.util.*;

public class MusicalShop {
    private List<MusicalInstrument> musicalInstruments;
    private Map<MusicalInstruments, Integer> musicalInstrumentCounter;

    public List<MusicalInstrument> getMusicalInstruments() {
        if(musicalInstruments == null){
            musicalInstruments = new ArrayList<>();
        }
        return musicalInstruments;
    }

    public void setMusicalInstruments(List<MusicalInstrument> musicalInstruments) {
        this.musicalInstruments = musicalInstruments;
    }

    public Map<MusicalInstruments, Integer> getMusicalInstrumentCounter() {
        if(musicalInstrumentCounter == null){
            musicalInstrumentCounter = new HashMap<>();
        }
        return musicalInstrumentCounter;
    }

    public void setMusicalInstrumentCounter(Map<MusicalInstruments, Integer> musicalInstrumentCounter) {
        this.musicalInstrumentCounter = musicalInstrumentCounter;
    }

    public void receiveMusicalInstrument(MusicalInstrument musicalInstrument){
        if ( musicalInstrument != null ){
            Integer count = getMusicalInstrumentCounter().get(musicalInstrument.getMusicalInstrumentName());
            if(count == null){
                count = 1;
            }
            else{
                count++;
            }
            getMusicalInstrumentCounter().put(musicalInstrument.getMusicalInstrumentName(), count);
            musicalInstrument.setId(musicalInstrument.getMusicalInstrumentName().toString() + count);
            getMusicalInstruments().add(musicalInstrument);

            System.out.println(musicalInstrument.getMusicalInstrumentName() + " was successfully received.");
        }
    }

    public void sellMusicalInstrument(MusicalInstrument musicalInstrument){
        if(musicalInstrument != null){
            if(getMusicalInstruments().contains(musicalInstrument)) {
                getMusicalInstruments().remove(musicalInstrument);
                Integer count = getMusicalInstrumentCounter().get(musicalInstrument.getMusicalInstrumentName());
                if(count > 0)
                    getMusicalInstrumentCounter().put(musicalInstrument.getMusicalInstrumentName(), count - 1);
                System.out.println(musicalInstrument.getMusicalInstrumentName()+ " id == " +musicalInstrument.getId() + " was successfuly sold.");
            }
        }
    }

    public MusicalInstrument getMusicalInstrumentByIndex(int musicalInstrumentIndex){
        MusicalInstrument musicalInstrument;
        if(musicalInstrumentIndex < 0 || musicalInstrumentIndex >= getMusicalInstruments().size() || getMusicalInstruments().size() == 0 ){
            musicalInstrument = null;
        } else {
            musicalInstrument = getMusicalInstruments().get(musicalInstrumentIndex);
        }
        return musicalInstrument;
    }

    @Override
    public String toString(){
        String listOfMusicalInstruments = "\nMusical shop contains musical instruments: \n";
        if(getMusicalInstruments().size() > 0){
            /*for(MusicalInstrument musicalInstrument : getMusicalInstruments()){
                listOfMusicalInstruments += musicalInstrument.getMusicalInstrumentName()+"\n";
            }*/
            for(MusicalInstruments key: getMusicalInstrumentCounter().keySet()){
                Integer count = getMusicalInstrumentCounter().get(key);
                if(count == null){
                    count = 0;
                }
                listOfMusicalInstruments += key.toString()+ " : " + count + "\n";
            }
        }
        return listOfMusicalInstruments;
    }

    public List<MusicalInstrument> prepareInstruments(Map<String, Integer> order) throws IllegalMusicalInstrumentException {
        List<MusicalInstrument> preparedInstruments= new ArrayList<>();
        for(String key : order.keySet()){
            MusicalInstruments musicalInstrumentName = MusicalInstruments.isSupportedInstrument(key);
            if( musicalInstrumentName == null ){
                throw new IllegalMusicalInstrumentException("Musical shop has no "+key+" instrument");
            }
            Integer count = order.get(musicalInstrumentName.toString());
            if( getMusicalInstrumentCounter().get(musicalInstrumentName) != null && count <= getMusicalInstrumentCounter().get(musicalInstrumentName)){
                if(count > 0){
                    for(MusicalInstrument musicalInstrument : getMusicalInstruments()){
                        if(musicalInstrument.getMusicalInstrumentName() == musicalInstrumentName ){
                            preparedInstruments.add(musicalInstrument);
                            count--;
                            if(count <= 0){
                                break;

                            }
                        }
                    }
                }

            } else {
                throw new IllegalStateException("Amount of musical instrument "+ musicalInstrumentName + " in the order should not exceed their amount in the store.");
            }
        }
        return preparedInstruments;
    }

    public void sellMusicalInstruments(List<MusicalInstrument> preparedInstruments){
        for(MusicalInstrument mI: preparedInstruments){
            sellMusicalInstrument(mI);
        }
    }
}
