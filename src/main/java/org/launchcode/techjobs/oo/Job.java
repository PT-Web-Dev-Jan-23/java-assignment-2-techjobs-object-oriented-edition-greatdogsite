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

        // loop data in hashMap and build String, return early if not enough data
        int count = 0;
        String returnString = "\nID: " + this.id + "\n";

        // check name since it's not built from a JobField class.
        returnString += (this.name != "" && this.name != null) ? "Name: " + this.name + "\n" : "Name: Data not available \n";
        if (this.name == "" || this.name == null) { count++; }

        // loop hashMap
        for (Map.Entry<String, JobField> item : hashMap.entrySet()) {
            returnString += item.getKey() + ": ";
            returnString += (item.getValue().isNullOrEmpty()) ? "Data not available\n" : item.getValue() + "\n";
            if (item.getValue().isNullOrEmpty()) { count++; }
        }
        
        // bonus
        if (count == hashMap.size() + 1) { return "OOPS! This job does not seem to exist."; }
        return returnString;
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
