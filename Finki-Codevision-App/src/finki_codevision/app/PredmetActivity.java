package finki_codevision.app;

import java.util.ArrayList;

import finki_codevision.adapter.GenericAdapter;
import finki_codevision.classes.Generic;
import finki_codevision.classes.Predmet;
import finki_codevision.db.dbQueryExecutor;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
public class PredmetActivity extends Activity {
	
	public ListView lw;
    private ArrayList<Generic> lista;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_predmet);
		
	    lista = dbQueryExecutor.getElements("COURSE");
		lw = (ListView) findViewById(R.id.ListaPredmeti);
		if(lista!=null){
			GenericAdapter adapter = new GenericAdapter(this,lista);
				lw.setAdapter(adapter);
			    }
		
		//prefrluvanje vo novo activity vo ko e sodrzat podatoci za kliknat predmet	
		
		 lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
					Intent intent = new Intent(getApplicationContext(), PodatociActivity.class);				
					intent.putExtra("description",((Predmet)(lista.get(position))).toString());
					startActivity(intent);
				}
			 });
		 
		 //prikazuvanje na dopolnitelni informacii za predmetot pri dolg klik na predmetot
		 
		 lw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View view,
						int position, long id) {
					Toast.makeText(PredmetActivity.this,((Predmet)lista.get(position)).getName() +
							" се слуша во " +((Predmet)lista.get(position)).getSemester() +
							" семестар", Toast.LENGTH_LONG).show();
					return true;
				}
			});
		 
			}
	}
