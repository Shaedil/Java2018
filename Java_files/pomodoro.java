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
class pomodoro{

    public static void main(String[] args) {
       
        initiateInput();

    }

    // This method initates the entire program by stringing methods
    public static void initiateInput() {

        Scanner in = new Scanner(System.in);
        System.out.print("Choose: 'shortbreak/short', 'longbreak/long', 'pomodoro/pomo' or 'exit': ");

        String option = in.nextLine();
        System.out.println("You typed: " + option);
        userChoice(option);

    }
    //Activates timer using 'counter' as a variable of change.
    public static void activateTimer(int counter) {
        System.out.println("Timer initiated");
            try {
                long b = counter/60 - 1; // conversion to minutes
                for (int a = 0; a <= b; a++) { // minutes
                    for (int i = 59; i >= 0; i--) { // seconds
                        System.out.print("\r" + (b-a + ":" + i));
                        Thread.sleep(1000);
                    }
                }
            }
            catch (Exception ex) {}
        System.out.println("Time's Up!");
        /* Alarm sound played once. Uncomment this code, may work on windows not on linux. 
        for (int beep = 0; beep < 5; beep++) {
            Toolkit tk = Toolkit.getDefaultToolkit();
            tk.beep();
        }*/
    }
    //Checks input through if-then-else case, if true for any one, run ActivateTimer.
    public static void userChoice(String option) { 
        if (option.equals("pomodoro")) {
            int counter = 1200; // 20 min
            activateTimer(counter);
        }
        else if (option.equals("longbreak") || (option.equals("long"))) {
            int counter = 600; // 10 min
            activateTimer(counter);
        }
        else if (option.equals("shortbreak") || (option.equals("short"))) {
            int counter = 300; // 5 min
            activateTimer(counter);
        }
        else {
            exitOption(option);
        }
    public static void exitOption(String option) {
        if (option.equals("exit") || option.equals("quit") {
            System.flush(0);
        }
        else {
            System.out.println("That isn't an option!");
        }
    }
    } // Ends userChoice method
} //Ends pomodoro class
