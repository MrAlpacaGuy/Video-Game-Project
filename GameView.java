import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    GameState state;
    
    private int windowWidth = 1000;
    private int windowHeight = 1000;

    public GameView(GameState state) {
        this.state = state;
        this.setPreferredSize(new Dimension(this.windowWidth, this.windowHeight));  // Window size
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the player
        g.setColor(Color.BLUE);
        g.fillRect(state.getXCoord(), state.getYCoord(), 20, 20);  // Draw player as a 20x20 square
    }

    void update()
    {
    }
}