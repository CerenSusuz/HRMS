package com.hrms.core.adapters.checkPerson;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements CheckPersonService {

	@Override
	public boolean validate(Person person) throws RemoteException {
		System.out.println("sadfghj");
		return true;
	}

//	private KPSPublicSoap client = new KPSPublicSoapProxy();
//	
//	public boolean validate(Person person) throws RemoteException {
//		 try {
//	            return client.TCKimlikNoDogrula(
//	                    person.getNalionalityId(),
//	                    person.getFirstName(),
//	                    person.getLastName(),
//	                    person.getYearOfBirth());
//	        } catch (Exception e) {
//	            return false;
//	        }
//	}

}