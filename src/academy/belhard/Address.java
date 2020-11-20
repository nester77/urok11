package academy.belhard;

class Address {
    private int id;
    private String city;
    private String street;
    private int numberOfHouse;
    private int numberOfBuilding;
    private int numberOfFlat;

    public Address(int id, String city, String street, int numberOfHouse, int numberOfBuilding, int numberOfFlat) {
        this.id=id;
        this.city=city;
        this.street=street;
        this.numberOfHouse=numberOfHouse;
        this.numberOfBuilding=numberOfBuilding;
        this.numberOfFlat=numberOfFlat;
    }

    public Address setId(int id) {

        this.id=id;
        return this;
    }

    public Address setCity(String city) {

        this.city=city;
        return this;
    }

    public Address setStreet(String street){

        this.street=street;
        return this;
    }

    public Address setNumberOfHouse(int numberOfHouse){

        this.numberOfHouse=numberOfHouse;
        return this;
    }

    public Address setNumberOfBuilding(int numberOfBuilding){

        this.numberOfBuilding=numberOfBuilding;
        return this;
    }

    public Address setNumberOfFlat(int numberOfFlat){

        this.numberOfFlat=numberOfFlat;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getCity() { return city; }

    public String getStreet() {
        return street;
    }

    public int getNumberOfHouse() {
        return numberOfHouse;
    }

    public int getNumberOfBuilding() {
        return numberOfBuilding;
    }

    public int getNumberOfFlat() {
        return numberOfFlat;
    }

    @Override
    public String toString() {

        return "ID:"+ id+ " Город: "+ city+", Улица: "+ street + ", Дом: "+numberOfHouse+ ", Корпус: "+numberOfBuilding +", Квартира: " + numberOfFlat;
    }

}