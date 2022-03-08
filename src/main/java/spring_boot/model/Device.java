package spring_boot.model;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @Column(name = "idDevice")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", nameDevice='" + name + '\'' +
                ", descriptionDevice='" + description + '\'' +
                ", price=" + price +
                '}';
    }
    public Device(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Device(Long id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Column(name = "price")
    private int price;


}
