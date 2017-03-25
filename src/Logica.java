import java.util.ArrayList;

import TUIO.TuioObject;
import TUIO.TuioProcessing;
import processing.core.PApplet;
import processing.core.PConstants;

public class Logica {
	// Applet
	private PApplet app;

	// Atributos
	private boolean poblar;
	private int count;
	TuioProcessing tuioClient;
	// Relaciones
	private ReactVision react;
	private ArrayList<Notas> notasArray;
	private ArrayList<User> users;

	// Constructor
	public Logica(PApplet _app) {
		// Se entrega PApplet
		app = _app;

		// Se llama metodo para inicializar el resto de componentes
		init();
	}

	// Metodo Para Inicializar variables
	private void init() {
		react = new ReactVision(app);
		notasArray = new ArrayList<Notas>();
		users = new ArrayList<User>();
		count = 0;
		poblar = false;
	}

	public void pintar() {
		react.pintar();
		checkBlobs();
		atrapar();
		pintarNotas();
		pintarUsuarios();
	}

	public void pintarNotas() {

		if (count < app.millis()) {
			poblar = true;
			count = count + 4000;
		}
		if (poblar) {
			repoblar();
			poblar = false;
		}

		for (int i = 0; i < notasArray.size(); i++) {
			notasArray.get(i).pintar();
			notasArray.get(i).mover();
		}
	}

	public void pintarUsuarios() {
		// Validar que Users no este Vacio
		if (users != null && !users.isEmpty()) {

			// Recorre el arreglo de usuarios y los pinta
			for (int i = 0; i < users.size(); i++) {
				users.get(i).pintar();
			}
		}
	}

	public void atrapar() {
		for (int i = 0; i < notasArray.size(); i++) {
			Notas n = notasArray.get(i);
			for (int j = 0; j < users.size(); j++) {
				if (app.dist(n.getPos().x, n.getPos().y, users.get(j).getPos().x, users.get(j).getPos().y) < 100 / 2) {
					notasArray.remove(n);
				}
			}

		}
	}

	public void repoblar() {
		for (int i = 0; i < 8; i++) {
			notasArray.add(new Notas(app));
		}
	}

	public void checkBlobs() {
		//System.out.println("Checking Blobs");
		System.out.println(react.getReactObjects().size());
		for (int i = 0; i < react.getReactObjects().size(); i++) {
			TuioObject tempObj = react.getReactObjects().get(i);
			System.out.println("Blob Fetched");
			if(react.getReactObjects().size()>users.size()){
				User tempUser = new User(app, tempObj.getScreenX(app.width), tempObj.getScreenY(app.height), tempObj.getSymbolID());
				users.add(tempUser);
				System.out.println("New User Added");
			}
			if (users != null && !users.isEmpty()) {
				
				for (int j = 0; j < users.size(); j++) {
					User userTemp = users.get(j);
					if(userTemp.getId() == tempObj.getSymbolID()){
						System.out.println("Blob and User Identified");
						userTemp.setPos(tempObj.getScreenX(app.width), tempObj.getScreenY(app.height));
						userTemp.pintar();
					}
				}
				
			}
		}

	}

}
