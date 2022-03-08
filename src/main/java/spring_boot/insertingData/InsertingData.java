package spring_boot.insertingData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_boot.model.Device;
import spring_boot.model.Role;
import spring_boot.model.User;
import spring_boot.service.DeviceService;
import spring_boot.service.RoleService;
import spring_boot.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Configuration
public class InsertingData {

    private final UserService userService;
    private final RoleService roleService;
    private final DeviceService deviceService;

    @Autowired
    public InsertingData(UserService userService, RoleService roleService, DeviceService deviceService) {
        this.userService = userService;
        this.roleService = roleService;
        this.deviceService = deviceService;
    }

    @Bean
    @PostConstruct
    public void addTestUsers() {
        User admin = new User();
        User user = new User();

        //----------------- Device
        Device device = new Device();
        Device device1 = new Device();
        Device device2 = new Device();
        Device device3 = new Device();
        Device device4 = new Device();
        Device device5 = new Device();
        Device device6 = new Device();
        Device device7 = new Device();
        Device device8 = new Device();

        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        Set<Role> rolesForAdmin = new HashSet<>();
        rolesForAdmin.add(roleService.getRoleByName("ROLE_ADMIN"));
        rolesForAdmin.add(roleService.getRoleByName("ROLE_USER"));

        Set<Role> rolesForUser = new HashSet<>();
        rolesForUser.add(roleService.getRoleByName("ROLE_USER"));

        admin.setUsername("admin");
        admin.setLastName("adminoff");
        admin.setEmail("admin@email.com");
        admin.setPassword("admin");
        admin.setRoles(rolesForAdmin);
        userService.addUser(admin);

        user.setUsername("user");
        user.setLastName("useroff");
        user.setEmail("user@email.com");
        user.setPassword("user");
        user.setRoles(rolesForUser);
        userService.addUser(user);

//-----------Device Create

        device.setName("Mouse");
        device.setDescription("This mouse for sell");
        device.setPrice(100);
        deviceService.addDevice(device);

        device1.setName("Keyboard");
        device1.setDescription("This keyboard for sell");
        device1.setPrice(150);
        deviceService.addDevice(device1);

        device2.setName("Monitor");
        device2.setDescription("This monitor for sell");
        device2.setPrice(550);
        deviceService.addDevice(device2);

        device3.setName("Video card");
        device3.setDescription("This Video card for sell");
        device3.setPrice(1550);
        deviceService.addDevice(device3);

        device4.setName("Processor");
        device4.setDescription("This Processor for sell");
        device4.setPrice(900);
        deviceService.addDevice(device4);

        device5.setName("Motherboard");
        device5.setDescription("This Motherboard for sell");
        device5.setPrice(660);
        deviceService.addDevice(device5);

        device6.setName("Hard disk");
        device6.setDescription("This Hard disk for sell");
        device6.setPrice(420);
        deviceService.addDevice(device6);

        device7.setName("RAM");
        device7.setDescription("This RAM for sell");
        device7.setPrice(380);
        deviceService.addDevice(device7);

        device8.setName("Cooler");
        device8.setDescription("This Cooler for sell");
        device8.setPrice(60);
        deviceService.addDevice(device8);
    }
}
