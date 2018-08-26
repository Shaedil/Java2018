/*------------------------------------------------------------------------
 *   Copyright (C) 2018 Shaedil Dider                                    |
 *                                                                       |
 *   This program is free software; you can redistribute it and/or modify|
 *   it under the terms of the GNU General Public License as published by|
 *   the Free Software Foundation; either version 2 of the License, or   |
 *   (at your option) any later version.                                 |
 *                                                                       |
 *   This program is distributed in the hope that it will be useful,     |
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of      |
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        | 
 *   GNU General Public License for more details.                        |
 *------------------------------------------------------------------------
 */
import java.util.Scanner;
class fibonaccifinder {
    
    public static void main(String[] args) {
        initiateInput(); 

    }
    
    public static void initiateInput() {
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Choose an nth number of the Fibonacci sequence: ");
        int count = Scanner.nextInt(); 
        System.out.printf("%f = %s\n")
        exceptionFilter(count); 

    }
    public static int exceptionFilter(int count) {
    
        if (count == 0 || count == 1) {
            System.out.println(0); 
            return 0; 
        }
        if (count == 2) {
            System.out.println(1); 
            return 1; 
        }
        else {
            return fibonacciSearch(count);
        }
   
    }
    public static int fibonacciSearch(int count) {
        int first = 0;
        int second = 1;
        int third = 0;
        
        for (int i = 2; i < count;) {
            third = first + second; //reassigning values
            first = second; //first becomes second's value
            second = third; //second becomes third's value
            i++;
        }

        System.out.println(third);
        return third;
    }
} 
