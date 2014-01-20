package finki_codevision.adapter;

import java.util.HashMap;
import java.util.List;
import finki_codevision.app.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

	
	private Context cnt;
	private HashMap<String, List<String>> JazikCollection;
	private List<String> listajazik;
	
	static class ViewHolder{
		public TextView lblListHeader;
		public TextView txtListChild;
	}
	
	public ExpandableListAdapter(Context cnt,HashMap<String, List<String>> JazikCollection,List<String> listajazik){
		this.cnt = cnt;
		this.JazikCollection = JazikCollection;
		this.listajazik = listajazik;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return this.JazikCollection.get(this.listajazik.get(groupPosition)).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		
		final String childText = (String) getChild(groupPosition, childPosition);
		 
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.cnt
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.jazik_list_item, null);
            
            ViewHolder viewholder = new ViewHolder();
            
            viewholder.txtListChild = (TextView) convertView.findViewById(R.id.ListItem);
            
            convertView.setTag(viewholder);
            
        }
        ViewHolder Holder = (ViewHolder) convertView.getTag();
		Holder.txtListChild.setText(childText) ;
        
        
        return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		
		return this.JazikCollection.get(this.listajazik.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		
		return this.listajazik.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		
		return this.listajazik.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		
		 String headerTitle = (String) getGroup(groupPosition);
	        if (convertView == null) {
	            LayoutInflater infalInflater = (LayoutInflater) this.cnt
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = infalInflater.inflate(R.layout.jazik_list_group, null);
	            
	            ViewHolder viewholder = new ViewHolder();

			      viewholder.lblListHeader = (TextView) convertView.findViewById(R.id.ListGroup);
			      
			      convertView.setTag(viewholder);

	        }
	        
	        ViewHolder Holder = (ViewHolder) convertView.getTag();
			Holder.lblListHeader.setText(headerTitle) ;

	        return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
}
