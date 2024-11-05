import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FallingBlocks extends JPanel implements ActionListener {
    private Timer timer;
    private int playerX, playerY, score;
    private ArrayList<Rectangle> blocks;
    private Random rand;
    private boolean moveLeft, moveRight;
    private int blockSpeed;

    public FallingBlocks() {
        timer = new Timer(10, this);
        timer.start();
        playerX = 250;
        playerY = 550;
        score = 0;
        blockSpeed = 2;
        blocks = new ArrayList<>();
        rand = new Random();

        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    moveLeft = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    moveRight = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    moveLeft = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    moveRight = false;
                }
            }
        });
    }

    private void spawnBlock() {
        int x = rand.nextInt(550); 
        int size = 20 + rand.nextInt(30); 
        blocks.add(new Rectangle(x, 0, size, size));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Write code here
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 50, 50);
        g.setColor(Color.RED);
        for (Rectangle block : blocks) {
            g.fillRect(block.x, block.y, block.width, block.height);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (moveLeft && playerX > 0) {
            playerX -= 5;
        }
        if (moveRight && playerX < getWidth() - 50) {
            playerX += 5;
        }
        for (Rectangle block : blocks) {
            block.y += blockSpeed;
        }
        blocks.removeIf(block -> block.y > getHeight());
        if (rand.nextInt(20) == 0) {
            spawnBlock();
        }
        for (Rectangle block : blocks) {
            if (block.intersects(new Rectangle(playerX, playerY, 50, 50))) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game Over! Your score: " + score);
                System.exit(0);
            }
        }
        if (score % 100 == 0 && blockSpeed < 10) {
            blockSpeed++;
        }

        score++;
        repaint();
    }
    //.....

    public static void main(String[] args) {
        JFrame frame = new JFrame("Falling Blocks");
        FallingBlocks game = new FallingBlocks();
        frame.add(game);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
