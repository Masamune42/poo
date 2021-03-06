package fr.eni.authorbook.launcher;

import fr.eni.authorbook.model.Book;

import fr.eni.authorbook.model.Author;

public class Launcher {
	public static void main(String[] args) {
		Author anAuthor = new Author("Tan Ah Teck", "ahteck@womehere.com", 'm');
		Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);
		// Use an anonymous instance of Author
		Book anotherBook = new Book("Blame!", new Author("Nihei Tsutomu", "nihei@h.com", 'm'), 29.95, 888);
		
		System.out.println(anotherBook.getName());
		System.out.println(anotherBook.getPrice());
		System.out.println(anotherBook.getQtyInStock());
		
		System.out.println(anotherBook.getAuthor().getName());
		System.out.println(anotherBook.getAuthor().getEmail());
		System.out.println(anotherBook.getAuthor().getGender());
		
		System.out.println(anotherBook.getAuthor());
		System.out.println(anotherBook);
	}
}
