package Music;

import ddf.minim.AudioBuffer;
import ddf.minim.analysis.BeatDetect;
import processing.core.PApplet;
import processing.core.PVector;

public class Notas extends Thread {

	private PApplet app;
	private PVector pos;
	private PVector vel;
	private float t;
	float y;

	boolean iniciar = true;

	private int forma;
	private int color;
	BeatDetect beat;
	int diam = 30;

	public Notas(PApplet _app) {

		app = _app;
		t = 0;
		pos = new PVector(app.random(50, 540), -50);
		vel = new PVector(app.random(-1, 1), app.random(0, 2));
		beat = new BeatDetect();
		forma = (int) app.random(0, 6);

	}

	@Override
	public void run() {

		while (iniciar) {

			mover();
			try {
				sleep(33);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void pintar(AudioBuffer mix) {

		app.noStroke();
		beat.detect(mix);

		vel.limit(5);

		float a = PApplet.map(diam, 20, 80, 60, 255);
		float b = PApplet.map(diam, 20, 80, 1, 30);

		if (beat.isOnset())
			diam = 80;
		diam *= 0.95;
		if (diam < 20)
			diam = 20;

		switch (forma) {
			case 0:
				app.fill(234, 0, 95);
				app.rectMode(app.CENTER);
				app.rect(pos.x, pos.y, 30, 30);

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.rotate(a - 60);
				app.noFill();
				app.stroke(18 + a, 183 - a, 255);
				app.rect(0, 0, 60, 60);
				app.popMatrix();

				app.rectMode(app.CORNER);

				break;

			case 1:
				int tam = 50;

				app.stroke(18, 183, 255);
				app.noFill();

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.rectMode(app.CENTER);
				app.rotate(a - 60);
				app.rect(0, 0, tam, tam);
				app.rectMode(app.CORNER);
				app.popMatrix();

				app.ellipse(pos.x, pos.y, tam + tam / 2, tam + tam / 2);

				break;

			case 2:
				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.noStroke();
				app.smooth();
				float radius = 38 + b;
				for (int deg = 0; deg < 360; deg += 10) {
					float angle = app.radians(deg);
					float x = 50 + (app.sin(angle) * radius);
					float y = 50 + (app.cos(angle) * radius);
					app.ellipse(x, y, 2, 2);
				}
				app.popMatrix();
				break;

			case 3:
				float mov = 50;

				app.stroke(234, 0, 95);
				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.line(pos.x, pos.y - b, pos.x, pos.y + mov - b);
				app.line(pos.x + 15, pos.y + (mov / 3) + b, pos.x + 15, pos.y + (mov * 2) + b);
				app.line(pos.x + 30, pos.y + ((mov / 3) * 2) - b, pos.x + 30, pos.y + (mov * 2.5f) - b);

				app.line(pos.x + 40, pos.y + b, pos.x + 40, pos.y + mov + b);
				app.line(pos.x + 50, pos.y + (mov / 3) - b, pos.x + 50, pos.y + (mov * 2) - b);
				app.line(pos.x + 65, pos.y + ((mov / 3) * 2) + b, pos.x + 65, pos.y + (mov * 2.5f) + b);
				app.popMatrix();
				break;

			case 4:
				app.noFill();
				app.stroke(18, 183, 255);

				app.ellipse(pos.x, pos.y, 80, 80);

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.noFill();
				app.stroke(234, 0, 95);
				app.ellipseMode(app.CORNER);
				app.rotate(diam);
				app.ellipse(15, 15, 15, 15);
				app.ellipseMode(app.CENTER);
				app.popMatrix();

				break;

			case 5:

				app.noFill();
				app.stroke(18, 183, 255);

				app.pushMatrix();
				app.translate(pos.x-b, pos.y);
				app.quad(75, 50, 50, 15, 24, 50, 50, 85);
				app.popMatrix();

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.rectMode(app.CENTER);
				app.rect(60, 50, 30, 30);
				app.rectMode(app.CORNER);
				app.popMatrix();

				app.pushMatrix();
				app.translate(pos.x+b, pos.y);
				app.quad(75 + 20, 50, 50 + 20, 15, 24 + 20, 50, 50 + 20, 85);
				app.popMatrix();

				break;

		}

	}

	public void mover() {

		pos.add(vel);

	}

	public boolean isIniciar() {
		return iniciar;
	}

	public void setIniciar(boolean iniciar) {
		this.iniciar = iniciar;
		System.out.println("matado");
	}

	public PVector getPos() {
		return pos;
	}

}
