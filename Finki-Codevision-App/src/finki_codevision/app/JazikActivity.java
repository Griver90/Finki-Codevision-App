package finki_codevision.app;

import java.util.ArrayList; 

import finki_codevision.classes.Generic;
import finki_codevision.db.dbQueryExecutor;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class JazikActivity extends Activity {
	
	private ListView lw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jazik);
		ArrayList<Generic> lista = dbQueryExecutor.getElements("PROG_LANG");
		lw = (ListView) findViewById(R.id.ListaJazik);
		if(lista!=null){
				ArrayAdapter<Generic> adapter = new ArrayAdapter<Generic>(this,android.R.layout.simple_list_item_1);
				for (int i = 0; i < lista.size(); i++) {
			        adapter.add(lista.get(i));
			    }
				lw.setAdapter(adapter);
			}
	}
}