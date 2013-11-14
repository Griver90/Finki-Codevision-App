package finki_codevision.app;

import java.util.ArrayList; 

import finki_codevision.adapter.GenericAdapter;
import finki_codevision.classes.Generic;
import finki_codevision.db.dbQueryExecutor;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class JazikActivity extends Activity {
	
	private ListView lw;
	GenericAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jazik);
		/*ArrayList<Generic> lista = dbQueryExecutor.getElements("PROG_LANG");
		lw = (ListView) findViewById(R.id.ListaJazik);
		if(lista!=null){
			adapter = new GenericAdapter(this,lista);
				for (int i = 0; i < lista.size(); i++) {
			        adapter.add(lista.get(i));
			        
				}
			
			}
		lw.setAdapter(adapter);*/
		
		ArrayList<Generic> lista = dbQueryExecutor.getElements("PROG_LANG");
		lw = (ListView) findViewById(R.id.ListaJazik);
		if(lista!=null){
				GenericAdapter adapter = new GenericAdapter(this,lista);
				lw.setAdapter(adapter);
			    }
			
			}
	}