package finki_codevision.app;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;

import finki_codevision.adapter.ExpandableListAdapter;
import finki_codevision.classes.Code;
import finki_codevision.classes.Generic;

import finki_codevision.db.dbQueryExecutor;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import android.widget.ExpandableListView.OnChildClickListener;



public class JazikActivity extends Activity {
	
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	

	private ArrayList<Generic> lista,lista1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jazik);
		
	     lista = dbQueryExecutor.getElements("PROG_LANG");
	     lista1 = dbQueryExecutor.getElements("CODE");
	     prepareListData(lista,lista1);
		 expListView = (ExpandableListView) findViewById(R.id.ListaJazik);
		
		listAdapter = new ExpandableListAdapter(this, listDataChild, listDataHeader );
		
		expListView.setAdapter(listAdapter);

		
		expListView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				Intent intent = new Intent(getApplicationContext(), PodatociActivity.class);
				intent.putExtra("description",((Code)(lista1.get(childPosition))).getDescription());
				startActivity(intent);
				
				return true;
			}
		});	 
	}
	
	private void prepareListData(ArrayList<Generic> list,ArrayList<Generic> list1) {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        List<String> dete; 
        
        // Adding child data
        for(int i=0;i<list.size();i++){
        	listDataHeader.add(list.get(i).toString());
        	dete = new ArrayList<String>();
        	for(int j=0;j<list1.size();j++){
        		if((list.get(i).getID()).equals(((Code)list1.get(j)).getLangID())){
        			dete.add(list1.get(j).getName());	
        		}
        	}
        	listDataChild.put(listDataHeader.get(i),dete);
	
        } 
 
    }
	
	
}