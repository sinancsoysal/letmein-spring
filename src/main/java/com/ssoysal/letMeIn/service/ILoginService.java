package com.ssoysal.letMeIn.service;

import java.util.List;

import com.ssoysal.letMeIn.entities.Login;

public interface ILoginService {
	List<Login> getAll();
	void add(Login login);
	void update(Login login);
	void delete(Login login);
}
