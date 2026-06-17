package week1;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {
    private final int id;
    private final List<String> mutableList;

    @SuppressWarnings("unchecked")
    public ImmutableClass(int id, List<String> mutableList) {
        this.id = id;

        if (mutableList == null) {
            this.mutableList = new ArrayList<>();
        } else if (mutableList instanceof ArrayList) {
            this.mutableList = (List<String>) ((ArrayList<String>) mutableList).clone();
        } else {
            this.mutableList = new ArrayList<>(mutableList);
        }
    }

    public int getId() {
        return this.id;
    }

    public List<String> getMutableList() {
        return List.copyOf(this.mutableList);
    }
}
