package spring_boot.insertingData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_boot.model.Role;
import spring_boot.model.User;
import spring_boot.service.RoleService;
import spring_boot.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


//@Configuration
//public class InsertingData {
//    private final UserService userService;
//    private final RoleService roleService;
//
//    @Autowired
//    public InsertingData(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @Bean
//    @PostConstruct
//    public void addTestUsers() {
//        User admin = new User();
//        User user = new User();
//
//        roleService.addRole(new Role("ROLE_ADMIN"));
//        roleService.addRole(new Role("ROLE_USER"));
//
//        Set<Role> rolesForAdmin = new HashSet<>();
//        rolesForAdmin.add(roleService.getRoleByName("ROLE_ADMIN"));
//        rolesForAdmin.add(roleService.getRoleByName("ROLE_USER"));
//
//        Set<Role> rolesForUser = new HashSet<>();
//        rolesForUser.add(roleService.getRoleByName("ROLE_USER"));
//
//        admin.setUsername("admin");
//        admin.setLastName("adminoff");
//        admin.setEmail("admin@email.com");
//        admin.setPassword("admin");
//        admin.setRoles(rolesForAdmin);
//        userService.addUser(admin);
//
//        user.setUsername("user");
//        user.setLastName("useroff");
//        user.setEmail("user@email.com");
//        user.setPassword("user");
//        user.setRoles(rolesForUser);
//        userService.addUser(user);
//    }
//}
