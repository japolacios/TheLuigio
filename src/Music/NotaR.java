package Music;

import java.util.Observable;

import processing.core.PApplet;
import processing.core.PVector;

public class NotaR extends Observable {
	
	  PVector pos;
	  PApplet app;

	  float destX, destY;
	  int diam;
	  int eqs;
	  int vel;
	  int idUser;

	private int forma;

	  NotaR(float posX, float posY, PApplet app, float interval, int forma, int idUser){
		  this.app=app;
		  this.forma=forma;
		  this.idUser=idUser;
	    
	    	pos= new PVector(posX, posY);
	    	diam=10;
	    	eqs=(int)app.random(1,16);

	    	if (idUser==1){
				destX=585;
			}

		  if (idUser==2){
			  destX=685;
		  }
		  if (idUser==3){
			  destX=785;
		  }


		  destY=190+(eqs*(interval/4))-(interval/4)/2;
	    vel= 6;
	  }
	  
	  NotaR(){
	    
	    pos= new PVector(app.random(app.width), app.random(app.height));
	    diam=10;
	    
	  }

	public void pintar() {

		app.strokeWeight(5);
		app.noStroke();

		float a = PApplet.map(diam, 20, 80, 60, 255);
		float b = PApplet.map(diam, 20, 80, 1, 30);


		switch (forma) {
			case 0:
				app.fill(234, 0, 95);
				app.rectMode(app.CENTER);
				app.rect(pos.x, pos.y, 15, 15);

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.rotate(a - 30);
				app.noFill();
				app.stroke(18 + a, 183 - a, 255);
				app.rect(0, 0, 30, 30);
				app.popMatrix();
				app.rectMode(app.CORNER);

				break;

			case 1:
				int tam = 30;


				app.stroke(18, 183, 255);
				app.noFill();

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.rectMode(app.CENTER);
				app.rotate(a - 30);
				app.rect(0, 0, tam, tam);
				app.rectMode(app.CORNER);
				app.popMatrix();

				app.ellipse(pos.x, pos.y, tam + tam / 2, tam + tam / 2);

				break;

			case 2:
				app.fill(255,0,0);
				app.ellipse(pos.x,pos.y,30,30);
				break;

			case 3:
				app.fill(255,255,0);
				app.ellipse(pos.x,pos.y,30,30);
				break;

			case 4:
				app.noFill();
				app.stroke(18, 183, 255);

				app.ellipse(pos.x, pos.y, 40, 40);

				app.pushMatrix();
				app.translate(pos.x, pos.y);
				app.noFill();
				app.stroke(234, 0, 95);
				app.ellipseMode(app.CORNER);
				app.rotate(diam);
				app.ellipse(15, 15, 20, 20);
				app.ellipseMode(app.CENTER);
				app.popMatrix();

				break;

			case 5:

				app.noFill();
				app.stroke(18, 183, 255);
				app.rectMode(app.CENTER);
				app.rect(pos.x, pos.y, 15, 15);
				app.rectMode(app.CORNER);


				break;

		}
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

	    if(PApplet.dist(pos.x, pos.y, pos.x, y)<6){
			if(pos.x>540) {
				if (idUser==1) {
					setChanged();
					notifyObservers("suene uno"+":"+forma);
					clearChanged();
				}

				if (idUser==2) {
					setChanged();
					notifyObservers("suene dos"+":"+forma);
					clearChanged();

				}

				if (idUser==3) {
					setChanged();
					notifyObservers("suene tres"+":"+forma);
					clearChanged();

				}


				return true;
			}
	    }
	     return false; 

	  }

	  
	  public int getEqs(){
	   return eqs;
	  }

	public int getForma() {
		return forma;
	}

	public void setForma(int forma) {
		this.forma = forma;
	}
}
