package info.ats.jobportal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import info.ats.jobportal.model.UserDetails;
import info.ats.jobportal.repository.UserDetailsDao;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDetailsDao userdetailsdao;

	@Override
	public List<UserDetails> get() {
		return userdetailsdao.findAll();
	}

	@Override
	public void addUserDetails(UserDetails userdetails) {
//       System.out.println(userdetails.getId());
//       System.out.println(userdetails.getName());
//       System.out.println(userdetails.getEmailaddress());
//       System.out.println(userdetails.getTeamid());
//       System.out.println(userdetails.getUserlocation());
//       System.out.println(userdetails.getUserphone());
//       System.out.println(userdetails.getUserrole());
//       System.out.println(userdetails.getStatus());
//       System.out.println(userdetails.getCreatedAt());
//       
//       
		userdetailsdao.save(userdetails);
	}

}
