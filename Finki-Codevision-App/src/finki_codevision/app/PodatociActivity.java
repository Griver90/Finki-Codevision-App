package finki_codevision.app;

import java.util.ArrayList;


import finki_codevision.classes.Predmet;

import android.app.Activity;
import android.os.Bundle;


public class PodatociActivity extends Activity {
	

	ArrayList<Predmet> p;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_podatoci);

		}
}

