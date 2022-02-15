package spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_boot.model.Device;
import spring_boot.model.Role;
import spring_boot.model.User;
import spring_boot.service.DeviceService;
import spring_boot.service.RoleService;
import spring_boot.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final DeviceService deviceService;

    @Autowired
    public UserController(UserService userService, RoleService roleService, DeviceService deviceService) {
        this.userService = userService;
        this.roleService = roleService;
        this.deviceService = deviceService;
    }

    @GetMapping(value = "/")
    public String start(){
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "loginpage";
    }

    @GetMapping(value = "/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "userpage";
    }

    @GetMapping(value = "/admin")
    public String listUsers(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "adminpage";
    }

    @GetMapping(value = "/admin/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "new";
    }

    @PostMapping(value = "/admin/add-user")
    public String addUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : checkBoxRoles) {
            roleSet.add(roleService.getRoleByName(role));
        }
        user.setRoles(roleSet);
        userService.addUser(user);
        return "redirect:/admin";
    }


    @GetMapping(value = "/edit/{id}")
    public String editUserForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "edit";
    }

    @PostMapping(value = "/admin/edit/{id}")
    public String editUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : checkBoxRoles) {
            roleSet.add(roleService.getRoleByName(roles));
        }
        user.setRoles(roleSet);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/{id}/delete")
    public String removeUser(@PathVariable("id") long id) {
        System.out.println(id);
        userService.removeUserById(id);
        return "redirect:/admin";
    }
//-------------------------------------------------------------Shop

    @GetMapping(value = "/shop")
    public String listDevice(@ModelAttribute Device device, Model model) {
        model.addAttribute("device", device);
        model.addAttribute("allDevice", deviceService.getAllDevice());
        return "shop";
    }

    @GetMapping(value = "/shop/newDevice")
    public String newDevice(Model model) {
        model.addAttribute("device", new Device());
        return "newDevice";
    }

    @PostMapping(value = "/shop/add-device")
    public String addDevice(@ModelAttribute Device device) {
        deviceService.addDevice(device);
        return "redirect:/shop";
    }


    @GetMapping(value = "shop/edit/{id}")
    public String editDeviceForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("device", deviceService.getDeviceById(id));
        return "editDevice";
    }

    @PostMapping(value = "/shop/edit/{id}")
    public String editDevice(@ModelAttribute Device device) {
       deviceService.updateDevice(device);
        return "redirect:/shop";
    }

    @PostMapping(value = "/shop/{id}/delete")
    public String removeDevice(@PathVariable("id") long id) {
        deviceService.removeDeviceById(id);
        return "redirect:/shop";
    }
}
