package finki_codevision.classes;

public class Code extends Generic{

	private String Title,description,numPages,lang_id;
	
	public Code(){}
	public Code(String ID) {super(ID);}
	public Code(String Title, String description, String numPages,String lan_id,String ID){
		super(ID);
		this.Title = Title;
		this.description=description;
		this.numPages=numPages;
		this.lang_id = lan_id;
	}
	//Setter
	public void setTitle(String Title){this.Title = Title;}
	public void setDescription(String description){this.description = description;}
	//toString()
	public String toString(){return Title+" "+description;}
	//Getter
	public String getName(){return Title;}
	public String getTitle(){return Title;}
	public String getDescription(){return description;}
	public String getNumPages(){return numPages;}
	public String getLangID(){return lang_id;}
}
