package Ui;

import processing.core.PApplet;

public class Blocks {
	private PApplet app;

	public Blocks(PApplet _app) {

	}

	public void paint(){
		app.fill(0);
		  app.noStroke();
		  app.rectMode(app.CENTER);
		
		  app.noiseDetail(2, (float) 0.9);
		  
		  for (int x = 10; x < app.width; x += 10) {
			    for (int y = 10; y < app.height; y += 10) {
			      float n = app.noise((float) (x * 0.005), (float) (y * 0.005), (float) (app.frameCount * 0.05));
			      app.pushMatrix();
			      app.translate(x, y);
			      app.rotate(app.TWO_PI * n);
			      app.scale(10 * n);
			      app.rect(0, 0, 1, 1);
			      app.popMatrix();
			    }
			  }
	}
}
