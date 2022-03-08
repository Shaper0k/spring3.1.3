package spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_boot.dao.DeviceRepository;
import spring_boot.model.Device;


import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void addDevice(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public void updateDevice(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public Device getDeviceById(long id) {
       return deviceRepository.getDeviceById(id);
    }

    @Override
    public void removeDeviceById(long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public List<Device> getAllDevice() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getDeviceByName(String name) {
        return deviceRepository.findByNameDevice(name);
    }
}
