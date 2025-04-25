import java.awt.*;
import java.awt.event.*;

public class GameController implements ActionListener {
    private GameBoard board;
    private TTTDir directions;

    public GameController(GameBoard board) {
        this.board = board;
        this.directions = new TTTDir();
    }

    public void actionPerformed(ActionEvent e) {
        Button clicked = (Button) e.getSource();
        if (!clicked.getLabel().equals(" "))
        return;

        clicked.setLabel(String.valueOf(directions.getCurrentPlayer()));

        String[][] boardState = getBoardState();

        if (directions.isWinner(boardState)) {
            board.updateStatus("Player " + directions.getCurrentPlayer() + " wins!");
            disableButtons();
        } else if (directions.isDraw(boardState)) {
            board.updateStatus("It's a draw!");
        } else {
            directions.switchPlayer();
            board.updateStatus("Player " + directions.getCurrentPlayer() + "'s turn");
        }
    }

    private String[][] getBoardState() {
        Button[][] buttons = board.getButtons();
        String[][] state = new String[3][3];
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                state[r][c] = buttons[r][c].getLabel();
        return state;
    }

    private void disableButtons() {
        for (Button[] row : board.getButtons())
            for (Button b : row)
                b.setEnabled(false);
    }

    public void resetGame() {
        for (Button[] row : board.getButtons())
            for (Button b : row) {
                b.setLabel(" ");
                b.setEnabled(true);
            }
        board.updateStatus("Player 1's turn");
        directions = new TTTDir();
    }
}
