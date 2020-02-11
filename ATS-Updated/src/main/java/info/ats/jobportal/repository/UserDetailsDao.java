package info.ats.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import info.ats.jobportal.model.UserDetails;



public interface UserDetailsDao extends JpaRepository<UserDetails, Long>{

}
