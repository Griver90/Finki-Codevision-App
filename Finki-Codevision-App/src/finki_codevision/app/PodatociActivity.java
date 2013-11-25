package finki_codevision.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class PodatociActivity extends Activity {
	

	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_podatoci);
		String text;
		Bundle extras;
		if(savedInstanceState==null){
			
			extras = getIntent().getExtras();
			if(extras!=null){
				text = extras.getString("description");
			}
			else{
				text = "Nema Extra";
			}
		}
		else {
			text = "Nema SavedInstanceState";
		}
		
		tv = (TextView) findViewById(R.id.txt);
		tv.setText(text);
	}
}

