package org.launchcode.techjobs.oo;

import java.util.HashMap;
import java.util.Objects;
import java.util.Map;
import java.util.LinkedHashMap;

import org.launchcode.techjobs.oo.*;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // -done TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    // -done other five fields. The second constructor should also call the first in order to initialize
    // -done the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency) {
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    // -done TODO: Add toString() method that passes tests
    @Override
    public String toString() {
        LinkedHashMap<String, JobField> hashMap = new LinkedHashMap<>(); //LinkedHashMap preserves order which is useful for printing

        //add data to hashMap
        hashMap.put("Employer", this.employer);
        hashMap.put("Location", this.location);
        hashMap.put("Position Type", this.positionType);
        hashMap.put("Core Competency", this.coreCompetency);

        //bonus, return early if job not present
        int count = 0;
        if (this.name == "" || this.name == null) {
            count++;
        }
        for (Map.Entry<String, JobField> item : hashMap.entrySet()) {
            if (item.getValue().isNullOrEmpty()) {
                count++;
            }
        }
        if (count == hashMap.size() + 1) {
            return "OOPS! This job does not seem to exist.";
        }

        //loop data in hashMap and build String
        String returnString = "\nID: " + this.id + "\n";
        if (this.name != "" && this.name != null) {
            returnString += "Name: " + this.name + "\n";
        } else {
            returnString += "Name: Data not available \n";
        }
        for (Map.Entry<String, JobField> item : hashMap.entrySet()) {
            returnString += item.getKey() + ": ";
            if (item.getValue().isNullOrEmpty()) {
                returnString += "Data not available\n";
            } else {
                returnString += item.getValue() + "\n";
            }
        }
        return returnString;

//-------------UPDATED WITH A BIT CLEANER CODE. WOULD HAVE BEEN EASIER IF ALL SAVED DATA HAD THEIR OWN CLASS.--------------------------
//        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>(); //LinkedHashMap preserves order which is useful for printing
//        //add data to hashMap
//        hashMap.put("ID", this.id);
//        hashMap.put("Name", this.name);
//        hashMap.put("Employer", this.employer);
//        hashMap.put("Location", this.location);
//        hashMap.put("Position Type", this.positionType);
//        hashMap.put("Core Competency", this.coreCompetency);
//
//        //bonus, return early if job not present
//        int count = 0;
//        for (Map.Entry<String, Object> item : hashMap.entrySet()) {
////            if (item.getValue() instanceof Employer) { // this is an example of type casting in order to get a null value instead of printing it to a string.
////                Employer employerObject = (Employer) item.getValue();  // feels like a lot of extra code for not much benefit
////                System.out.println(Objects.isNull(item.getValue())); //false
////                System.out.println(item.getValue()); //null
////                System.out.println(employerObject.isNullOrEmpty()); //true
////            }
//
//            if (item.getKey() == "ID") {
//            } else if (item.getKey() == "Name") {
//            } else if (item.toString().contains("=null")) {
//                count++;
//            }
//        }
//        if (count >= hashMap.size() - 2) {
//            return "OOPS! This job does not seem to exist.";
//        }
//        //loop data in hashMap and build String
//        String returnString = "\n";
//        for (Map.Entry<String, Object> item : hashMap.entrySet()) {
//            returnString += item.getKey() + ": ";
//            if (item.toString().contains("=null")) { //a bit hacky, but used to avoid casting all types to access null value
//                returnString += "Data not available\n";
//            } else {
//                returnString += item.getValue() + "\n";
//            }
//
//        }
//        return returnString;
//        return "\n" +   // manual string
//                "ID: " + this.id + "\n" +
//                "Name: " + this.name + "\n" +
//                "Employer: " + this.employer + "\n" +
//                "Location: " + this.location + "\n" +
//                "Position Type: " + this.positionType + "\n" +
//                "Core Competency: " + this.coreCompetency +
//                "\n";
    }

    // -done TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    // -done  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // -done TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    // -done and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public static boolean isNullOrEmpty(Object o) {
        if (o.toString().contains("=null")) {
            return true;
        }
        if (o.toString() == "") {
            return true;
        }
        return false;
    }


}
