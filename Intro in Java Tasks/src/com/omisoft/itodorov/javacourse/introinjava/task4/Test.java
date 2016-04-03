package com.omisoft.itodorov.javacourse.introinjava.task4;

import com.omisoft.itodorov.javacourse.introinjava.task3.Array;

/**
 * Created by johny on 08.09.15.
 */
public class Test {

    /**
     * Realize functionality of Task 4
     */
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 5, 2, 3, 34, 12};
        Array.printArray(array);
        System.out.print("The center of weight of this array is on position : "+(ArrayForSearch.getCenterOfWeight(array)+1));
    }
}


