public enum Priority {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    VERY_HIGH("Очень высокий");

    private final String title;
    
    Priority(String title) {
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
