import java.util.Scanner;
class tictactoe {
    public static void main(String[], args) {
        initBoard();
    }
    public static void initBoard() {
        String[] userMove;
        String[] userMove = new String[9];
        System.out.println("This is 2 Player Tic-Tac-Toe");
        System.out.println("<==========================>");
        System.out.println("X plays first. Enter in a slot number to place your mark: ");
        startGame();
    }
    public static void printBoard() {
        System.out.println(".___________.");
        System.out.println("| " + userMove[0] + " | " + userMove[1] + " | " + userMove[2] + " |");
        System.out.println("|___________|");
        System.out.println("| " + userMove[3] + " | " + userMove[4] + " | " + userMove[5] + " |");
        System.out.println("|___________|");
        System.out.println("| " + userMove[6] + " | " + userMove[7] + " | " + userMove[8] + " |");
        System.out.println("|___________|" + "\n");
    }
    public static void startGame() {
        //start scanner and input mechanism
        Scanner in = new Scanner(System.in);
    }
    
}
