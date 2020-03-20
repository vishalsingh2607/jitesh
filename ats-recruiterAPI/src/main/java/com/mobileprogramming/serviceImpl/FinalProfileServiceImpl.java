package com.mobileprogramming.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileprogramming.model.FinalProfile;
import com.mobileprogramming.repository.FinalProfileRepository;
import com.mobileprogramming.service.FinalProfileService;


@Service
public class FinalProfileServiceImpl implements FinalProfileService{

	@Autowired
	private FinalProfileRepository repo;
	
	@Override
	public List<FinalProfile> getFinal() {
		// TODO Auto-generated method stub
		return (List<FinalProfile>) repo.findAll();
	}

	@Override
	public FinalProfile addFinal(FinalProfile profile) {
		// TODO Auto-generated method stub
		
		return repo.save(profile);
	}

	@Override
	public String updateFinal(FinalProfile profile, int id) {
		// TODO Auto-generated method stub
		repo.save(profile);
		return "Profile Updated";
	}

	@Override
	public Optional<FinalProfile> getProfileForCandidate(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public String deleteProfile(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Profile Deleted";
	}

	

}
