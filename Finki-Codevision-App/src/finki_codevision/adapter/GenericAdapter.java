package finki_codevision.adapter;

import java.util.ArrayList;

import finki_codevision.app.R;
import finki_codevision.classes.Generic;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GenericAdapter extends BaseAdapter{
	
	private Context cnt;
	private ArrayList<Generic> lista;
	
	static class ViewHolder{
		public TextView txt;
		public TextView txt1;
		public ImageView img;
	}
	
	
	public GenericAdapter(Context cnt,ArrayList<Generic> lista){
		
		this.cnt= cnt;
		this.lista = lista;
	}

	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	public void add(Generic g){
		lista.add(g);
		notifyDataSetChanged();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		if(rowView==null){
			 LayoutInflater inflater =(LayoutInflater) cnt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		      rowView = inflater.inflate(R.layout.list_layout_jazik, null);
		      ViewHolder viewholder = new ViewHolder();
		      
		      viewholder.txt = (TextView) rowView.findViewById(R.id.txt1);
		      viewholder.txt1 = (TextView) rowView.findViewById(R.id.txt2);
		      viewholder.img = (ImageView) rowView.findViewById(R.id.img);
		      
		      if(position % 2 == 0){
		    	  rowView.setBackgroundResource(R.drawable.lista_selector_paren); 
		    	  viewholder.txt.setBackgroundResource(R.drawable.lista_selector_paren);
		    	  viewholder.txt1.setBackgroundResource(R.drawable.lista_selector_paren);
		    	  viewholder.img.setBackgroundResource(R.drawable.lista_selector_paren);
		      }else{
		    	  rowView.setBackgroundResource(R.drawable.lista_selector_neparen); 
		    	  viewholder.txt.setBackgroundResource(R.drawable.lista_selector_neparen);
		    	  viewholder.txt1.setBackgroundResource(R.drawable.lista_selector_neparen);
		    	  viewholder.img.setBackgroundResource(R.drawable.lista_selector_neparen);
		      }
		      
		      rowView.setTag(viewholder);
		      
		      
		      
		  
		}
		ViewHolder Holder = (ViewHolder) rowView.getTag();
		Holder.txt.setText(lista.get(position).getID()) ;
		Holder.txt1.setText(lista.get(position).toString());
		Holder.img.setImageResource(R.drawable.arrow);
		
		return rowView;
	}
	
}
