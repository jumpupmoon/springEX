package cafe.jjdev.web.service;

public class FileVo {
	private String fileTitle;
	private String fielPath;
	public String getFileTitle() {
		return fileTitle;
	}
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	public String getFielPath() {
		return fielPath;
	}
	public void setFielPath(String fielPath) {
		this.fielPath = fielPath;
	}
	@Override
	public String toString() {
		return "FileVo [fileTitle=" + fileTitle + ", fielPath=" + fielPath + "]";
	}
}
