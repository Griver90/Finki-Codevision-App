package finki_codevision.app;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(!isOnline()){
			Button b = (Button) findViewById(R.id.IzberiJazikbtn);
			b.setVisibility(View.GONE);
			b.setClickable(false);
			b = (Button) findViewById(R.id.IzberiKodbtn);
			b.setVisibility(View.GONE);
			b.setClickable(false);
			b = (Button) findViewById(R.id.IzberiPredmetbtn);
			b.setVisibility(View.GONE);
			b.setClickable(false);

			TextView t = (TextView) findViewById(R.id.NoInternetBody);
			t.setVisibility(View.VISIBLE);	
			b = (Button) findViewById(R.id.Reload);
			b.setVisibility(View.VISIBLE);
			b.setClickable(true);
			t = (TextView) findViewById(R.id.NoInternetHeader);
			t.setVisibility(View.VISIBLE);
		}
		
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
	
	public void Refresh(View view){
		finish();
		startActivity(getIntent());
	}
	
	public boolean isOnline() {
	    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
	}
	
}
