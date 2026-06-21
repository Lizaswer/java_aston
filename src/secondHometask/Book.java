package secondHometask;

import java.util.Objects;

public class Book {
    private final  String title;
    private final  String author;
    private final int year;
    private final int pages;

    public Book(String title, String author, int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public int getPages() {
        return pages;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return year == book.year
                && pages == book.pages
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, pages);
    }
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author +
                "', year=" + year + ", pages=" + pages + '}';
    }
}



