package Ui;

import processing.core.PApplet;
import processing.core.PVector;

public class Hexagon {
	PVector pos; // position (x,y)
	int age; // age counter
	Hexagon parent; // my parent
	float rad; // my radius
	PApplet app;

	public Hexagon(PVector _pos, float _rad, Hexagon _parent, PApplet _app) {// constructor---for
																				// position,
																				// radius
																				// and
																				// parent
																				// hexagon
		app = _app;
		pos = _pos;
		rad = _rad; // make my radius
		age = 0;// start age at 0
		// -------> hexagons.add(this);//add myself to the hexagons list
		parent = _parent;

	}

	public void hexagon(float r) {// draw hexagon
		app.beginShape();
		float angle = 0;
		for (int v = 0; v < 6; v++) {
			app.vertex(app.cos(angle) * r, app.sin(angle) * r);
			angle += (app.TWO_PI / 6.0);
		}
		app.endShape(app.CLOSE);
	}

	void render() {// draw this hexagon
		app.fill(202 - (age * 5), 0, 136, 0 + (age * 20));// change fill colour by
														// age counter
		app.pushMatrix();// save the current system
		app.translate(pos.x, pos.y);// display haxagon at x,y position
		hexagon(rad);// draw hexagon
		app.popMatrix();// restore the previous system
		app.stroke(255);
		app.strokeWeight((float) (age * 0.02));
		// if (parent != null) line(pos.x,pos.y, parent.pos.x, parent.pos.y );

	}

	void grow(){//grow function
	age++;

	//pick a spot to grow a new cell
	float angle = app.TWO_PI/12 +  (app.random(6))*(app.TWO_PI/6);//angle change
	float distance = (float) (rad *2.02); //radius distance change
	PVector newpos = new PVector(pos.x + (app.cos(angle)*distance), pos.y + (app.sin(angle)*distance));//decide a position for growth hexagon
	 
	 //  check if that spot is free - check for collisions with all other hexagons

	 for (Hexagon checkhexagon : hexagons){ // run through the hexagons list, and check each one
	      float checkdist = newpos.dist(checkhexagon.pos);//how far the distance is
	      if (checkdist < rad*2) return; // if you get a collision, give up
	    }
	   
	    // if you can read this, the space is free
	 	float newRad = (float) (rad*0.98);
	    Hexagon newhexagon = new Hexagon(newpos, newRad, this, app ); // make a new hexagon

	   }
}
