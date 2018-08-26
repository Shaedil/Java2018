import java.lang.Math;
import java.util.Scanner;
class calculator {

    public static void main(String[] args) {
        programInfo();
    
    }
    //Prints out an ascii-like menu and gives prompt of what to calculate.
    public static void programInfo() {
        System.out.println("                                                ");
        System.out.println("+=================+CALCULATOR+=================+");
        System.out.println("|                                              |");
        System.out.println("|Can do the most basic of a graphing calculator|");
        System.out.println("|       Add, subtract, divide, multiply.       |");
        System.out.println("|   Exponents, squareroots & graphing (x, y).  |");
        System.out.println("|       Exit by typing 'quit' or 'exit'.       |");
        System.out.println("+==============================================+");
        System.out.println("|   Options: Add, Subtract, Divide, Multiply   |");
        System.out.println("|          Exponents, Sqrt & Graphing          |");
        System.out.println("+----------------------------------------------+");
        System.out.println("|**Graphing is not yet supported! I'm trying my|");
        System.out.println("|  best to fix the issue. Fix in next version. |");
        System.out.println("+______________________________________________+" + "\n");
        userPrompt();
    }
    public static void userPrompt() {
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Choose: ");
        String choice = Scanner.nextLine();
        calculateBasicOperation(choice);
    }
    // 4 basic operations of math - add, subtract, multiply, and divide
    public static void calculateBasicOperation(String choice) {
        if (choice.equals("add") || (choice.equals("Add"))) {
            Scanner value = new Scanner(System.in);
            System.out.print("Type in value 1 & 2: (press enter after each value)");
            double val1 = value.nextInt();
            double val2 = value.nextInt();
            System.out.println(val1+val2);
            userPrompt();
        }
        else if (choice.equals("subtract") || (choice.equals("Subtract"))) {
            Scanner value = new Scanner (System.in);
            System.out.print("Type in value 1 & 2: (press enter after each value)");
            double val1 = value.nextInt();
            double val2 = value.nextInt();
            System.out.println(val1-val2);
            userPrompt();
        }
        else if (choice.equals("divide") || (choice.equals("Divide"))) {
            Scanner value = new Scanner(System.in);
            System.out.print("Type in value 1 & 2: (press enter after each value)");
            double val1 = value.nextInt();
            double val2 = value.nextInt();
            System.out.println(val1/val2);
            userPrompt();
        }
        else if (choice.equals("multiply") || (choice.equals("Multiply"))) {
            Scanner value = new Scanner(System.in);
            System.out.println("Type in value 1 & 2: (press enter after each value)");
            double val1 = value.nextInt();
            double val2 = value.nextInt();
            System.out.print(val1*val2);
            userPrompt();
        }
        else {
            calculateAdvancedOperation(choice);
        }
    }
    /* 2 out of 3 working advanced operations - exponents, squareroots. Graphing doesn't work.
     * Need to set up a java .jar file from (java-ascii-renderer on github). Has methods that
     * can draw a graph based on x and y values as well as simple geometric shapes.
     */
    public static void calculateAdvancedOperation(String choice) {
        if (choice.equals("exponents") || (choice.equals("Exponents"))) {
            Scanner value = new Scanner(System.in);
            System.out.print("Type in base & power: (press enter after each value)");
            double base = value.nextInt();
            double power = value.nextInt();
            System.out.println(Math.pow(base, power));           
            userPrompt();
        }
        else if (choice.equals("sqrt") || (choice.equals("Sqrt"))) {
            Scanner value = new Scanner(System.in);
            System.out.print("Type in radicand: ");
            double radicand = value.nextInt();
            System.out.println(Math.sqrt(radicand));      
            userPrompt();
        }
        else if (choice.equals("graph") || (choice.equals("graphing"))) {
            System.out.println("Sorry, this feature is dead! Will be fixed by next version");
            System.out.println("눈_눈 - (Busy with other tasks)");
            userPrompt();
        }
        else {
            errorReturn(choice);
        }
    }
    // If all else fails, this method checks to quit or if it is a type error
    public static void errorReturn(String choice) {
        if (choice.equals("exit") || (choice.equals("quit"))) {
            System.exit(0);
        }
        else {
            System.out.println("Sorry, we could not find that option." +"\n" + "Please type in a correct option");
            userPrompt();
        }
    } // Ends errorReturn method
} // Ends class calculator
