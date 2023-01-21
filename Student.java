package com.example.myapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The type Student.
 */
public class Student {
    /**
     * The Id property.
     */
    IntegerProperty idProperty;
    /**
     * The F name property.
     */
    StringProperty fNameProperty;
    /**
     * The L name property.
     */
    StringProperty lNameProperty;
    /**
     * The Address property.
     */
    StringProperty addressProperty;
    /**
     * The District property.
     */
    StringProperty districtProperty;
    /**
     * The Zip property.
     */
    StringProperty zipProperty;
    /**
     * The Email property.
     */
    StringProperty emailProperty;
    /**
     * The Phone property.
     */
    StringProperty phoneProperty;

    /**
     * Instantiates a new Student.
     */
    public Student() {
        this.idProperty = new SimpleIntegerProperty();
        this.fNameProperty = new SimpleStringProperty();
        this.lNameProperty = new SimpleStringProperty();
        this.addressProperty = new SimpleStringProperty();
        this.districtProperty = new SimpleStringProperty();
        this.zipProperty = new SimpleStringProperty();
        this.emailProperty = new SimpleStringProperty();
        this.phoneProperty = new SimpleStringProperty();
    }

    /**
     * Gets id property.
     *
     * @return the id property
     */
    public int getIdProperty() {
        return idProperty.get();
    }

    /**
     * Gets address property.
     *
     * @return the address property
     */
    public String getAddressProperty() {
        return addressProperty.get();
    }

    /**
     * Gets district property.
     *
     * @return the district property
     */
    public String getDistrictProperty() {
        return districtProperty.get();
    }

    /**
     * Gets name property.
     *
     * @return the name property
     */
    public String getfNameProperty() {
        return fNameProperty.get();
    }

    /**
     * Gets email property.
     *
     * @return the email property
     */
    public String getEmailProperty() {
        return emailProperty.get();
    }

    /**
     * Gets name property.
     *
     * @return the name property
     */
    public String getlNameProperty() {
        return lNameProperty.get();
    }

    /**
     * Gets zip property.
     *
     * @return the zip property
     */
    public String getZipProperty() {
        return zipProperty.get();
    }

    /**
     * Gets phone property.
     *
     * @return the phone property
     */
    public String getPhoneProperty() {
        return phoneProperty.get();
    }

    /**
     * Sets address property.
     *
     * @param addressProperty the address property
     */
    public void setAddressProperty(String addressProperty) {
        this.addressProperty.set(addressProperty);
    }

    /**
     * Sets district property.
     *
     * @param districtProperty the district property
     */
    public void setDistrictProperty(String districtProperty) {
        this.districtProperty.set(districtProperty);
    }

    /**
     * Sets name property.
     *
     * @param fNameProperty the f name property
     */
    public void setfNameProperty(String fNameProperty) {
        this.fNameProperty.set(fNameProperty);
    }

    /**
     * Sets id property.
     *
     * @param idProperty the id property
     */
    public void setIdProperty(int idProperty) {
        this.idProperty.set(idProperty);
    }

    /**
     * Sets name property.
     *
     * @param lNameProperty the l name property
     */
    public void setlNameProperty(String lNameProperty) {
        this.lNameProperty.set(lNameProperty);
    }

    /**
     * Sets email property.
     *
     * @param emailProperty the email property
     */
    public void setEmailProperty(String emailProperty) {
        this.emailProperty.set(emailProperty);
    }

    /**
     * Sets phone property.
     *
     * @param phoneProperty the phone property
     */
    public void setPhoneProperty(String phoneProperty) {
        this.phoneProperty.set(phoneProperty);
    }

    /**
     * Sets zip property.
     *
     * @param zipProperty the zip property
     */
    public void setZipProperty(String zipProperty) {
        this.zipProperty.set(zipProperty);
    }
}
