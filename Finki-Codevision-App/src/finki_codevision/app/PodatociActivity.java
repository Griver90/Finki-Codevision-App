package finki_codevision.app;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class PodatociActivity extends Activity {
	

	TextView tv,tv2;
	String text,code;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_podatoci);
		populateViews();
	}
	
	@Override
	public Object onRetainNonConfigurationInstance() {
	    final String[] asd = {text,code};
	    return asd;
	}
	public void populateViews(){
		Bundle extras;			
		extras = getIntent().getExtras();
		final Object obj = getLastNonConfigurationInstance();
		if(obj==null){
				if(extras!=null){
					text = extras.getString("description");
					code = extras.getString("CODE");
				}
				else{
					text = "Ups Greska";
					code = "Something went wrong";
				}
		}
		else{
			String[] asd = (String[]) obj;
			text = asd[0];
			code = asd[1];
		}
		
		tv = (TextView) findViewById(R.id.txt);
		tv.setText(text);
		tv2 = (TextView) findViewById(R.id.theCode);
		tv2.setText(code);
	}
}

