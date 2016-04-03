package com.omisoft.itodorov.javacourse.introinjava.task4;

/**
 * Created by johny on 08.09.15.
 * Realize the logic ot task 4
 */
public class ArrayForSearch {

    /**
     * Return the index of the element which
     * divide array on two approximately equals halfs.
     * @param array The array that will divide
     * @return index of the element which divide the array
     */
    public static int getCenterOfWeight(int[] array){
        int centerIndex = 0;
        int sumBefore = 0;
        int sumAfter = 0;
        int result = Integer.MAX_VALUE;
        int curResult = 0;

        for (int i = 0; i < array.length; i++){

            for (int j = i; j < array.length; j++){
                sumAfter = sumAfter + array[j];
            }

            sumAfter = absValue(absValue(sumAfter) - array[i]);

            for (int j = i; j >= 0; j--){
                sumBefore = sumBefore + array[j];
            }

            sumBefore = absValue(absValue(sumBefore) - array[i]);

            curResult = absValue(absValue(sumBefore)-absValue(sumAfter));

            if (curResult < result){
                result = curResult;
                centerIndex = i;
            }

            sumAfter = 0;
            sumBefore = 0;
            curResult = 0;
        }

        return centerIndex;
    }

    /**
     * Return the absolute value of the integer
     * @param number integer which value will change into absolute value
     * @return absolute value of integer
     */
    public static int absValue(int number){
        if (number < 0) {
            return number*(-1);
        }
        else {
            return number;
        }
    }
}
