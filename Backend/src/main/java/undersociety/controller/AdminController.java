package undersociety.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import undersociety.models.AdminData;
import undersociety.services.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	 private AdminService adminService;
	
	
	
	@GetMapping("/admindata")
	public AdminData getAdminData() {
		return adminService.getAdminData();
	}
}
