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
