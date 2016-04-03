package com.omisoft.itodorov.javacourse.introinjava.task3;

/**
 * Created by johny on 08.09.15.
 * Realize the logic ot task 3
 */
public class Array {

    /**
     * Get element with the lowest value in array
     * @param array array in which will be search
     * @return value of the element with the lowest value in array
     */
    public static int getMinElement(int[] array){
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < array.length ; i++){
            if (array[i] < minValue){
                minValue = array[i];
            }
        }

        return minValue;
    }

    /**
     * Get element with the lowest value in array
     * @param array array whose element will be sum
     * @return sum of all values of the elements in array
     */
    public static int getSum(int[] array){
        int sum = 0;

        for (int i = 0; i < array.length ; i++){
            sum = sum + array[i];
        }

        return sum;
    }

    /**
     * Print all values of the elements in array
     * @param array array whose values of the elements will be print
     */
    public  static void printArray(int[] array){

        System.out.print("The array is [");
        for (int i = 0; i < array.length ; i++){
            if (i == array.length-1){
                System.out.println(array[i]+"]");
            }
            else {
                System.out.print(array[i] + ", ");
            }
        }

    }
}
