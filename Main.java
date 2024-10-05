import javax.swing.JFrame;
import java.awt.Toolkit;

public class Main extends JFrame
{
	GameState state;
	GameController controller;
	GameView view;

	public Main()
	{
		// Instantiate the three main objects
		state = new GameState();
		view = new GameView(state);
		controller = new GameController(state, view);

		// Set some window properties
		this.setTitle("2D Movement");
		this.setSize((int)this.view.getPreferredSize().getWidth(), (int)this.view.getPreferredSize().getHeight());
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(controller);
	}

	public void run()
	{
		// Main loop
		while(true)
		{
			controller.update();
			state.update();
			view.repaint(); // Indirectly calls View.paintComponent
			Toolkit.getDefaultToolkit().sync(); // Updates screen

			// Go to sleep for a brief moment
			try
			{
				Thread.sleep(25);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	public static void main(String[] args)
	{
		Main m = new Main();
		m.run();
	}
}