public class Electronics extends Product{
    private String brand;
    private int warrantyPeriod;

    public String getBrand() {
        return brand;
    }
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Electronics(String brand, int warrantyPeriod) {
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString(){
        return super.toString()+ "Electronics [brand= "+brand+"warrantyPeriod= "+warrantyPeriod+ " ]";
    }
}
