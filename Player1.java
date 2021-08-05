package C4.JavaGame;

public class Player1 {

	protected String nombre;
	protected boolean isCPU;
	
	public Player1 () {
	}
	
	public Player1 (String nombre, boolean isCPU) {
		this.nombre=nombre;
		this.isCPU=isCPU;
	}
	
	public String toString() {
		return "Player1 [nombre=" + nombre + ", isCPU=" + isCPU + "]";
	}
	
	
	
}
