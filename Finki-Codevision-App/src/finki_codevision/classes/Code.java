package finki_codevision.classes;

public class Code extends Generic{

	private String Title,description,numPages,lang_id;
	
	public Code(String ID) {super(ID);}
	public Code(){}
	public Code(String Title, String description, String numPages,String lan_id,String ID){
		super(ID);
		this.Title = Title;
		this.description=description;
		this.numPages=numPages;
		this.lang_id = lan_id;
	}
	
	
	public String toString(){
		return Title+" "+description;
	}
	
	public void setTitle(String Title){this.Title = Title;}
	public void setDescription(String description){this.description = description;}
}
