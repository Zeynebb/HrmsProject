package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService{

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryservice;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryservice) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryservice = cloudinaryservice;
	}

	@Override
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException {
		//this.photoDao.updatePhotoSetPhotoUrlForCv_cvId(result.get("url").toString(), cvId);
		Result result= new ErrorResult("Fotoğraf Eklenemedi!");
		Map photoMap = cloudinaryservice.photoUpload(multipartFile);
		photo.setPhotoUrl(photoMap.get("url").toString());
		if(!this.photoDao.getAllCvId().contains(photo.getCv().getCvId())) {
			result = new SuccessResult("Fotoğraf Eklendi");
			this.photoDao.save(photo);
		}
		return result;
	}
	@Override
	public Result delete(String id) throws IOException {
		this.cloudinaryservice.photoDelete(id);
		return new SuccessResult("Fotoğraf Silindi");
	}

	@Override
	public Result update(int cvId, MultipartFile multipartFile) throws IOException {
		Map photoMap = cloudinaryservice.photoUpload(multipartFile);
		this.photoDao.updatePhotoSetPhotoUrlForCv_cvId(photoMap.get("url").toString(), cvId);
		return new SuccessResult("Fotoğraf Güncellendi");
	}

}
