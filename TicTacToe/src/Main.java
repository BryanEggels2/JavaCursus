import java.util.Scanner;

public class Main {
    private static String user = "A";
    private final static String X = "X";
    private final static String O = "O";
    private static int moveCount = 0;

    /**
     * @param args
     */
    public static void main(String... args) {
        System.out.println("Typ for example: 1,2\n");


        String[][] boardArray = new String[3][3];

        //Set a space between the boxes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardArray[i][j] = " ";
            }
        }

        //Assign user and create scanner
        initBoard(boardArray, false);
    }

    /**
     * Assign a user and create the scanner
     *
     * @param boardArray
     * @param sameUser
     */
    private static void initBoard(String[][] boardArray, boolean sameUser) {
        if (!sameUser) {
            switch (user) {
                case "A":
                    user = X;
                    break;
                case X:
                    user = O;
                    break;
                case O:
                    user = X;
                    break;
            }
        }

        //Display the board
        displayBoard(boardArray);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Typ here your choice: ");
        String textScanner = scanner.next();

        //After the input, update the board
        updateBoard(boardArray, textScanner);
    }

    /**
     * Display the board
     *
     * @param boardArray boardArray
     */
    private static void displayBoard(String[][] boardArray) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.println(i + "\t" + boardArray[i][0] + "|" + boardArray[i][1] + "|" + boardArray[i][2]);
                System.out.println("  --+" + " - " + "+-- ");
            }

            if (i == boardArray.length - 1) {
                System.out.println("   0 " + " 1 " + " 2  ");
            }
        }
    }

    /**
     * Update the board
     *
     * @param boardArray boardArray
     * @param inputText  inputText
     */
    private static void updateBoard(String[][] boardArray, String inputText) {
        int first = Integer.parseInt(inputText.substring(0, inputText.indexOf(",")));
        int second = Integer.parseInt(inputText.substring(inputText.indexOf(",") + 1));

        //Check for valid input
        if (first > 2 || second > 2) {
            System.out.println("Try again, enter 0,1,2");
            initBoard(boardArray, true);
        }

        //Set the right symbol for the user
        String player;
        if (user.equals(X)) {
            player = X;
        } else {
            player = O;
        }

        //Fill the right box in the board
        boardArray[first][second] = player;
        moveCount = moveCount + 1;

        checkWinner(boardArray);
    }

    /**
     * Check winner
     *
     * @param boardArray board two dimensional array
     */
    private static void checkWinner(String[][] boardArray) {
        if (moveCount < 5) {
            initBoard(boardArray, false);
            System.out.println("if statement");
        }

        if (boardArray[0][0].equals(user) && boardArray[0][1].equals(user) && boardArray[0][2].equals(user) ||
                boardArray[1][0].equals(user) && boardArray[1][1].equals(user) && boardArray[1][2].equals(user)
                || boardArray[2][0].equals(user) && boardArray[2][1].equals(user) && boardArray[2][2].equals(user)
                || boardArray[0][1].equals(user) && boardArray[1][1].equals(user) && boardArray[1][2].equals(user) ||
                boardArray[0][2].equals(user) && boardArray[1][2].equals(user) && boardArray[2][2].equals(user)
                || boardArray[0][0].equals(user) && boardArray[1][1].equals(user) && boardArray[2][2].equals(user)) {

            displayBoard(boardArray);
            System.out.println("USER " + user + " HAS THREE IN A ROW!");
        } else {
            initBoard(boardArray, false);
        }
    }
}
