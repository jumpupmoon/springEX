package cafe.jjdev.web.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cafe.jjdev.web.FileRequest;

@Service
public class FileUploadService {

	public int fileUpload(FileRequest fileReq) {
		MultipartFile file = fileReq.getFile();
		String fileName = file.getOriginalFilename();
		System.out.println(fileName+" Original Name");
		int pos = fileName.lastIndexOf(".") + 1; // test.txt
		String ext = fileName.substring(pos);
		System.out.println(ext + " type");
		
		UUID uuid = UUID.randomUUID();
		String name = uuid.toString();
		name = name.replaceAll("-", "");
		System.out.println("name : " + name+"."+ext);
		
		File destFile = new File("d:/upload/"+name+"."+ext);
		try {
			file.transferTo(destFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileVo fileVo = new FileVo();
		fileVo.setFileTitle(fileReq.getFileTitle());
		fileVo.setFielPath("d:/upload/"+name+"."+ext);
		
		// 실제 파일을 폴더에 저장
		// fileReq를 FileVo로 변경
		// fileDao.insert method 호출
		return 0;
	}
	
}
