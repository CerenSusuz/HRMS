package com.hrms.core.adapters.mernis;

import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean validate(String firstName, String lastName,long nationalityId, int birthYear){
	return true;
	}

//	KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
//	
//	public boolean validate(String firstName, String lastName,long nationalityId, int birthYear) {
//		 try {
//	            return kpsPublicSoapProxy.TCKimlikNoDogrula(
//	                    nationalityId,
//	                    firstName,
//	                    lastName),
//	                    birthYear);
//	        } catch (Exception e) {
//	            ex.printStackTrace();
//	        }
//	        
//           return result;
//	}

}