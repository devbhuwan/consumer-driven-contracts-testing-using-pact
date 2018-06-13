package com.developerbhuwan.usermanagement;

public class UserDTO {

    private final String fullName;
    private final String type;

    public UserDTO(String fullName, String type) {
        this.fullName = fullName;
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public String getType() {
        return type;
    }
}
