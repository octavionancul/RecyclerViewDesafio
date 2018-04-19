package cl.octavionancul.recyclerviewdesafio.models;

public class Wine {
    private String brand,type;
    private int years;

    public Wine() {
    }

    public Wine(String brand, String type, int years) {
        this.brand = brand;
        this.type = type;
        this.years = years;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
