package tdgarage;

public class Bike implements Vehicule{

    private final String brand;
    public static final int value = 100;

    public Bike(String brand) {
        this.brand = brand;
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setDiscount(long value) {
        
    }
    
}