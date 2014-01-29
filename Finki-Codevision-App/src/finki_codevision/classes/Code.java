package finki_codevision.classes;

public class Code extends Generic{

	private String Title,description,numPages,lang_id,codeData;
	
	public Code(){}
	public Code(String ID) {super(ID);}
	public Code(String Title, String description, String numPages,String lan_id,String ID, String codeData){
		super(ID);
		this.Title = Title;
		this.description=description;
		this.numPages=numPages;
		this.lang_id = lan_id;
		this.codeData = codeData;
	}
	//Setter
	public void setTitle(String Title){this.Title = Title;}
	public void setDescription(String description){this.description = description;}
	//toString()
	public String toString(){return codeData;}
	//Getter
	public String getName(){return Title;}
	public String getTitle(){return Title;}
	public String getDescription(){return description;}
	public String getNumPages(){return numPages;}
	public String getLangID(){return lang_id;}
}
