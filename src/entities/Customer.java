package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private Gender gender;
    private String phoneNumber;
    private List<Integer> productsCodes = new ArrayList<>();
    private LocalDate dateOfLastPurchase;

    public Customer() {
    }

    public Customer(String name, LocalDate dateOfBirth, String address, Gender gender, String phoneNumber,
                    List<Integer> productsCodes, LocalDate dateOfLastPurchase) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.productsCodes = productsCodes;
        this.dateOfLastPurchase = dateOfLastPurchase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Integer> getProductsCodes() {
        return productsCodes;
    }

    public void setProductsCodes(List<Integer> productsCodes) {
        this.productsCodes = productsCodes;
    }

    public LocalDate getDateOfLastPurchase() {
        return dateOfLastPurchase;
    }

    public void setDateOfLastPurchase(LocalDate dateOfLastPurchase) {
        this.dateOfLastPurchase = dateOfLastPurchase;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", productsCodes=" + productsCodes +
                ", dateOfLastPurchase=" + dateOfLastPurchase +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getName().equals(customer.getName()) && getDateOfBirth().equals(customer.getDateOfBirth()) && getAddress().equals(customer.getAddress()) && getGender() == customer.getGender() && getPhoneNumber().equals(customer.getPhoneNumber()) && getProductsCodes().equals(customer.getProductsCodes()) && getDateOfLastPurchase().equals(customer.getDateOfLastPurchase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDateOfBirth(), getAddress(), getGender(), getPhoneNumber(), getProductsCodes(), getDateOfLastPurchase());
    }
}