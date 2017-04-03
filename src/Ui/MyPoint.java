package Ui;

import processing.core.PApplet;

public class MyPoint {
	float x,y,z;
	PApplet app;
	public MyPoint(float _x, float _y, float _z, PApplet _app){
		x = _x;
		y = _y;
		z = _z;
		app = _app;
	}
	
	public void paint(){
		try{
		//app.point(x, y + app.map(app.noise(x/150, y/150, z), 0, 1, -100, 100));
		app.line(x, y, app.noise(x/150, y/150, z), app.noise(x/150, y/150, z) );
		}
		catch(NullPointerException n){
			System.out.println("Something Failed on the Points");
		}
	}
}
