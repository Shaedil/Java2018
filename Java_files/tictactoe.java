import java.util.Scanner;
class tictactoe {
    public static void main(String[], args) {
        initBoard();
    }
    public static void initBoard() {
        String[] placeMove;
        String[] placeMove = new String[9];
        System.out.println(" This is 2 Player Tic-Tac-Toe");
        System.out.println("<IIIIIIIIIIIIIIIIIIIIIIIIIIII>" + "\n");
        System.out.println("         Keybindings         ");
        System.out.println("       <mmmmmmmmmmmmm>        " + "\n");
        System.out.println("0   1   2       NW  N  NE");
        System.out.println("  ` |  /          ` | /  ");
        System.out.println("3 - 4 - 5   =   W - C - E");
        System.out.println("  / | `           / | `  ");
        System.out.println("6   7   8       SW  S  SE" + "\n\n");
        System.out.println("X plays first.");
        System.out.println("Enter in a slot number to place your mark: ");
        startGame();
    }
    public static void printBoard() {
        System.out.println(".___________.");
        System.out.println("| " + placeMove[0] + " | " + placeMove[1] + " | " + placeMove[2] + " |");
        System.out.println("|___________|");
        System.out.println("| " + placeMove[3] + " | " + placeMove[4] + " | " + placeMove[5] + " |");
        System.out.println("|___________|");
        System.out.println("| " + placeMove[6] + " | " + placeMove[7] + " | " + placeMove[8] + " |");
        System.out.println("|___________|" + "\n");
    }
    public static void startGame() {
        //start scanner and input mechanism
        Scanner in = new Scanner(System.in);
        int playerMove in.nextInt();
        System.out.print("Choose a box to put in your mark: ");
        try {
            if (!(playerMove > 0 && playerMove <= 9)) {
                System.out.println("I could not find that box, please try again! ");
            }
        }
        catch (InputMisMatchException e) {
            System.out.println("Yeah, like that key is the right one. Why don't you try again?");
        }

    }
    
}
