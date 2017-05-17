import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class User {

	private PVector pos;
	private PApplet app;
	private float x,y;
	private int id;
	private PImage img1, img2;

	public User(PApplet _app, float _x, float _y, int _id) {
		app = _app;
		x =_x;
		y =_y;
		id = _id;

		img1= app.loadImage("assets/instru.png" );
		img2= app.loadImage("assets/instru2.png" );

	}

	public void pintar() {
		pos = new PVector(x, y);
		if(id==0){

			//app.noStroke();
			//app.fill(0, 255, 0);
			//app.rect(pos.x, pos.y, 50, 50);

		}

		if(id==0) {
		app.image(img1, pos.x,pos.y ,150, 150);

		}

		if(id==1) {
			app.image(img2, pos.x,pos.y, 150,75);

		}
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
