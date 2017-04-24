import codeanticode.syphon.SyphonServer;
import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;

import TUIO.*;
import processing.opengl.PJOGL;


public class TheLuigio extends PApplet {
	
	private Logica logica;

	SyphonServer s;
	//Metodos
	
	public void settings(){
		
		System.out.println("Set Canvas Size");
		size(1280, 800, P3D);
		PJOGL.profile=1;
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
		s = new SyphonServer(this, "Processing Syphon");
		    	  
	}
	
	@Override
	public void draw() {
		
		 background(0);
		logica.pintar();
		s.sendScreen();
	
	}
	
	
	public static void main(String[] args) {
		PApplet.main("TheLuigio");
	}

}