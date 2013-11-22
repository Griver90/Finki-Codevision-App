package finki_codevision.app;

import java.util.ArrayList;

import finki_codevision.adapter.GenericAdapter;
import finki_codevision.classes.Generic;
import finki_codevision.db.dbQueryExecutor;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
public class PredmetActivity extends Activity {
	
	public ListView lw;
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_predmet);
		
		ArrayList<Generic> lista = dbQueryExecutor.getElements("COURSE");
		lw = (ListView) findViewById(R.id.ListaPredmeti);
		if(lista!=null){
			GenericAdapter adapter = new GenericAdapter(this,lista);
				lw.setAdapter(adapter);
			    }
				
		 lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Intent intent = new Intent(getApplicationContext(), PodatociActivity.class);
					startActivity(intent);
				}
			 });
			}
	}
