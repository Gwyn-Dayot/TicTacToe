import java.awt.*;
import java.awt.event.*;

public class GameBoard extends Frame {
    private Button[][] buttons = new Button[3][3];
    private Label sLabel;
    private Button rButton;
    private GameController ctrl;

    public GameBoard() {
        super("AWT TicTacToe");
        setLayout(new BorderLayout());

        sLabel = new Label("Player X's turn");
        add(sLabel, BorderLayout.NORTH);

        Panel gridPanel = new Panel(new GridLayout(3, 3));
        Font font = new Font("Arial", Font.BOLD, 60);

        ctrl = new GameController(this);
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new Button("");
                buttons[row][col].setFont(font);
                buttons[row][col].addActionListener(ctrl);
                gridPanel.add(buttons[row][col]);
            }
        }

        add(gridPanel, BorderLayout.CENTER);

        Panel bottomPanel = new Panel();
        rButton = new Button("New Game");
        rButton.addActionListener(e -> ctrl.resetGame());
        bottomPanel.add(rButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setSize(400, 450);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public Button[][] getButtons() {
        return buttons;
    }

    public void updateStatus(String text){
        sLabel.setText(text);
    }
}