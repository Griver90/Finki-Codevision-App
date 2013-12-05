package finki_codevision.app;

import java.util.ArrayList;

import finki_codevision.adapter.GenericAdapter;
import finki_codevision.classes.Code;
import finki_codevision.classes.Generic;
import finki_codevision.db.dbQueryExecutor;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class KodActivity extends Activity {
	
	public ListView lw;
	private ArrayList<Generic> lista;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kod);
		
		lista = dbQueryExecutor.getElements("CODE");
		lw = (ListView) findViewById(R.id.ListaKod);
		if(lista!=null){
			GenericAdapter adapter = new GenericAdapter(this,lista);
			lw.setAdapter(adapter);
	    }
		
		//prefrluvanje vo novo activity so celosen kod 
		 lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
					Intent intent = new Intent(getApplicationContext(), PodatociActivity.class);
					intent.putExtra("description",((Code)(lista.get(position))).getDescription());
					startActivity(intent);
				}
			 });		
		
		 
		 lw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View view,
						int position, long id) {
					Toast.makeText(KodActivity.this,((Code)lista.get(position)).getName(), Toast.LENGTH_LONG).show();
					return true;
				}
			});
		
			}
	}
