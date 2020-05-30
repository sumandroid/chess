package constants;

public enum PieceColor {
    BLACK("black"), WHITE("white");

    private String value;

    public String getValue() {
        return value;
    }

    PieceColor(String value) {
        this.value = value;
    }

    public static PieceColor fromString(String text) {
        for (PieceColor b : PieceColor.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
