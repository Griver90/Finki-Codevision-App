package finki_codevision.classes;

public class Jazik extends Generic{

		public String lang_name;
		
		public Jazik(){};
		public Jazik(String ID){super(ID);}
		public Jazik(String lang_name,String ID)
		{
			super(ID);
			this.lang_name=lang_name;
		}
		//Setter
		public void setJazik(String lang_name){this.lang_name=lang_name;}
		//toString()
		public String toString(){return lang_name;}
		//Getter
		public String getLangName(){return lang_name;}
		public String getName(){return lang_name;}
}
