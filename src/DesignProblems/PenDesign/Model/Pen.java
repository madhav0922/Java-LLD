package DesignProblems.PenDesign.Model;


public class Pen {
    private String name;
    private String brand;
    private float price;
    private PenType type;

    private ClosingType cType;
    private Status status;

    public Pen() {

    }

    public Pen(String name, String brand, float price, PenType type, ClosingType cType, Status status) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.type = type;
        this.cType = cType;
        this.status = status;
    }

    public void open() {
        System.out.println(this.getType() + " pen " + this.getcType() + " opened!");
    }

    public void write() {
        System.out.println(this.getType() + " pen writes!");
    }

    public void close() {
        System.out.println(this.getType() + " pen " + this.getcType() + " closed!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public PenType getType() {
        return type;
    }

    public void setType(PenType type) {
        this.type = type;
    }

    public ClosingType getcType() {
        return cType;
    }

    public void setcType(ClosingType cType) {
        this.cType = cType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String brand;
        private float price;
        private PenType type;
        private ClosingType cType;
        private Status status;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setPrice(float price) {
            this.price = price;
            return this;
        }

        public Builder setType(PenType type) {
            this.type = type;
            return this;
        }

        public Builder setcType(ClosingType cType) {
            this.cType = cType;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Pen build() {
            return new Pen(this.name, this.brand, this.price, this.type, this.cType, this.status);
        }
    }
}
