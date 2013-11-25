package finki_codevision.classes;

public abstract class Generic{

	private String ID;
	
	public Generic(String ID){this.ID = ID;}
	public Generic(){}
	public String getID(){return ID;}
	public abstract String toString();
	public abstract String getName();
}
