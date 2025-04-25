public class TTTDir {
    private char currentPlayer = 'X';

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean isWinner(String[][] board) {
        for (int i = 0; i < 3; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2])) return true;
            if (checkLine(board[0][i], board[1][i], board[2][i])) return true;
        }
        return checkLine(board[0][0], board[1][1], board[2][2]) ||
               checkLine(board[0][2], board[1][1], board[2][0]);
    }

    public boolean  isDraw(String[][] board) {
        for (String[] row : board) {
            for (String cell : row) {
                if (cell.equals("")) {
                    return false;
                }
            }
        }
            return true;
    }

    private boolean checkLine(String a, String b, String c) {
        return !a.equals("") && a.equals(b) && a.equals(c);
    }
} 
