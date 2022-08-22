import java.util.Comparator;

public class TV {
    private String model;
    private int yearOfProduction;
    private long price;
    private double diagonal;
    private TV_brands tvBrand;

    public TV(String model, int yearOfProduction, long price, double diagonal, TV_brands tvBrand) {
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
        this.diagonal = diagonal;
        this.tvBrand = tvBrand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public long getPrice() {
        return price;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public TV_brands getTvBrand() {
        return tvBrand;
    }

    @Override
    public String toString() {
        return "TV{" +
                "model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", price=" + price +
                ", diagonal=" + diagonal +
                ", tvBrand=" + tvBrand +
                '}';
    }
}
