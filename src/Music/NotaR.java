package Music;

import java.util.Observable;

import processing.core.PApplet;
import processing.core.PVector;

public class NotaR extends Observable {
	
	  PVector pos;
	  PApplet app;
	  float destX, destY;
	  int tam;
	  int eqs;
	  int vel;
	  
	  NotaR(float posX, float posY, PApplet app, float interval ){
		  this.app=app;
	    
	    pos= new PVector(posX, posY);
	    tam=20;
	    eqs=(int)app.random(1,16); 
	    /*destX=(eqs*(interval/4))-(interval/4)/2;
	    destY=25;*/

		  destX=555;
		  destY=190+(eqs*(interval/4))-(interval/4)/2;
	    vel= 6;
	    
	  }
	  
	  NotaR(){
	    
	    pos= new PVector(app.random(app.width), app.random(app.height));
	    tam=20;
	    
	  }

	  public void pintar(){
	    
	    app.fill(0,255,0);
	    app.ellipse(pos.x,pos.y, tam,tam);
	   animar(); 
	  }
	  
	  public void animar(){
	    if(pos.x>destX)
	  {pos.x-=vel;}
	    if(pos.x<destX)
	    {pos.x+=vel;}
	    if(pos.y>destY)
	    {pos.y-=vel;}
	    if(pos.y<destY)
	    {pos.y+=vel;}
	    
	    
	  }
	  
	  public boolean sonar(float y){

	    if(PApplet.dist(pos.x, pos.y, pos.x, y)<12){
	    	setChanged();
			notifyObservers("suene");
			clearChanged();
	      return true;
	    }
	     return false; 

	  }
	  
	  public int getEqs(){
	   return eqs;
	  }
	  
	  public void randomice(){
	    
	  }
	 

}
