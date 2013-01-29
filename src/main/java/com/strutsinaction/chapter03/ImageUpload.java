package com.strutsinaction.chapter03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/*
 * This action uploads an image file using the default fileUpload 
 * interceptor.  The interceptor is in the default stack and the only
 * thing we have to do here in the action is implement JavaBean's 
 * properties to receive the File and meta-data from the interceptor.
 */

public class ImageUpload extends ActionSupport {

	static Logger log = LoggerFactory.getLogger(ImageUpload.class);

	public String execute() {

		/*
		 * Add the image to the portfolio.
		 */

		// add image to account
		try {
			// getPortfolioService().addImage(getPic(), getPicFileName(),
			// fileSystemPath);
			log.debug("FileName:{},FileLength:{}",this.getPicFileName(),this.getPic().getTotalSpace());
			/*
			 * add image to the portfolio and save image file to local
			 * filesystem
			 */
			FileInputStream in = null;
			FileOutputStream out = null;

			String directoryName = "D:\\UploadedFiles";
			File dir = new File(directoryName);
			if (!dir.exists())
				dir.mkdir();
			String targetPath = dir.getPath() + dir.separator + this.getPicFileName();
			log.debug("writing file to " + targetPath);

			File picDestination = new File(targetPath);
			try {
				in = new FileInputStream(pic);
				out = new FileOutputStream(picDestination);
				int c;

				while ((c = in.read()) != -1) {
					out.write(c);
				}

			} finally {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return SUCCESS;

	}

	/* JavaBeans Properties to Receive Request Parameters */

	File pic;
	String picContentType;
	String picFileName;
	String fileSystemPath;

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setFileSystemPath(String fileSystemPath) {
		this.fileSystemPath = fileSystemPath;
	}

}
