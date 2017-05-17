package Ui;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by edward on 17/05/17.
 */
public class Start {

    private PApplet app;
    private float z = 0; // create variable for noise z
    private PImage img;

    public Start(PApplet app) {

        this.app=app;
        img= app.loadImage("assets/logo.png");

    }
    public void pintar(){
        app.translate(0,0,30);
        app.noStroke();
        app.image(img, 560,240);
        //app.fill(0);

      //  app.rect(0,0,app.width,app.height);

        app.stroke(0,153, 230,50);
        app.strokeWeight(3);

        // float y = 0; creates decimal variable y and assigns value 0 to it
        // loop repeats as long as y < height; is true
        // y = y + 20 increments y in the end of each iteration.
        for (float y = 0; y < app.height; y = y + 25) {
            // float x = 0; creates decimal variable x and assigns value 0 to it
            // loop repeats as long as x < width; is true
            // x = x + 1 increments the x in the end of each iteration.
            for (float x = 0; x < app.width; x = x + 1) {

                app.point(x, y + app.map(app.noise(x/150, y/150, z), 0, 1, -100, 100));
            }
        }

        /* when y is 500 the program will move forward. In this case increment z */
        z = (float) (z + 0.002);

    }
}