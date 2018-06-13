package com.developerbhuwan.usermanagement;

public class Customer {

    private final String firstName;
    private final String lastName;
    private final String type;

    Customer(String firstName, String lastName, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    static UserDTO toRepresentation(Customer customer) {
        return null;
    }

    public String getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
