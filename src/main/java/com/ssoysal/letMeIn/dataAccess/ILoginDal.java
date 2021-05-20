package com.ssoysal.letMeIn.dataAccess;

import java.util.List;

import com.ssoysal.letMeIn.entities.*;

public interface ILoginDal {
	List<Login> getAll();
	void add(Login login);
	void update(Login login);
	void delete(Login login);
}
