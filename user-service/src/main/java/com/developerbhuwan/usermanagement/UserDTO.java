package com.developerbhuwan.usermanagement;

public class UserDTO {

    private final String fullName;
    private final String type;
    private final AddressDTO address;

    public UserDTO(String fullName, String type, AddressDTO address) {
        this.fullName = fullName;
        this.type = type;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public String getType() {
        return type;
    }

    public AddressDTO getAddress() {
        return address;
    }
}
