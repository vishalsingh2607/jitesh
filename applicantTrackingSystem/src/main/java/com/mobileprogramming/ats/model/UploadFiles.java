package com.mobileprogramming.ats.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.mobileprogramming.ats.model.Candidate;


@Entity
@Table(name = "uploadFile")
public class UploadFiles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resumeno")
	private Long id;

	@Column(name = "fileName")
	private String fileName;

	@Column(name = "fileStoragePath")
	private String fileStoragePath;

	@Column(name = "fileType")
	private String fileType;

	@Column(name = "fileSize")
	private long size;
	
	

//	@OneToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name="candidatecvid")
//	private Candidate candidate;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Candidate getCandidate() {
//		return candidate;
//	}
//
//	public void setCandidate(Candidate candidate) {
//		this.candidate = candidate;
//	}

	public UploadFiles() {

	}

	public UploadFiles(String fileName, String fileStoragePath, String fileType, long size) {
		this.fileName = fileName;
		this.fileStoragePath = fileStoragePath;
		this.fileType = fileType;
		this.size = size;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileStoragePath() {
		return fileStoragePath;
	}

	public void setFileStoragePath(String fileStoragePath) {
		this.fileStoragePath = fileStoragePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "UploadFileResponse [fileName=" + fileName + ", fileDownloadUri=" + fileStoragePath + ", fileType="
				+ fileType + ", size=" + size + "]";
	}

}
