package finki_codevision.app;

import java.util.ArrayList;

import finki_codevision.classes.Generic;
import finki_codevision.db.dbQueryExecutor;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
				ArrayAdapter<Generic> adapter = new ArrayAdapter<Generic>(this,android.R.layout.simple_list_item_1);
				for (int i = 0; i < lista.size(); i++) {
			        adapter.add(lista.get(i));
			    }
				lw.setAdapter(adapter);
			}
	}
}
