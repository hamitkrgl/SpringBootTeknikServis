package com.bilgeadam.springbootthymeleaf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.springbootthymeleaf.model.Ders;
import com.bilgeadam.springbootthymeleaf.repo.DersRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DersService {
	private DersRepo dersRepo;

	public List<Ders> getAll() {
		return dersRepo.findAll();
	}

	public Ders getById(Long id) {
		return dersRepo.findById(id).get();
	}

	public Ders save(Ders ders) {
		return dersRepo.save(ders);
	}

	public boolean delete(Long id) {
		try {
			dersRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
