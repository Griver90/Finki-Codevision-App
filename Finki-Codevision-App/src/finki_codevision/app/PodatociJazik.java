package finki_codevision.app;

import java.util.ArrayList;

import finki_codevision.adapter.GenericAdapter;
import finki_codevision.classes.Code;
import finki_codevision.classes.Generic;
import finki_codevision.db.dbQueryExecutor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class PodatociJazik extends Activity {

	TextView tv;
	ListView lw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_podatoci_jazik);
		Bundle extras;
		String ID;
		lw = (ListView) findViewById(R.id.PodatociJazikLista);
		tv = (TextView) findViewById(R.id.PodatociJazikHeaderText);
		final ArrayList<Generic> lista = new ArrayList<Generic>();
		ArrayList<Generic> lista1 = new ArrayList<Generic>();
		try{
			extras= getIntent().getExtras();
			ID = extras.getString("ID");
			lista1 = dbQueryExecutor.getElements("CODE");
			tv.setText("The following Codes found for Language with ID "+ID);
			if(lista1!=null && ID!=null){
				for(Generic g : lista1){
					if(((Code)g).getLangID().equals(ID)){
						lista.add(g);
					}
				}
				if(lista!=null){
					GenericAdapter adapter = new GenericAdapter(this,lista);
					lw.setAdapter(adapter);
				}
				lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
						Intent intent = new Intent(getApplicationContext(), PodatociActivity.class);
						intent.putExtra("description",((Code)(lista.get(arg2))).getDescription());
						startActivity(intent);
					}});
			}
			else{
				tv.setText(ID+" "+lista);
			}
			
		}
		catch(Exception ex){
				tv.setText(ex.toString());
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.podatoci_jazik, menu);
		return true;
	}

}
