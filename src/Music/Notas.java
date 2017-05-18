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
	float progress=0;
	//--------------------------AMEBA ESA-----------------


	//--------------------------AMEBA ESA-----------------


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



		app.strokeWeight(5);
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
			case 0:// Cuadro con cuadro dentro
				int tamC = 20;

				app.fill(234, 0, 95);
				app.rectMode(app.CENTER);
				app.rect(pos.x, pos.y, tamC+b, tamC+b);

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.rotate(progress - 60);
				app.noFill();
				app.stroke(18 + a, 183 - a, 255);
				app.rect(0, 0, tamC*2, tamC*2);
				app.popMatrix();

				app.rectMode(app.CORNER);

				break;

			case 1://ciculito con cuadrado adentro
				int tam = 40;

				app.stroke(234, 160, 255);
				app.noFill();

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.rectMode(app.CENTER);
				app.rotate(progress - 60);
				app.rect(0, 0, tam, tam);
				app.rectMode(app.CORNER);
				app.popMatrix();

				app.ellipse(pos.x, pos.y, tam + tam / 2, tam + tam / 2);

				break;

			case 2://cuadro con linea
				int square = 40;

				app.noFill();
				app.stroke(250, 1, 255);

				app.pushMatrix();
				app.translate(pos.x, pos.y);

				app.line(   15 + b ,  15 + b,  25 - b,  25 - b);

				app.rect(0, 0, square, square);
				app.popMatrix();
				break;

			case 3: // circulo arc
				app.noFill();

				int circulo = 30;


				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.stroke(25, 255, 0);
				app.arc(50, 55+(b-9), circulo, circulo, app.HALF_PI, app.PI+a);
				app.stroke(75, 255, 56);
				app.arc(50, 55, circulo + 10, circulo + 10, app.PI, app.PI+app.QUARTER_PI);
				app.stroke(160, 255, 150);
				app.arc(50, 55, circulo + 20, circulo + 20, app.PI+app.QUARTER_PI, app.TWO_PI);
				app.popMatrix();

				break;

			case 4: //Circulo  con circulito adentro

				int tamCir = 40;

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.noFill();
				app.stroke(255, 176, 91);
				app.ellipseMode(app.CORNER);
				app.rotate(progress-60);
				app.ellipse(5, 5, 10, 10);
				app.ellipseMode(app.CENTER);
				app.popMatrix();

				app.noFill();
				app.stroke(255, 67, 0);

				app.ellipse(pos.x, pos.y, tamCir, tamCir);

				break;

			case 5://ultimo rombo :v

				app.noFill();
				app.stroke(0, 174, 255);

				app.pushMatrix();
				app.translate(pos.x - (b-20), pos.y);
				app.quad(75, 50, 50, 15, 24, 50, 50, 85);
				app.popMatrix();

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.rectMode(app.CENTER);
				app.rect(60, 50, 30, 30);
				app.rectMode(app.CORNER);
				app.popMatrix();

				app.pushMatrix();
				app.translate(pos.x + (b-20), pos.y);
				app.quad(75 + 20, 50, 50 + 20, 15, 24 + 20, 50, 50 + 20, 85);
				app.popMatrix();

				break;

		}

	}

	public void mover() {

		pos.add(vel);
		progress+=0.03;

	}

	public boolean isIniciar() {
		return iniciar;
	}

	public void setIniciar(boolean iniciar) {
		this.iniciar = iniciar;
		//System.out.println("matado");
	}

	public PVector getPos() {
		return pos;
	}

	public int getForma() {
		return forma;
	}

	public void setForma(int forma) {
		this.forma = forma;
	}
}
