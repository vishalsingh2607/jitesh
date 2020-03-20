package com.mobileprogramming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobileprogramming.model.FinalProfile;


@Service
public interface FinalProfileService {

	public List<FinalProfile> getFinal();

	public FinalProfile addFinal(FinalProfile profile);

	public String updateFinal(FinalProfile profile, int id);

	public Optional<FinalProfile> getProfileForCandidate(int id);

	public String deleteProfile(int id);
}
