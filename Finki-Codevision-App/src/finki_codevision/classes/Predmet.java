package finki_codevision.classes;

public class Predmet extends Generic{
	
	private String name, semester, description;
	
	public Predmet(){}
	public Predmet(String ID){super(ID);}
	public Predmet(String name, String semester, String description, String ID){
		super(ID);
		this.name = name;
		this.semester=semester;
		this.description=description;
	}
	//Setter
	public void setName(String name){this.name =name;}
	public void setSemester(String semester){this.semester=semester;}
	public void setDescription(String description){this.description=description;}
	//toString()
	public String toString(){return name+" "+semester+"\n"+description;}
	//Getter
	public String getName(){return name;}
	public String getSemester(){return semester;}
	public String getDescription(){return description;}
}
