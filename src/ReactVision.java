import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;

import TUIO.*;

public class ReactVision {
	PApplet app;
	
	//TUIO Atrubutes
	TuioProcessing tuioClient;
	float cursor_size = 15;
	float object_size = 60;
	float table_size = 760;
	float scale_factor = 1;
	PFont font;
	ArrayList<TuioObject> tuioObjectList;

	boolean verbose = false; // print console debug messages
	boolean callback = true; // updates only after callbacks
	
	public ReactVision(PApplet _app){
		app = _app;
		
		// periodic updates
		  if (!callback) {
		    app.frameRate(20);
		    app.loop();
		  } else 
			 {
			  //app.noLoop(); // or callback updates 
			 }
		  font = app.createFont("Arial", 18);
		  scale_factor = app.height/table_size;
		  
		  tuioClient  = new TuioProcessing(app);
	}
	
	// called when a blob is added to the scene
		public void addTuioBlob(TuioBlob tblb) {
		  if (verbose) app.println("add blb "+tblb.getBlobID()+" ("+tblb.getSessionID()+") "+tblb.getX()+" "+tblb.getY()+" "+tblb.getAngle()+" "+tblb.getWidth()+" "+tblb.getHeight()+" "+tblb.getArea());
		  //redraw();
		}

		// called when a blob is moved
		//TO MODIFY !!!
		public void updateTuioBlob (TuioBlob tblb) {
		  if (verbose) app.println("set blb "+tblb.getBlobID()+" ("+tblb.getSessionID()+") "+tblb.getX()+" "+tblb.getY()+" "+tblb.getAngle()+" "+tblb.getWidth()+" "+tblb.getHeight()+" "+tblb.getArea()
		          +" "+tblb.getMotionSpeed()+" "+tblb.getRotationSpeed()+" "+tblb.getMotionAccel()+" "+tblb.getRotationAccel());
		  //redraw()
		}

		// called when a blob is removed from the scene
		//TO MODIFY!!!
		public void removeTuioBlob(TuioBlob tblb) {
		  if (verbose) app.println("del blb "+tblb.getBlobID()+" ("+tblb.getSessionID()+")");
		  //redraw()
		}

		// --------------------------------------------------------------
		// called at the end of each TUIO frame
		public void refresh(TuioTime frameTime) {
		  if (verbose) app.println("frame #"+frameTime.getFrameID()+" ("+frameTime.getTotalMilliseconds()+")");
		  if (callback) app.redraw();
		}

		public void pintar(){
			//System.out.println("Call Pintar React");
			app.textFont(font,18*scale_factor);
			  float obj_size = object_size*scale_factor; 
			  float cur_size = cursor_size*scale_factor; 
			   
			  
			  tuioObjectList = tuioClient.getTuioObjectList();
			  
			  for (int i=0;i<tuioObjectList.size();i++) {
			     TuioObject tobj = tuioObjectList.get(i);
			     app.stroke(0);
			     //app.fill(0,0,255);
			     app.pushMatrix();
			     app.translate(tobj.getScreenX(app.width),tobj.getScreenY(app.height));
			     app.rotate(tobj.getAngle());
			    // app.ellipse(-obj_size/2,-obj_size/2,150,150);
			     app.popMatrix();
			     app.fill(255,0,0);
			  //   app.text(""+tobj.getSymbolID(), tobj.getScreenX(app.width), tobj.getScreenY(app.height));
			   }
			   
		}
		
		public ArrayList<TuioObject> getReactObjects(){
			return tuioObjectList;
		}
		
		
}
