package Main;



public class Main {
	
	Menu menu;

	public Main(){
		
		menu =  new Menu(this);
		menu.setVisible(true);
	}

	public static void main(String[] args) {
		
		new Main();
	}

}

