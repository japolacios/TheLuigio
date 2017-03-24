import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;

public class Logica {

	// Constantes
	

	// Applet
	private PApplet app;

	// Relaciones
	ReactVision react;

	// Constructor
	public Logica(PApplet _app) {
		app = _app;
		init();
	}

	private void init() {
		react = new ReactVision(app);
	}

	public void pintar() {
		react.pintar();
	}
}
