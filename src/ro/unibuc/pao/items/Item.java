package ro.unibuc.pao.items;

public class Item implements UsableItem {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void use() {
        System.out.println("Using item: " + name);
    }
}
