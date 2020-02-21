package com.mobileprogramming.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.ats.model.UploadFiles;

@Repository
public interface FilesRepository extends JpaRepository<UploadFiles, Long>{

}
