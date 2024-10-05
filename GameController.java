import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController extends KeyAdapter {
    private GameState state;
    private GameView view;

    boolean keyRight = false;
    boolean keyLeft = false;
    boolean keyUp = false;
    boolean keyDown = false;

    public GameController(GameState state, GameView view) {
        this.state = state;
        this.view = view;
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:  // Move up
                this.keyUp = true;
                break;
            case KeyEvent.VK_DOWN:  // Move down
                this.keyDown = true;
                break;
            case KeyEvent.VK_LEFT:  // Move left
                this.keyLeft = true;
                break;
            case KeyEvent.VK_RIGHT:  // Move right
                this.keyRight = true;
                break;
        }

        // Repaint the view after each movement
        this.view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: 
				this.keyRight = false; 
				break;
			case KeyEvent.VK_LEFT: 
				this.keyLeft = false; 
				break;
			case KeyEvent.VK_UP: 
				this.keyUp = false; 
				break;
			case KeyEvent.VK_DOWN: 
				this.keyDown = false; 
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
		}
    }

    void update()
    {
        if(this.keyUp)
        {
            this.state.moveUp();
        }
        if(this.keyDown)
        {
            this.state.moveDown();
        }
        if(this.keyLeft)
        {
            this.state.moveLeft();
        }
        if(this.keyRight)
        {
            this.state.moveRight();
        }
    }
}