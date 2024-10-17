// Justin Doxsee
// Dessa Shapiro
package petespike.view;

public enum AsciiColorCodes {
    RESET("\u001b[0m"),
    RED("\u001b[38;5;9m"),
    BLUE("\u001b[38;5;12m"),
    ORANGE("\u001b[38;5;130m"),
    GREEN("\u001b[38;5;28m"),
    YELLOW("\u001b[38;5;11m"),
    MAGENTA("\u001b[38;5;13m"),
    GOLD("\u001b[38;5;220m"),
    PURPLE("\u001b[38;5;5m"),
    LT_GRAY("\u001b[38;5;7m"),
    CYAN("\u001b[38;5;14m");

    private String colorVal;

    private AsciiColorCodes(String colorVal) {
        this.colorVal = colorVal;
    }

    public String getColorVal() {return this.colorVal;}
}
