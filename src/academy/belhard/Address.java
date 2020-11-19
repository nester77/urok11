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

//    public void setId(int id) {
//
//        this.id=id;
//    }

    public void setCity(String city) {

        this.city=city;
    }

    public void setStreet(String street){

        this.street=street;
    }

    public void setNumberOfHouse(int numberOfHouse){

        this.numberOfHouse=numberOfHouse;
    }

    public void setNumberOfBuilding(int numberOfBuilding){

        this.numberOfBuilding=numberOfBuilding;
    }

    public void setNumberOfFlat(int numberOfFlat){

        this.numberOfFlat=numberOfFlat;
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

        return "Город: "+ city+", Улица: "+ street + ", Дом: "+numberOfHouse+ ", Корпус: "+numberOfBuilding +", Квартира: " + numberOfFlat;
    }


}
