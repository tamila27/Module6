package com.goit.gojavaonline.module5;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args){
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert array elements count : ");
        int elementsCount = scanner.nextInt();
        if(elementsCount <= 0){
            throw new IllegalArgumentException("Array length must be > 0");
        }

        int[] array = ArrayFactory.getRandomIntArray(elementsCount);
        if(array != null){
            System.out.println("Array = " + Arrays.toString(array));
            System.out.println("min value = " + ArrayUtility.getMinInArray(array));
            System.out.println("max value = " + ArrayUtility.getMaxInArray(array));
            ArrayUtility.quickSort(array, 0, array.length-1);
            System.out.println("Sorted array = " + Arrays.toString(array));
        }
    }


}
