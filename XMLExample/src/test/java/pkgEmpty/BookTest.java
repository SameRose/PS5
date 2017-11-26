
package pkgEmpty;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

import pkgLibrary.Book;
import pkgLibrary.BookException;

import org.junit.Test;

public class BookTest {

	@Test
	public void testGetBook() throws BookException {
		Book b = Book.getBook("bk103");
		
		assertEquals(b.getTitle(), "Maeve Ascendant");
		
	}
	
	
	
	@Test
	
	public void testBookExceptionGetBook() {
		
	   try {
		Book b = Book.getBook("bk301");
		fail("error not thrown");
	   }
	   catch(BookException e) {
		   System.out.println(e.getMessage());
		   
	   }
	  
	
	    
	}

	@Test
	public void testAddBook() throws BookException, ParseException {
		
		Book b = new Book();
		b.setAuthor("Eoin Colfer");
		b.setTitle("Artemis Fowl");
		b.setGenre("Fantasy");
		b.setDescription("A young criminal genius kidnapps a fairy");
		b.setId("bk308");
		

		String inputString = "04-26-2001";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = dateFormat.parse(inputString);
		
		b.setPublish_date(inputDate);
		
		b.setPrice(9.99);
		
		Book.addBook("catID", b);
		
		Book test = Book.getBook("bk300");
		
		
		assertEquals(test.getTitle(), "Artemis Fowl");
		
	}
	
	@Test
	
	public void testBookExceptionAddBook() throws ParseException {
	   try {
		Book b = new Book();
		b.setAuthor("Eoin Colfer");
		b.setTitle("Artemis Fowl");
		b.setGenre("Fantasy");
		b.setDescription("A young criminal genius kidnapps a fairy");
		b.setId("bk300");
		

		String inputString = "04-26-2001";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = dateFormat.parse(inputString);
		
		b.setPublish_date(inputDate);
		
		b.setPrice(9.99);
		
		Book.addBook("catID", b);
		Book.addBook("catID", b);
		fail("error not thrown");
		}
	   
	   catch(Exception e){
		   
	   }
		
		
	    
	}
	
	
}
