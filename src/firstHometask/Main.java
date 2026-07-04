package firstHometask;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> originalList = new ArrayList<>();
        originalList.add("item1");
        originalList.add("item2");

        ImmutableClass obj1 = new ImmutableClass(1, originalList);

        originalList.add("item3");

        System.out.println("Список в объекте 1: " + obj1.getMutableList());

        ImmutableClass obj2 = new ImmutableClass(2, null);
        System.out.println("Список в объекте 2 (обработан null): " + obj2.getMutableList());
    }
}
