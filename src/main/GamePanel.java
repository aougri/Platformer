package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private long lastCheck =0;
    private int frames =0;
    private float xPos = 100, yPos = 100;
    private float xDir= 0.01f, yDir = 0.01f;
    private Color color;

    private final MouseInputs mouseInputs;

    public GamePanel() {
        mouseInputs = new MouseInputs(GamePanel.this);
        addKeyListener(new KeyBoardInputs(GamePanel.this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXPos(int val) {
        this.xPos += val;
        repaint();
    }

    public void changeYPos(int val) {
        this.yPos += val;
        repaint();
    }

    public void setRectPos(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        repaint();
    }


    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        updateRect();
        g.setColor(color);

        g.fillRect((int)xPos, (int)yPos, 200, 50);
        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000) {
            System.out.println("FPS: " + frames);
            frames = 0;
            lastCheck = System.currentTimeMillis();
        }
        repaint();

    }


    private Color getRandomColor() {
        return new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
    }
    private void updateRect() {
        xPos+= xDir;
        if(xPos > 800 || xPos < 0) {
            xDir*=-1;
            color = getRandomColor();
        }

        yPos+= yDir;
        if(yPos > 600 || yPos < 0) {
            yDir*=-1;
        }

    }



}

