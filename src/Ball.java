/**
 * Created by dchen on 4/27/14.
 */

import processing.core.PApplet;

public class Ball {

    private PApplet parent;
    private int radius;
    //starting positions
    private float xPos, yPos;
    private float xSpeed, ySpeed;
    private int xDirection;
    private int yDirection = 1;
    private int[] rgb = new int[3];

    public Ball(PApplet parent, int xPos, int yPos) {
        this.parent = parent;
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = 20;
        for(int i = 0; i < 3; i++) {
            this.rgb[i] = ((Double)(Math.floor(Math.random() * 255))).intValue();
        }

        xDirection = Math.random() > 0.5 ? 1 : -1;

        xSpeed = (float) Math.random() * 3.0f;
        ySpeed = (float) Math.random() * 2.1f;
    }

    public void draw() {
        parent.fill(rgb[0], rgb[1], rgb[2]);
        parent.ellipse(xPos, yPos, radius, radius);
    }

    public void move() {
        // Update the position of the shape
        float deltaX = xSpeed * xDirection;
        float deltaY = ySpeed * yDirection;
        this.setXPos(xPos + deltaX);
        this.setYPos(yPos + deltaY);

        parent.translate(deltaX, deltaY);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXPos() {
        return xPos;
    }

    public void setXPos(float xPos) {
        this.xPos = xPos;

        if (xPos > parent.width-radius || xPos < radius) {
            this.setXDirection(getXDirection() * -1);
        }
    }

    public float getYPos() {
        return yPos;
    }

    public void setYPos(float yPos) {
        this.yPos = yPos;

        if (yPos > parent.height-radius || yPos < radius) {
            this.setYDirection(this.getYDirection() * -1);
        }
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getXDirection() {
        return xDirection;
    }

    public void setXDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getYDirection() {
        return yDirection;
    }

    public void setYDirection(int yDirection) {
        this.yDirection = yDirection;
    }
}
