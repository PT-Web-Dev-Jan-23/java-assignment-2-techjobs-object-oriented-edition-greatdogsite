package org.launchcode.techjobs.oo;

public class Location extends JobField {

    public Location(String aValue) {
        super(aValue);
    }

    public Location() {
        super();
    }

//    private int id;
//    private static int nextId = 1;
//    private String value = "Data not available";
//
//    public Location() {
//        id = nextId;
//        nextId++;
//    }
//
//    // -done TODO: Add a constructor that takes a string as a parameter and assigns it to the 'value' field. The
//    //  -done constructor should also call the empty constructor in order to initialize the 'id' field.
//    public Location(String aValue) {
//        this();
//        this.value = aValue;
//    }
//
//    // Custom toString, equals, and hashCode methods:
//
//    @Override
//    public String toString() {
//        return value;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Location)) return false;
//        Location location = (Location) o;
//        return getId() == location.getId();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }
//
//    // Getters and Setters:
//
//    public int getId() {
//        return id;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public boolean isNullOrEmpty() {
//        if (this.value == null) {
//            return true;
//        }
//        if (this.value == "") {
//            return true;
//        }
//        return false;
//    }

}
