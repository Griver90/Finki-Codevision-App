package finki_codevision.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void startPredmetActivity(View view){
		Intent intent = new Intent(this, PredmetActivity.class);
		startActivity(intent);
	}
	
	public void startJazikActivity(View view){
		Intent intent = new Intent(this, JazikActivity.class);
		startActivity(intent);
	}

	public void startKodActivity(View view){
		Intent intent = new Intent(this,KodActivity.class);
		startActivity(intent);
	}
	
}
