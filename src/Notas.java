import processing.core.PApplet;
import processing.core.PVector;

public class Notas {
	
	private PApplet app;
	private PVector pos;
	private PVector vel;
	private float t;
	float y;

	public Notas(PApplet _app) {
		app = _app;
		t = 0;
		pos = new PVector(app.random(50, 950), -50);
		vel = new PVector(app.random(-1, 1), app.random(0, 1));
	}

	public void pintar() {
		app.noStroke();
		app.fill(255);
		app.ellipse(pos.x, pos.y, 50, 50);
	}

	public void mover() {

		pos.add(vel);

	}

	public PVector getPos() {
		return pos;
	}

}
