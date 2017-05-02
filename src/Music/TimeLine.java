package Music;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;
import processing.core.PApplet;
import ddf.minim.AudioInput;
import ddf.minim.AudioSample;
//import ddf.minim.Minim;
import ddf.minim.ugens.*;

import static javax.swing.SwingConstants.CENTER;

public class TimeLine implements Observer {


	private boolean poblar=false;


//time

	int count;
	float bpm = 400;
	float minute = 60000;
	float interval = minute / bpm;
	int time;
	int linetime;
	int beats = 0;

	boolean sonar=false;

	//objects
	Linea linea;
	private ArrayList<NotaR> notas;
//private ArrayList<Notas> notasArray;
//private User user;
//minim

	Minim minim;
	AudioOutput out;
	Sampler s,h,k;
	//sonidos nuevos xdxdx
	Sampler unoocho,unonueve, unodiez;
	Sampler dosuno,dosdos,dostres, doscuatro, doscinco;
	Sampler tresuno,tresdos,trestres, trescuatro, trescinco, tresseis;

	AudioInput au;
	PApplet app;

	public TimeLine(PApplet app, Minim minim) {


		this.app=app;
		this.minim=minim;
//	  app.size(1280, 800);
//	  app.fill(255, 0, 0);
		app.noStroke();
		time = app.millis();

		out  = minim.getLineOut();

		//assets pista base
		s= new Sampler("assets/hithat.wav", 4, minim);
		k=new Sampler("assets/redo.wav", 4, minim);
		h=new Sampler("assets/bombo.wav", 4, minim);

		s.patch(out);
		k.patch(out);
		h.patch(out);




		//uno---------------------------------------------

		unonueve=new Sampler("assets/onenueve.wav", 4, minim);
		unoocho=new Sampler("assets/oneocho.wav", 4, minim);
		unodiez=new Sampler("assets/unodiez.wav", 4, minim);

		unonueve.patch(out);
		unoocho.patch(out);
		unodiez.patch(out);

		//dos---------------------------------------------

		dosuno=new Sampler("assets/dosuno.wav", 4, minim);
		dosdos=new Sampler("assets/dosdos.wav", 4, minim);
		dostres=new Sampler("assets/dostres.wav", 4, minim);
		doscuatro=new Sampler("assets/doscuatro.wav", 4, minim);
		doscinco=new Sampler("assets/doscinco.wav", 4, minim);

		dosuno.patch(out);
		dosdos.patch(out);
		dostres.patch(out);
		doscuatro.patch(out);
		doscinco.patch(out);

		//tres---------------------------------------------


		tresuno=new Sampler("assets/tresone.wav", 4, minim);
		tresdos=new Sampler("assets/tresdos.wav", 4, minim);
		trestres=new Sampler("assets/trestres.wav", 4, minim);
		trescuatro=new Sampler("assets/trescuatro.wav", 4, minim);
		trescinco=new Sampler("assets/trescinco.wav", 4, minim);
		tresseis=new Sampler("assets/tresseis.wav", 4, minim);

		tresuno.patch(out);
		tresdos.patch(out);
		trestres.patch(out);
		trescuatro.patch(out);
		trescinco.patch(out);
		tresseis.patch(out);








		//objects inicialize
		linea= new Linea(app);
		notas= new ArrayList<NotaR>();

//	  notasArray = new ArrayList<Notas>();
//	  user= new User();

	}

	public void pintar(){

//		  pintarNotas();
		//app.pushMatrix();
		//app.translate(540,0,2);
		pistaBase();
		pintarGraficos();
		// app.popMatrix();

//		  user.pintar();
//		  user.setPos(app.mouseX,app.mouseY);
//		  atrapar();

	}

	public void pistaBase(){

		if (app.millis() - time > interval ) {
			beats ++;
			s.trigger();
			linetime++;
			time = app.millis();
			if(beats==5){
				beats=1;
			}

			if(beats==3){
				k.trigger();
			}

			if(linetime==17){
				linetime=1;
			}

			if(linetime==9){
				h.trigger();
			}else if(linetime==1){
				h.trigger();
			}else if(linetime==4){
				h.trigger();
			}else if(linetime==12){
				h.trigger();
			}else if(linetime==14){
				h.trigger();
			}else if(linetime==16){
				h.trigger();
			}

			for(int i=0; i<notas.size(); i++){
				NotaR n= notas.get(i);
				n.sonar(linea.getPosY());
				if(n.sonar(linea.getPosY())){
					notas.remove(n);
				}

			}

		}
	}

		/*public void pintarGraficos(){
		  //graphics
		  app.fill(40);
		  app.rect(0,0, app.width, 200);

		  app.fill(255,0,0);
		  for(int i=0;i<interval;i++){
		    app.rectMode(app.CENTER);
		    app.rect(i*interval/4,100,8,200);
		  }


		  linea.pintar();
		  linea.mover(linetime, interval, beats);

		  for(int i=0; i<notas.size(); i++){
		    NotaR n= notas.get(i);
		    n.pintar();
		    n.sonar(linea.getPosX());
		  }
		}*/


	public void pintarGraficos(){//--------------------------------------------------------
		//graphics
		app.fill(255,80);
		app.rect(540,190, 305, app.height);

		app.fill(255,0,0);
		for(int i=0;i<interval;i++){
			//app.rectMode(app.CORNER);

			//app.rect(540,190+(i*interval/4),305,8);

		}

		linea.pintar();
		linea.mover(linetime, interval, beats);

		for(int i=0; i<notas.size(); i++){
			NotaR n= notas.get(i);
			n.pintar();
			n.sonar(linea.getPosY());
		}
	}




	@Override
	public void update(Observable o, Object arg) {

		if (arg instanceof String) {

			String m= (String)arg;
			String[] palabras=m.split(":");
			int ale= Integer.parseInt(palabras[1]);

			if (m.contains("suene uno")) {

				switch (ale){
					case 0:
						unoocho.trigger();
						break;
					case 1:
						unoocho.trigger();
						break;
					case 2:
						unodiez.trigger();
						break;
					case 3:
						unonueve.trigger();
						break;

					case 4:
						unodiez.trigger();
						break;

					case 5:
						unoocho.trigger();
						break;


				}

			}
			if (m.contains("suene dos")) {
				switch (ale){
					case 0:
						dosuno.trigger();
						break;
					case 1:
						dosuno.trigger();
						break;
					case 2:
						dosdos.trigger();
						break;
					case 3:
						dostres.trigger();
						break;

					case 4:
						doscuatro.trigger();
						break;

					case 5:
						doscinco.trigger();
						break;


				}

			}
			if (m.contains("suene tres")) {

				switch (ale){

					case 0:
						tresuno.trigger();
						break;

					case 1:
						tresdos.trigger();
						break;
					case 2:
						trestres.trigger();
						break;
					case 3:
						trescuatro.trigger();
						break;

					case 4:
						trescinco.trigger();
						break;

					case 5:
						tresseis.trigger();
						break;


				}

			}

		}
		if(sonar=true){


		}

	}


	public void agregar(float posX, float posY, int forma, int id){


		NotaR nr= new NotaR(posX, posY,app, interval, forma, id);
		nr.addObserver(this);
		notas.add(nr);

		// notas.add(new NotaR((eqs*(interval/4))-(interval/4)/2, 25));
		//println(eqs*(interval/4));

	}

	public AudioOutput getOut() {
		return out;
	}

	public void setOut(AudioOutput out) {
		this.out = out;
	}




}
