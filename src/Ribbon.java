import processing.core.PApplet;

/**
 * Created by dchen on 4/27/14.
 */
public class Ribbon {
    private float beginX;  // Initial x-coordinate
    private float beginY;  // Initial y-coordinate
    private float stepSize = 0.005f;    // Size of each step along the path
    private float percentCompleted;      // Percentage traveled (0.0 to 1.0)
    private float size = 20;
    private float endX;
    private float endY;
    private float x;
    private float y;
    private float DIST_X;
    private float DIST_Y;
    private int[] rgb = new int[3];
    private PApplet parent;

    Ribbon(PApplet parent, float beginX, float beginY, float endX, float endY, int[] rgb) {
        this.beginX = beginX;
        this.beginY = beginY;
        this.endX = endX;
        this.endY = endY;

        this.x = beginX;
        this.y = beginY;

        this.rgb = rgb;

        this.parent = parent;

        this.DIST_X = endX - beginX;
        this.DIST_Y = endY - beginY;

    }

    public void move() {
        percentCompleted += stepSize * (1 - percentCompleted);
//        if(percentCompleted < 1.0f) {
//            x = getNextX(percentCompleted);
//            y = getNextY(percentCompleted);
//        }
    }

    public void display() {
        if(percentCompleted < 1.0f) {
            parent.noStroke();
            parent.fill(rgb[0], rgb[1], rgb[2], 10);

            // Make ellipse shrink
//            float radius = this.size-this.percentCompleted*this.size;
//            parent.ellipse(x, y, radius, radius);
            this.renderUpTo(percentCompleted);
        }
    }

    private float getNextX(float targetPercentage) {
        return beginX + (targetPercentage*(DIST_X));
    }

    private float getNextY(float targetPercentage) {
        return beginY + (PApplet.pow(targetPercentage, 3)*(DIST_Y)-PApplet.pow(targetPercentage, 4)*(DIST_Y));
    }

    /*
     *   Terrible hack to render everything up to a percentage
     *
     *   Note: does not work as expected need to find layering library for Processing
     */
    public void renderUpTo(float targetPercentage) {
        float currentPercentage = 0.0f;
        while (currentPercentage < targetPercentage) {
            //Make ellipse shrink
            float radius = size-targetPercentage*size;
            parent.ellipse(getNextX(targetPercentage), getNextY(targetPercentage), radius, radius);
            currentPercentage += stepSize * (1 - targetPercentage);
        }
    }

    public float getPercentCompleted() {
        return percentCompleted;
    }

    public boolean isNearComplete() {
        return getPercentCompleted() > 0.9f;
    }
 }
