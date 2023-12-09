class Item {
    private String name;
    private String type;
    private String expirationDate;

    public Item(String name, String type, String expirationDate) {
        this.name = name;
        this.type = type;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
