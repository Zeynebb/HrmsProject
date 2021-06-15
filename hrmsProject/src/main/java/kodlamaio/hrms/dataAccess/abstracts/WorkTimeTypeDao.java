package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkTimeType;

public interface WorkTimeTypeDao extends JpaRepository<WorkTimeType, Integer> {
	
	

}
