package spring_boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot.model.Device;


@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByName (String deviceName);

    Device getDeviceById(long id);

}
