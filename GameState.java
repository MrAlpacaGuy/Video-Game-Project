public class GameState 
{
    private final double SPEED = 5.0;

    private int x = 100;
    private int y = 100;

    public GameState() {
        this.x = 100;  // Starting position
        this.y = 100;
    }

    public int getXCoord() {
        return this.x;
    }

    public int getYCoord() {
        return this.y;
    }

    public void moveUp() {
        this.y -= SPEED;
    }

    public void moveDown() {
        this.y += SPEED;
    }

    public void moveLeft() {
        this.x -= SPEED;
    }

    public void moveRight() {
        this.x += SPEED;
    }

    void update()
    {
    }
}
