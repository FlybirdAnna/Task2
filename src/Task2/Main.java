package Task2;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Ann", Arrays.asList(
                        new Book("Harry Potter and the Goblet of Fire", 2005, 636),
                        new Book("The Lord of the Rings", 1955, 1200),
                        new Book("Bridget Jones's Diary", 1996 , 589),
                        new Book("A Song of Ice and Fire", 1991 , 500),
                        new Book("The Corrections", 2015, 350))),
                new Student("Nick", Arrays.asList(
                        new Book("The Amazing Adventures of Cavalier & Clay", 2015, 660),
                        new Book("Bridget Jones: The Edge of Reason", 2015, 700),
                        new Book("Girl with a Pearl Earring", 2011, 520),
                        new Book("High Fidelity", 2007, 320),
                        new Book("The Master and Margarita", 1900, 400))),
                new Student("Tom", Arrays.asList(
                        new Book("The Heart is a Lonely Hunter", 2002, 352),
                        new Book("The Notebook", 2022, 272),
                        new Book("Timeline", 2010, 464 ),
                        new Book("Hannibal", 2007, 432),
                        new Book("A Long Petal of the Sea", 2000, 384 )))
        );

         students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска книги: " + year),
                        () -> System.out.println("Книга не найдена")
                );
    }
}