public enum Status {
    NEW("new"),
    IN_PROGRESS("in progress"),
    DONE("done"),
    ARCHIVED("archived");

    private final String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
