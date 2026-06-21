package secondHometask;

import java.util.List;
import java.util.Objects;

public class Student {

    private final String name;
    private final String group;
    private final List<Book> books;

    public Student(String name, String group, List<Book> books) {
        this.name = name;
        this.group = group;
        this.books = books;
        validate();
    }

    public void validate() {
        if (books == null || books.size() < 5) {
            throw new IllegalArgumentException(
                    "У студента " + name + " должно быть минимум 5 книг, передано: " +
                            (books == null ? 0 : books.size()));
        }
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', group='" + group +
                "', booksCount=" + books.size() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }
}
