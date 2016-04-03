package com.omisoft.itodorov.javacourse.introinjava.task2;

import com.omisoft.itodorov.javacourse.introinjava.task1.Numbers;

/**
 * Created by johny on 08.09.15.
 */
public class NumbersForLcm {

    public static void findLeastCommonMultiple(){
        System.out.println("Least Common Multiple");
        System.out.println("Please insert two positive numbers and program will find their Least Common Multiple");
        Numbers myNumbers = new Numbers();
        myNumbers.createNums();
        int greaterCommonDivider = myNumbers.findGreaterCommonDivider();
        int leastCommonMultiple= (myNumbers.getFirstNum() * myNumbers.getSecNum()) / greaterCommonDivider;
        System.out.println("LCM("+myNumbers.getFirstNum()+","+myNumbers.getSecNum()+")= "+leastCommonMultiple);
    }
}
