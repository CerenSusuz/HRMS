package com.hrms.core.adapters.mernis;

import org.springframework.stereotype.Service;


@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean validate(String firstName, String lastName, String nationalityId, int birthYear) {
		
//		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
//		
//			 try {
//		            return kpsPublicSoapProxy.TCKimlikNoDogrula(
//		            		Long.parseLong(nationalityId),
//		                    firstName,
//		                    lastName,
//		                    birthYear);
//		        } catch (Exception ex) {
//		            ex.printStackTrace();
//		            return false;
//		        }
		
		return true;
		        
	}

}