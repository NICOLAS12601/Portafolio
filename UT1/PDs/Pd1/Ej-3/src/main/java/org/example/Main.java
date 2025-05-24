package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static double multSuma(double a,double b,double c){
        double result=0;
        result=a*b;
        result+=c;
        return result;
    }
    public static void main(String[] args) {
        double reultado = multSuma(1.0, 2.0, 3.0);
        System.out.println(reultado);
    }
}