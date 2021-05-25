package com.hrms.core.adapters.mernis;

import org.springframework.stereotype.Service;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean validate(String firstName, String lastName, long nationalityId, int birthYear) {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = false;
			 try {
		            return kpsPublicSoapProxy.TCKimlikNoDogrula(
		                    nationalityId,
		                    firstName,
		                    lastName,
		                    birthYear);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        
	           return result;
	}

}