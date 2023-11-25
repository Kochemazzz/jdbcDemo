package ru.topjava.learn.entiny;

public class Abonent extends Entity{
    private Integer id;
    private String name;
    private Integer phone;

    public Abonent(Integer id, String name, Integer phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Abonent() {
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
