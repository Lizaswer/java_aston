import java.util.ArrayList;
import java.util.List;

public record ImmutableWithMutableFieldCollection(int id, List<String> mutableList) {
    public ImmutableWithMutableFieldCollection(int id, List<String> mutableList) {
        this.id = id;
        this.mutableList = new ArrayList<>(mutableList);
    }

    @Override
    public List<String> mutableList() {
        return new ArrayList<>(mutableList);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");

        ImmutableWithMutableFieldCollection obj = new ImmutableWithMutableFieldCollection(1, list);
        System.out.println("id" + obj.id());
        System.out.println("list" + obj.mutableList());

        List<String> retrievedList = obj.mutableList();
        retrievedList.add("item3");
        System.out.println("retrievedList" + retrievedList);

        System.out.println("Result:");
        System.out.println(obj.mutableList());
    }
}
