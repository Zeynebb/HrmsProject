package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CvForeignLanguage;
import kodlamaio.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto;

public interface CvForeignLanguageDao extends JpaRepository<CvForeignLanguage, Integer>{
	
	Long deleteByCv_CvId(int cvId);
	
	@Modifying
	@Query("DELETE FROM CvForeignLanguage c where c.cvforeignLanguageId=?1")
	int deleteByCvForeignLanguageId(int foreignLanguageId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto(c.cvforeignLanguageId, "
			+ " f.foreignLanguageId, f.foreignLanguageName,l.languageLevelId, l.languageLevelName) "
			+ "From CvForeignLanguage c INNER JOIN c.foreignLanguage f INNER JOIN c.languageLevel l "
			+ " where c.cv.cvId = ?1 ORDER BY l.languageLevelId DESC")
	List<CvForeignLanguageWithForeignLanguageDto> getCvForeignLanguageWithForeignLanguageDetails(int cvId);

}
