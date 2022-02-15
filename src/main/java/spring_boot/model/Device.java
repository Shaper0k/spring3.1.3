package spring_boot.model;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @Column(name = "idDevice")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "nameDevice")
    private String nameDevice;

    @Column(name = "descriptionDevice")
    private String descriptionDevice;

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", nameDevice='" + nameDevice + '\'' +
                ", descriptionDevice='" + descriptionDevice + '\'' +
                ", price=" + price +
                '}';
    }
    public Device(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public String getDescriptionDevice() {
        return descriptionDevice;
    }

    public void setDescriptionDevice(String descriptionDevice) {
        this.descriptionDevice = descriptionDevice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Device(int id, String nameDevice, String descriptionDevice, int price) {
        this.id = id;
        this.nameDevice = nameDevice;
        this.descriptionDevice = descriptionDevice;
        this.price = price;
    }

    @Column(name = "price")
    private int price;


}
