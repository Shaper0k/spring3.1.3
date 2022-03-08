package spring_boot.service;


import spring_boot.model.Device;


import java.util.List;


public interface DeviceService {
    void addDevice(Device device);

    void updateDevice(Device device);

    void removeDeviceById(long id);

    Device getDeviceById(long id);

    List<Device> getAllDevice();

    Device getDeviceByName(String name);
}
