package Ui;

import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;

public class NoiseLines {

	private PApplet app;
	private float z = 0;
	private ArrayList<MyPoint> points;
	
	public NoiseLines(PApplet _app) {
		app = _app;
		points = new ArrayList<MyPoint>();
	}
	
	public void paint(){
		app.noStroke();
	    app.fill(0, 10);
	    app.rect(0,0,app.height,app.width);
	    app.stroke(255, 100);
	    makeLine();
	    for (int i = 0; i < points.size(); i++) {
			points.get(i).paint();
		}
	    System.out.println(points.size());
	    
	    if(points.size()>50){
	    	points.clear();
	    }
	    //app.background(0);
	}
	
	public void makeLine(){
		// float y = 0; creates decimal variable y and assigns value 0 to it
	    // loop repeats as long as y < height; is true
	    // y = y + 20 increments y in the end of each iteration.
	    for (float y = 0; y < app.height; y = y + 20) {
	        // float x = 0; creates decimal variable x and assigns value 0 to it
	        // loop repeats as long as x < width; is true
	        // x = x + 1 increments the x in the end of each iteration.
	        for (float x = 0; x < app.width; x = x + 1) {
			  //app.point(x, y + app.map(app.noise(x/150, y/150, z), 0, 1, -100, 100));
	        	MyPoint tempPoint = new MyPoint(x,y,z,app);
	        	points.add(tempPoint);
	            
	        }
	    }
	    // when y is 500 the program will move forward. In this case increment z
	    z = (float) (z + 0.02);
	}
}
