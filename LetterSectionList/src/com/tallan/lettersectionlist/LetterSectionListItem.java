package com.tallan.lettersectionlist;

public abstract class LetterSectionListItem {
	
	private String sortString;	

	public abstract int getUniqueId();
	public abstract void calculateSortString();	
	
	public String getSortString(){
		return sortString;
	}
	
	public void setSortString(String s){
		sortString = s;
	}
	
}
