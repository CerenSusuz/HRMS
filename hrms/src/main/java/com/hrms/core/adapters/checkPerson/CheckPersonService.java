package com.hrms.core.adapters.checkPerson;

import java.rmi.RemoteException;

public interface CheckPersonService {
	 boolean validate(Person person) throws RemoteException;
}
