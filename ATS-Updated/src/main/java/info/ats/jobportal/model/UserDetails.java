package info.ats.jobportal.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "User_Details")
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "userId", unique = true, nullable = false)
	private Long id;

	@Column(name = "User_Name")
	private String name;

	@Column(name = "User_Role")
	private String userrole;

	@Column(name = "User_Email")
	private String emailaddress;

	@NotEmpty(message = "phone is required")
	@Size(max = 10, message = "digits should be 10")
	@Column(name = "User_Phone")
	private String userphone;

	@Column(name = "User_Location")
	private String userlocation;

	@Column(name = "TeamId")
	private String teamid;

	@Column(name = "Status")
	private Boolean status;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;
	
	

	public UserDetails() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUserlocation() {
		return userlocation;
	}

	public void setUserlocation(String userlocation) {
		this.userlocation = userlocation;
	}

	public String getTeamid() {
		return teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", userrole=" + userrole + ", emailaddress=" + emailaddress
				+ ", userphone=" + userphone + ", userlocation=" + userlocation + ", teamid=" + teamid + ", status="
				+ status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	

}
