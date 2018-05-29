package com.cooksys.ftd.assignments.objects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

public class Launcher {
	public static void main(String[] args) throws JAXBException, DatatypeConfigurationException, IOException {
		marshallLibrary();
		generateXSD();
	}

	public static void marshallLibrary() throws JAXBException, DatatypeConfigurationException {
		Library library = new Library(new HashSet<Book>(), "The Official Library of Books", "That Place Where The Library Is",  new HashSet<Librarian>());
		Author thatGuy = new Author("That", "Guy");
		Author thatOtherGuy = new Author("That Other", "Guy");
		Author notThatGuy = new Author("Not That", "Guy");
		Author theGuy = new Author("The", "Guy");
		Author noTheOtherGirl = new Author("No, The Other", "Girl");
		ArrayList<Author> author1 = new ArrayList<Author>(Arrays.asList(thatGuy, theGuy));
		ArrayList<Author> author2 = new ArrayList<>(Arrays.asList(notThatGuy, thatOtherGuy));
		ArrayList<Author> author3 = new ArrayList<>(Arrays.asList(noTheOtherGirl, thatGuy, thatOtherGuy));
		System.out.println(author1.toString());
		library.getBooks().add(new Book("That Book", "Fantasy", DatatypeFactory.newInstance().newXMLGregorianCalendar(randomDate()), author1));
		library.getBooks().add(new Book("That Other Book", "SciFi", DatatypeFactory.newInstance().newXMLGregorianCalendar(randomDate()), author2));
		library.getBooks().add(new Book("Definite Not The First Book", "Nonfiction", DatatypeFactory.newInstance().newXMLGregorianCalendar(randomDate()), author3));
		library.getLibrarians().add(new Librarian("natedaag", 43, -200));
		library.getLibrarians().add(new Librarian("NOT natedaag", 21, 30000));
		JAXBContext context = JAXBContext.newInstance(Library.class);
		Marshaller marshaller = context.createMarshaller();	
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(library, new File("library.xml"));
	}
	
	public static GregorianCalendar randomDate() {

        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1900, 2010);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc;

    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

	public static void generateXSD() throws JAXBException, IOException {
		
		JAXBContext context = JAXBContext.newInstance(Library.class);
		
		context.generateSchema(new XSDGen());
	}
}
