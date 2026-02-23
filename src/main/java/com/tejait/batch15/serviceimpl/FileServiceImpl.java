package com.tejait.batch15.serviceimpl;



import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tejait.batch15.model.File;
import com.tejait.batch15.repository.FileRepository;
import com.tejait.batch15.service.FileService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FileServiceImpl implements FileService {

	private FileRepository repository;
	
	@Override
	public String uploadFile(MultipartFile file) throws IOException {
		
	File fe=new File();
		fe.setFilename(file.getOriginalFilename());
		fe.setFiletype(file.getContentType());
		fe.setData(file.getBytes());
		
		repository.save(fe);
		return "File uploaded sucessfully into db";
	}

}
