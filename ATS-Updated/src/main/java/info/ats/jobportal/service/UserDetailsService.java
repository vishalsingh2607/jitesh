package info.ats.jobportal.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import info.ats.jobportal.model.UserDetails;

public interface UserDetailsService {
	void addUserDetails(UserDetails userdetails);
    
	List<UserDetails> get();
}
