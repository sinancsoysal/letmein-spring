package com.ssoysal.letMeIn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssoysal.letMeIn.dataAccess.ILoginDal;
import com.ssoysal.letMeIn.entities.Login;

@Service
public class LoginManager implements ILoginService{
	
	private ILoginDal loginDal;

	@Autowired
	public LoginManager(ILoginDal loginDal) {
		this.loginDal = loginDal;
	}

	@Override
	@Transactional
	public List<Login> getAll() {
		return this.loginDal.getAll();
	}

	@Override
	@Transactional
	public void add(Login login) {
		this.loginDal.add(login);
	}

	@Override
	@Transactional
	public void update(Login login) {
		this.loginDal.update(login);
	}

	@Override
	@Transactional
	public void delete(Login login) {
		this.loginDal.delete(login);
	}

}
