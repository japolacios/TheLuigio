import ddf.minim.AudioBuffer;
import ddf.minim.analysis.BeatDetect;
import processing.core.PApplet;
import processing.core.PVector;

public class Notas {

	private PApplet app;
	private PVector pos;
	private PVector vel;
	private float t;
	float y;

	private int forma;
	private int color;
	BeatDetect beat;
	int diam = 50;

	public Notas(PApplet _app) {
		app = _app;
		t = 0;
		this.forma = forma;
		pos = new PVector(app.random(50, 950), -50);
		vel = new PVector(app.random(-1, 1), app.random(0, 2));
		beat = new BeatDetect();
		forma =  (int) app.random(0,4);
	}

	public void pintar(AudioBuffer mix) {
		
		
		app.noStroke();
		beat.detect(mix);
		pos.add(vel);
		vel.limit(5);

		float a = app.map(diam, 20, 80, 60, 255);

		if (beat.isOnset())
			diam = 80;
		diam *= 0.95;
		if (diam < 20)
			diam = 20;

		switch (forma) {
		case 0:
			app.fill(a, 100, 100);
			app.rectMode(app.CENTER);
			app.rect(pos.x, pos.y, diam + 30, diam + 30);
			
			app.noFill();
			app.stroke(a, 100, 100);
			app.rect(pos.x, pos.y, diam + 60, diam + 60);
		
			app.rectMode(app.CORNER);

		
			break;

		case 1:
			app.fill(250, 100, 100, a);
			app.ellipse(pos.x, pos.y, diam + 30, diam + 30);
			break;

		case 2:
			app.fill(200, 100, 100, a);
			// app.scale(a);
			app.triangle(pos.x, pos.y, pos.x + 50, pos.y + 60, pos.x - 70, pos.y + 80);
			break;

		case 3:
			app.noFill();
			app.stroke(100, 100, 100, a);
			app.strokeWeight(2);
			app.ellipse(pos.x, pos.y, diam + 30, diam + 30);
			break;

		}

	}

	public void mover() {

		pos.add(vel);

	}

	public PVector getPos() {
		return pos;
	}

}
