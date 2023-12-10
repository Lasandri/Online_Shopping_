public class Clothing extends Product{
    private String size;
    private String color;

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " Clothing [size=" + size + ", color=" + color + "]";
    }
}
