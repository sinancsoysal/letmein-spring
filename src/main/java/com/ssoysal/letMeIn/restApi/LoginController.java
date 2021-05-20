package com.ssoysal.letMeIn.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssoysal.letMeIn.service.ILoginService;
import com.ssoysal.letMeIn.entities.Login;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class LoginController {
	private ILoginService loginService;

	@Autowired
	public LoginController(ILoginService loginService) {
		this.loginService = loginService;
	}
	
	@CrossOrigin(origins = "http://localhost:3000/")
	@GetMapping("/logins")
	public List<Login> get() {
		return loginService.getAll();
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public void add(@RequestBody Login login) {
		loginService.add(login);
	}
	
	@PostMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	public void update(@RequestBody Login login) {
		loginService.update(login);
	}
	
	@PostMapping("/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(@RequestBody Login login) {
		loginService.delete(login);
	}
}
