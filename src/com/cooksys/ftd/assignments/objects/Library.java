package com.cooksys.ftd.assignments.objects;

import java.util.HashMap;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {
	@XmlElementWrapper
	@XmlElement(name = "book")
	private HashSet<Book> books;
	@XmlAttribute(name ="name")
	private String libraryName;
	@XmlAttribute
	private String address;
	@XmlElementWrapper
	@XmlElement(name = "librarian")
	private HashSet<Librarian> librarians;
	public Library() {}
	public Library(HashSet<Book> books, String libraryName,String address, HashSet<Librarian> librarians) {
		this.books = books;
		this.libraryName = libraryName;
		this.address = address;
		this.librarians = librarians;
	}
	public HashSet<Book> getBooks() {
		return books;
	}
	public void setBooks(HashSet<Book> books) {
		this.books = books;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public HashSet<Librarian> getLibrarians() {
		return librarians;
	}
	public void setLibrarians(HashSet<Librarian> librarians) {
		this.librarians = librarians;
	}
	
}
