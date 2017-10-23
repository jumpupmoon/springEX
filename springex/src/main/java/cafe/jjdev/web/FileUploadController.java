package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cafe.jjdev.web.service.FileUploadService;

@Controller
public class FileUploadController {
	
	@Autowired
	FileUploadService fileUploadService;
	
	// file upload form
	@RequestMapping(value="/fileAdd", method = RequestMethod.GET)
	public String fileAdd() {
		return "fileAdd";
	}
	
	// file upload 처리
	@RequestMapping(value="/fileAdd", method = RequestMethod.POST)
	public String fileAdd(FileRequest fileReq) {
		System.out.println(fileReq+" 업로드 된 파일 주소");
		fileUploadService.fileUpload(fileReq);
		return "";
	}
}
