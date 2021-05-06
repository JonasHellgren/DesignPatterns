package org.example.pluralsightcourse_interfacesandabstraction;

import lombok.Getter;

@Getter
public class ClientEngagement {
    String name;
    int hoursWorked;

    public ClientEngagement(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }
}
