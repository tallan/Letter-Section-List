
package com.tallan.lettersectionlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.letterheaderlist.R;


public class LetterSectionListAdapter extends ArrayAdapter<LetterSectionListItem>{

	private int resource;
	
	public LetterSectionListAdapter(Context context, int resource, List<LetterSectionListItem> items) {
		super(context, R.layout.item_row, items);
		this.resource = resource;
	}
	
	@Override
	public View getView(int position, View v, ViewGroup parent) {
		LetterSectionListItem item = getItem(position);
		
		LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		LinearLayout headerLayout;
		if(v == null){
			headerLayout = (LinearLayout) vi.inflate(R.layout.item_row, null);		
			View innerLayout = vi.inflate(resource, null);
			headerLayout.addView(innerLayout);			
		}
		
		else headerLayout = (LinearLayout) v;
		
		TextView headerLetterTextView = (TextView) headerLayout.findViewById(R.id.item_row_letter);
		headerLetterTextView.setText(item.getSortString().substring(0, 1));
		headerLetterTextView.setVisibility(isFirstOfLetterGroup(item) ? View.VISIBLE : View.GONE);		
		
		return headerLayout;
	}
	
	private boolean isFirstOfLetterGroup(LetterSectionListItem currentItem) {
		ArrayList<LetterSectionListItem> group = new ArrayList<LetterSectionListItem>();

		for (int i = 0; i < getCount(); i++) {
			if (getItem(i).getSortString().charAt(0) == currentItem.getSortString().charAt(0))
				group.add(getItem(i));
			
		}		

		Collections.sort(group, new LetterSectionListItemComparator());

		if (group.get(0).getUniqueId() == currentItem.getUniqueId())
			return true;

		return false;
	}
}
