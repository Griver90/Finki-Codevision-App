package finki_codevision.app;

import java.util.ArrayList;

import finki_codevision.classes.Code;
import finki_codevision.db.dbConnectionHelper;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class JazikActivity extends Activity {
	
	private ListView lw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jazik);
		ArrayList<Code> lista = dbConnectionHelper.getConnection();
		lw = (ListView) findViewById(R.id.ListaJazik);
		if(lista!=null){
				ArrayAdapter<Code> adapter = new ArrayAdapter<Code>(this,android.R.layout.simple_list_item_1);
				for (int i = 0; i < lista.size(); i++) {
			        adapter.add(lista.get(i));
			    }
				lw.setAdapter(adapter);
			}
	}
}