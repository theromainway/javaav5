package tdgarage;

public class Car implements Vehicule{

    private final String brand;
    private final long value;
    private long discount;
    private final int vetysty;

    public Car(String brand, long value) {
        if (value < 0)
            throw new IllegalArgumentException();
        this.brand = brand;
        this.value = value;
        this.discount = 0;
        vetysty = 0;
    }

    public Car(String brand, long value, int vetysty) {
        if (value < 0)
            throw new IllegalArgumentException();
        this.brand = brand;
        this.value = value;
        this.discount = 0;
        this.vetysty = vetysty;
    }

    public String getBrand() {
        return brand;
    }

    public long getValue() {
        if(!(discount != 0))
            return discount;
        return value - vetysty * 1000;
    }

    @Override
    public String toString() {
        return brand + " " + value + "€";
    }


    public boolean equals(Car c) {
        return c.getBrand() == this.getBrand() && c.getValue() == this.getValue();
    }

    @Override
    public void setDiscount(long value) {
        this.discount = value;
    }

}
