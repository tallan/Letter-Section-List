package com.example.lettersectionlistsample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.tallan.lettersectionlist.LetterSectionListAdapter;
import com.tallan.lettersectionlist.LetterSectionListItem;
import com.tallan.lettersectionlist.LetterSectionListItemComparator;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        createBookList();
    }    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void createBookList(){
        List<LetterSectionListItem> books = createBooks();
        
        //Find the list view in my activity
        ListView bookListView = (ListView) findViewById(R.id.booklistview);
                
        //Using custom booklist_row view that the header will be wrapped around
		LetterSectionListAdapter bookListAdapter = new LetterSectionListAdapter(this, R.layout.booklist_row, books) {			
			@Override
			public View getView(int position, View v, ViewGroup parent) {	
				//Must call this before to wrap the header around the view
				v = super.getView(position, v, parent);
				
				TextView bookTitle = (TextView) v.findViewById(R.id.book_title);
				TextView authorName = (TextView) v.findViewById(R.id.author_name);
				
				Book book = (Book) this.getItem(position);
				
				bookTitle.setText(book.getBookName());
				authorName.setText(book.getAuthorLastName() + ", " + book.getAuthorFirstName());
				
				return v;
			}
		};	
               
        bookListView.setAdapter(bookListAdapter);
    }
    
    
    private List<LetterSectionListItem> createBooks(){
    	List<LetterSectionListItem> books = new ArrayList<LetterSectionListItem>();
    	
    	books.add(new Book(){{
    		setBookId(1);
        	setBookName("Duty");
        	setAuthorFirstName("Robert");
        	setAuthorLastName("Gates");
    	}});
    	books.add(new Book(){{
    		setBookId(2);
        	setBookName("A Short Guide to a Long Life");
        	setAuthorFirstName("David");
        	setAuthorLastName("Agus");
    	}});
    	books.add(new Book(){{
    		setBookId(3);
        	setBookName("The Fault in Our Stars");
        	setAuthorFirstName("John");
        	setAuthorLastName("Green");
    	}});
    	books.add(new Book(){{
    		setBookId(4);
        	setBookName("Lone Survivor");
        	setAuthorFirstName("Marcus");
        	setAuthorLastName("Luttrell");
    	}});
    	books.add(new Book(){{
    		setBookId(5);
        	setBookName("Divergent Series Complete Box Set");
        	setAuthorFirstName("Veronica");
        	setAuthorLastName("Roth");
    	}});
    	books.add(new Book(){{
    		setBookId(6);
        	setBookName("S.");
        	setAuthorFirstName("J.J.");
        	setAuthorLastName("Adams");
    	}});
    	books.add(new Book(){{
    		setBookId(7);
        	setBookName("The Invention of Wings");
        	setAuthorFirstName("Sue Monk");
        	setAuthorLastName("Kidd");
    	}});
    	books.add(new Book(){{
    		setBookId(8);
        	setBookName("Hollow City");
        	setAuthorFirstName("Ransom");
        	setAuthorLastName("Riggs");
    	}});
    	books.add(new Book(){{
    		setBookId(9);
        	setBookName("The Goldfinch");
        	setAuthorFirstName("Donna");
        	setAuthorLastName("Tartt");
    	}});
    	books.add(new Book(){{
    		setBookId(10);
        	setBookName("The Book Thief");
        	setAuthorFirstName("Markus");
        	setAuthorLastName("Zusak");
    	}});
    	books.add(new Book(){{
    		setBookId(11);
        	setBookName("The Body Book");
        	setAuthorFirstName("Cameron");
        	setAuthorLastName("Diaz");
    	}});
    	books.add(new Book(){{
    		setBookId(12);
        	setBookName("Gone Girl");
        	setAuthorFirstName("Gillian");
        	setAuthorLastName("Flynn");
    	}});
    	
    	for (LetterSectionListItem book : books) {
			book.calculateSortString();
		}
    	
    	return books;
    }
    
}
