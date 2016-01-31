package kr.niee.mdt.common.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploadController {
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public Map<String, Object> multiImgUpload(HttpServletRequest req, HttpServletResponse res) throws FileUploadException{
		Map<String, Object> resultMap = new HashMap<>();
		if(req.getContentLength()/1024000 > 5)
			throw new FileUploadException();
		try{
			String realName = URLDecoder.decode(req.getHeader("file-name"), "UTF-8");
			String prifix = realName.substring(realName.lastIndexOf(".")+1);
			prifix = prifix.toLowerCase();
			String path = req.getSession().getServletContext().getRealPath("/") + "resources\\img\\";
			File file = new File(path);
			System.out.print(path);
			if(!file.exists()){
				file.mkdirs();
			}
			
			String saveName = UUID.randomUUID().toString() + "." +prifix;
			
			InputStream is = req.getInputStream();
			OutputStream os = new FileOutputStream(new File(path + saveName));
			int read = 0;
			byte b[] = new byte[1024];
			while( (read = is.read(b)) != -1){
				os.write(b,0,read);
			}
			
			if(is != null){
				is.close();
			}
			os.flush();
			os.close();
			resultMap.put("realName", realName);
			resultMap.put("saveName", saveName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultMap;
	}
}
