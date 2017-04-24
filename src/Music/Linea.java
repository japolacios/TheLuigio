package Music;

import processing.core.PApplet;

public class Linea {

	 float posY;



	 PApplet app;
	  
	 public Linea(PApplet app){
		 this.app=app;
	  }
	  
	  public void pintar(){
	    
	 app.fill(200);
	  
	 // app.rectMode(app.CENTER);
	  app.rect(540, posY, 305, 5);
	 // app.rectMode(app.CORNER);
	  
	  }
	  
	  
	  public void mover(int m, float interval, int beats){
		  
		//  app.text(beats, posX+15, 100);
	      //posX= map(m,1,16,0,width);
	      posY=190+(m*(interval/4)-(interval/4)/2);
		//  System.out.println(posY);
		  //app.text(linetime, 30, app.height - 25);
	  }


	public float getPosY() {
		return posY;
	}
}
