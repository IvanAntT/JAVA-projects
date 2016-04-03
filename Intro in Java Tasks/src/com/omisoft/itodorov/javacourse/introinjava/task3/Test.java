package com.omisoft.itodorov.javacourse.introinjava.task3;

/**
 * Created by johny on 08.09.15.
 */
public class Test {

    /**
     * Realize functionality of Task 3
     */
    public static void main(String[] args) {
        int[] array = {4,5,6};
        System.out.println("The min number of array is " + Array.getMinElement(array)); ;
        System.out.println("The sum of all elements in the array is " + Array.getSum(array));
        Array.printArray(array);
    }
}
