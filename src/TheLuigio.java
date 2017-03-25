import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;

import TUIO.*;



public class TheLuigio extends PApplet {
	
	private Logica logica;
	
	

	//Metodos
	
	public void settings(){
		
		System.out.println("Set Canvas Size");
		size(displayWidth,displayHeight);
	}
	
	@Override
	public void setup() {
		System.out.println("Start Logic");
		logica = new Logica (this);
		if(logica != null){
			System.out.println("Logic Running");
		}
		
		  // GUI setup
		  noCursor();
		  
		  noStroke();
		  fill(0);	  
		  
	}
	
	@Override
	public void draw() {
		
		background(0);
		logica.pintar();	
	
	}
	
	
	public static void main(String[] args) {
		PApplet.main("TheLuigio");
	}

}