package com.example.lettersectionlistsample;

import android.annotation.SuppressLint;
import com.tallan.lettersectionlist.LetterSectionListItem;

@SuppressLint("DefaultLocale") 
public class Book extends LetterSectionListItem{

	private int bookId;
	private String bookName;
	private String authorFirstName;
	private String authorLastName;
	private int pages;	
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public int getUniqueId() {
		return bookId;
	}

	@Override
	public void calculateSortString() {
		String sortString = "";

		if (bookName.toUpperCase().startsWith("THE ")) {
			sortString = bookName.toUpperCase().replaceFirst("THE ", "").trim();
		} else if (bookName.toUpperCase().startsWith("A ")) {
			sortString = bookName.toUpperCase().replaceFirst("A ", "").trim();
		} else {
			sortString = bookName.toUpperCase().trim();
		}
		
		sortString += (authorLastName.trim() + authorFirstName.trim());
		
		setSortString(sortString);
	}	
}
