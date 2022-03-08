package spring_boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_boot.model.Device;
import spring_boot.service.DeviceService;

import java.util.List;

@RestController
public class DeviceRestController {

   private final DeviceService deviceService;

    public DeviceRestController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("shop/allDevice")
    public ResponseEntity<?> getAllDevice (){
       List<Device> deviceList = deviceService.getAllDevice();
       return new ResponseEntity<>(deviceList, HttpStatus.OK);
    }

    @GetMapping("shop/{id}")
    public ResponseEntity<?> getDeviceById(@PathVariable long id) {
        Device device = deviceService.getDeviceById(id);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PatchMapping("shop")
    public ResponseEntity<?> updateDevice(@RequestBody Device device){
        deviceService.updateDevice(device);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }
    @DeleteMapping("shop/{id}")
    public ResponseEntity<?> deleteDevice(@PathVariable long id){
        deviceService.removeDeviceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("shop")
    public ResponseEntity<?> addDevice(@RequestBody Device device){
       deviceService.addDevice(device);
       return new ResponseEntity<>(device, HttpStatus.OK);
    }
}
