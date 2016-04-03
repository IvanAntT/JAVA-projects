package com.omisoft.itodorov.javacourse.introinjava.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by johny on 07.09.15.
 * The Numbers class takes two fields
 * field firstNum  first number, which needs for algorithm
 * field secNum  second number, which needs for algorithm
 */
public class Numbers {
    public int firstNum;
    public int secNum;

    /**
     * The Numbers's class constructor
     */
    public Numbers(){}

    /**
     * Create Numbers which will be used in algorithm later
     */
    public void createNums(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String insertFirstNum = null;
        String insertSecNum = null;
        try {

            System.out.print("Insert First Number: ");
            insertFirstNum = br.readLine();
            int firstNumParse = Integer.parseInt(insertFirstNum);
            if (firstNumParse < 0) {
                throw new NumberFormatException();
            }
            else {
                this.firstNum = firstNumParse;
            }
            System.out.print("Insert Second Number: ");
            insertSecNum = br.readLine();
            int secondNumParse = Integer.parseInt(insertSecNum);
            if (secondNumParse < 0) {
                throw new NumberFormatException();
            }
            else{
                this.secNum = secondNumParse;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid data please try again !");
            createNums();
        }
    }

    public int findGreaterCommonDivider()
    {
        int dividend = 0;
        int divisor = 0;
        int reminder = 0;
        int tempReminder = 0;

        if (firstNum > secNum)
        {
            dividend = firstNum;
            divisor = secNum;
        }
        else if (firstNum < secNum)
        {
            dividend = secNum;
            divisor = firstNum;
        }

        tempReminder = findReminder(dividend,divisor);
        dividend = divisor;
        divisor = tempReminder;
        while (tempReminder != 0){
            tempReminder = findReminder(dividend, divisor);
            reminder = divisor;
            dividend = divisor;
            divisor = tempReminder;
        }

        return  reminder;
    }

    /**
     * Get first number of algorithm
     * @return first number of algorithm
     */
    public int getFirstNum(){
        return this.firstNum;
    }

    /**
     * Get second number of algorithm
     * @return second number of algorithm
     */
    public int getSecNum(){
        return this.secNum;
    }

    /**
     * Find the reminder, which
     * used in findGreaterCommonDivider method
     * @param dividend number which used in formula to find reminder
     * @param divisor  number which used in formula to find reminder
     * @return  The number which suit requirements to be reminder
     */
    private int findReminder(int dividend, int divisor)
    {
        int reminder = 0;

        for (int i = 1; i < dividend ; i++) {
            int tempReminder = dividend - (divisor * i);
            if (tempReminder < 0)
            {
                reminder = dividend - (divisor* (i - 1));
                break;
            }
        }

        return  reminder;
    }
}
