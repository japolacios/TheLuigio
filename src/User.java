import processing.core.PApplet;
import processing.core.PVector;

public class User {

	private PVector pos;
	private PApplet app;
	private float x,y;
	private int id;

	public User(PApplet _app, float _x, float _y, int _id) {
		app = _app;
		x =_x;
		y =_y;
		id = _id;
		
	}

	public void pintar() {
		pos = new PVector(x, y);
		app.noStroke();
		app.fill(0, 255, 0);
		app.ellipse(pos.x, pos.y, 50, 50);
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
