package com.omisoft.itodorov.javacourse.introinjava.task1;

import java.io.*;

/**
 * Created by johny on 07.09.15.
 * Realize functionality of Task 1
 */
public class Test {

    /**
     * Realize functionality of Task 1
     */
    public static void main(String[] args) {
        System.out.println("Greater Common Divider");
        System.out.println("Please insert two positive numbers and program will find their Greater Common Divider");
        Numbers firstNumbers = new Numbers();
        firstNumbers.createNums();
        System.out.print("GCD("+firstNumbers.getFirstNum()+","+firstNumbers.getSecNum()+")= "+firstNumbers.findGreaterCommonDivider());
    }
}
