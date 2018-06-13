package com.developerbhuwan.usermanagement;

public class UserDTO {

    private final String name;
    private final String type;

    public UserDTO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
