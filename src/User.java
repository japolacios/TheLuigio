import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class User {

	private PVector pos;
	private PApplet app;
	private float x,y;
	private int id;
	private PImage img1, img2, img3;



	public User(PApplet _app, float _x, float _y, int _id) {
		app = _app;
		x =_x;
		y =_y;
		id = _id;


		img1= app.loadImage("assets/instru.png" );
		img2= app.loadImage("assets/instru2.png" );
		img3= app.loadImage("assets/instru3.png" );


	}

	public void pintar() {

		app.imageMode(app.CENTER);

		pos = new PVector(x, y);
		if(id==0){

			//app.noStroke();
			//app.fill(0, 255, 0);
			//app.rect(pos.x, pos.y, 50, 50);

		}

		if(id==0) {
			//app.imageMode(PConstants.CENTER);
		app.image(img1, pos.x,pos.y ,50, 50);

		}

		if(id==1) {
			//app.imageMode(PConstants.CENTER);
			app.image(img2, pos.x,pos.y, 50,50);

		}

		if (id==2){
			app.image(img3, pos.x,pos.y, 50,50);

		}

		app.imageMode(app.CORNER);
	}

	public PVector getPos() {
		return pos;
	}
	
	public int getId(){
		return id;
	}
	
	public void setPos(float _x, float _y){
		x =_x;
		y =_y;
	}
}
