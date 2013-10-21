package finki_codevision.app;

import finki_codevision_db.dbConnectionHelper;
import android.app.Activity;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class JazikActivity extends Activity {
	
	private TextView lw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jazik);
		
		lw = (TextView) findViewById(R.id.txtProverka);
		lw.setText(dbConnectionHelper.getConnection() +"") ;
	}
}
