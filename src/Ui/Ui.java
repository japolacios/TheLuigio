package Ui;

import java.util.ArrayList;

import processing.core.PApplet;

public class Ui implements Runnable {

	// Atributes
	private PApplet app;
	private int stage;

	// Relations
	ArrayList<Hexagon> hexagons;
	NoiseLines noiseLines;
	Blocks blocks;
	// Constructor
	public Ui(PApplet _app) {
		app = _app;

		init();
	}

	public void init() {
		stage = 0;
		//hexagons = new ArrayList<Hexagon>();
		noiseLines = new NoiseLines(app);
		//blocks = new Blocks(app);
	}

	public void paint() {
		noiseLines.paint();
	}

	// -------------------Gets &
	// Sets-----------------------------------------------
	public int getStage() {
		return stage;
	}

	public void setStage(int _stage) {
		stage = _stage;
	}

	@Override
	public void run() {
		while(true){
			try {
				noiseLines.paint();
				//blocks.paint();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	// End of UI Class
}
