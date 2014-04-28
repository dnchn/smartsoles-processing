import processing.core.PApplet;

import java.util.ArrayList;

public class BounceAndRibbon extends PApplet{

    static public void main(String args[]) {
        PApplet.main(new String[] { "BounceAndRibbon" });
    }
    ArrayList<Ball> balls = new ArrayList<Ball>();
    ArrayList<Ribbon> ribbons = new ArrayList<Ribbon>();


    public void setup() {
        size(700, 360);
        noStroke();
        smooth();
        frameRate(30);

        balls = new ArrayList<Ball>();
        ribbons = new ArrayList<Ribbon>();
        ribbons.add(makeNewRibbon());
        ribbons.add(makeNewRibbon());
    }

    public void draw() {
        //background(255);

        for(Ribbon ribbon : ribbons) {
            ribbon.move();
            ribbon.display();
        }

        for(Ball ball : balls) {
            ball.move();
            ball.draw();
        }
    }

    public void mouseClicked() {
        Ball newBall = new Ball(this, mouseX, mouseY);
        balls.add(newBall);
        newBall.draw();
    }

    private Ribbon makeNewRibbon() {
        float direction = Math.random() > 0.5 ? 1 : 0;
        float startX = this.width - (this.width * direction);
        float startY = this.random(0, this.height);
        float endY = this.random(0, this.height);
        int[] rgb = new int[3];
        for(int i = 0; i < 3; i++) {
            rgb[i] = Math.round(this.random(0.f, 255.0f));
        }

        return new Ribbon(this, startX, startY, this.width - startX, endY, rgb);
    }
}
