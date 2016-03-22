package com.goit.gojavaonline.module4;

public class ShapeAreaCalculator {

    public static double calculateTriangleArea(double aSide, double bSide, double cSide){
        if(aSide < 0 || bSide < 0 || cSide < 0){
            throw new IllegalArgumentException("Triangle side must be > 0.");
        }
        double perimeter = (aSide + bSide + cSide)/2;
        return Math.sqrt(perimeter*(perimeter - aSide)*(perimeter - bSide)*(perimeter - cSide));
    }

    public static double calculateRectangleArea(double aSide, double bSide){
        if(aSide < 0 || bSide < 0 ){
            throw new IllegalArgumentException("Rectangle side must be > 0.");
        }
        return aSide * bSide;
    }
    public static double calculateCircleArea(double radius){
        if(radius < 0){
            throw new IllegalArgumentException("Circle radius must be > 0.");
        }
        return Math.PI * radius * radius;
    }
}
