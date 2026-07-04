package secondHometask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Student> students = readStudents("/students.json");

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
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Книга, подходящая под условия, отсутствует")
                );
    }

    private static List<Student> readStudents(String resourcePath) throws IOException {
        String content;
        try (InputStream inputStream = Main.class.getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IOException("Файл не найден на classpath: " + resourcePath);
            }
            content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }

        Type studentListType = new TypeToken<List<Student>>() {
        }.getType();
        List<Student> students = new Gson().fromJson(content, studentListType);

        students.forEach(Student::validate);

        return students;
    }
}