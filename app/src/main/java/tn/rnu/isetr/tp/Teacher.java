package tn.rnu.isetr.tp;

import java.io.Serializable;

public class Teacher  implements Serializable {
    private String name;
    private String email;

    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }
}