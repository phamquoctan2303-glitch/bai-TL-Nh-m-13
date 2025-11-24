package model;

import java.io.Serializable;

public class User implements Serializable {
    protected String id;
    protected String name;
    protected int age;

    public User() {}

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return id + " - " + name + " - " + age + " tuoi";
    }
}
