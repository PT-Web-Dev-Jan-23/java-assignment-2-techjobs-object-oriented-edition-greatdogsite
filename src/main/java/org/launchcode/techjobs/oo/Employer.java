package org.launchcode.techjobs.oo;

public class Employer extends JobField {

    public Employer(String value) {
        super(value);
    }

    public Employer() {
        super();
    }

    //    private int id;
//    private static int nextId = 1;
//    private String value = "Data not available";
//
//    public Employer() {
//        id = nextId;
//        nextId++;
//    }
//
//    public Employer(String aValue) {
//        this();
//        this.value = aValue
//    }

    // Custom toString, equals, and hashCode methods:
//
//    @Override
//    public String toString() {
//        return value;
//    }
//
//    @Override
//    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
//        if (this == o) return true;
//        if (!(o instanceof Employer)) return false;
//        Employer employer = (Employer) o;
//        return getId() == employer.getId();
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

}
