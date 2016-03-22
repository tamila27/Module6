package com.goit.gojavaonline.module5;

public class ArrayFactory {
    public static int[] getRandomIntArray(int elementsCount){
        int[] array;
        if(elementsCount <= 0 ){
            array = null;
            System.err.println("Array length must be > 0.");
            throw new IllegalArgumentException("Array length must be > 0.");
        } else {
            array = new int[elementsCount];
            for (int i = 0; i < array.length; i++){
                array[i] = (int) Math.round(Math.random() * 100);
            }
        }
        return array;

    }
}
