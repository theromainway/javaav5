package tdgarage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Garage {

    private ArrayList<Vehicule> vehicules;
    public static int id;

    public Garage() {
        vehicules = new ArrayList<>();
        ++id;
    }

    public void add(Vehicule v) {
        v = Objects.requireNonNull(v);
        vehicules.add(v);

        Comparator c = new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                Car c1 = (Car)o1;
                Car c2 = (Car)o2;

                return (c1.getBrand().compareTo(c2.getBrand()) + ((int)c1.getValue()- (int) c2.getValue()));
            }

        };
        vehicules.sort(c);
    }

    public int getId() {
        return id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vehicule v : vehicules) {
            sb.append(v.toString());
            sb.append(" ,");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public long getValues() {
        long total = 0;

        for (Vehicule v : vehicules)
            total += v.getValue();
        return total;
    }

    public Vehicule firstCarByBrand(String brand) {

        for (Vehicule v : vehicules)
            if (v.getBrand().equals(brand))
                return v;
        throw new NoSuchElementException();
    }

    public Vehicule remove(Vehicule v) {
        vehicules.remove(v);
        return v;
    }

    public boolean equals(Garage g) {
        return vehicules.equals(g.vehicules);
    }

    public void protectionism(String brand) {
        for(Vehicule v : vehicules)
            if(v.getBrand() == brand)
                vehicules.remove(v);
    }

}