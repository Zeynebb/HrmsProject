package kodlamaio.hrms.core.concretes;

import java.rmi.RemoteException;
import org.springframework.stereotype.Component;
import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisCheckAdapters implements MernisCheckService{
	
	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(
						Long.valueOf(jobSeeker.getNationalityId()), 
						jobSeeker.getFirstName(), 
						jobSeeker.getLastName(), 
						jobSeeker.getBirthYear());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;

	}

}
