package com.bilgeadam.springbootthymeleaf.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.bilgeadam.springbootthymeleaf.model.Ogrenci;
import com.bilgeadam.springbootthymeleaf.repo.OgrenciRepo;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
//@AllArgsConstructor Logger kullanabilmek için requiredconstructor eklenecek
@RequiredArgsConstructor
public class OgrenciService {

	/*
	 * class yerine topic verilebiliyor ama bu şekilde application.properties'e
	 * dikkat.!!!!!
	 * 
	 * @Autowired
	 * 
	 * @Qualifier(value = "OGRENCI_SERVICE") private Logger logger =
	 * LoggerFactory.getLogger("OGRENCI_SERVICE");
	 */

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@NonNull
	private OgrenciRepo ogrenciRepo;

	public List<Ogrenci> getAll() {
		logger.debug("ögrenci getAll metodu çalışıyor.");

		List<Ogrenci> temp = ogrenciRepo.findAll(Sort.by(Order.asc("ID")));
		List<Ogrenci> list = new LinkedList<Ogrenci>(temp);
		return list;
	}

	public Ogrenci getById(Long id) {
		return ogrenciRepo.findById(id).get();
	}

	public boolean delete(Long id) {
		try {
			ogrenciRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Ogrenci save(Ogrenci ogrenci) {
		return ogrenciRepo.save(ogrenci);
	}

	public Ogrenci find(String isim) {
		return ogrenciRepo.findOgrenciByNAME(isim);
	}

	public List<Ogrenci> findNameLike(String expression) {
		return ogrenciRepo.findAllByNAMELike("%" + expression + "%", Sort.by(Order.desc("ID")));
//		return ogretmenRepo.findAllByNAMELikeOrderByNAMEDesc("%" + expression + "%");
		// return ogretmenRepo.findByOgretmenName("%" + expression + "%");
	}
}
