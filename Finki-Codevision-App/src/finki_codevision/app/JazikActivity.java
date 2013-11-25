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


public class JazikActivity extends Activity {
	
	private ListView lw;
	private ArrayList<Generic> lista;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jazik);
		
	     lista = dbQueryExecutor.getElements("PROG_LANG");
		 lw = (ListView) findViewById(R.id.ListaJazik);
		 if(lista!=null){
		 		GenericAdapter adapter = new GenericAdapter(this,lista);
		 		lw.setAdapter(adapter);
	     }
				
		 lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				Intent intent = new Intent(getApplicationContext(), PodatociJazik.class);
				intent.putExtra("ID",lista.get(arg2).getID());
				startActivity(intent);
			}
		 });
	}
}