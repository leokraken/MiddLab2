package midd.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
@MTOM
@WebService(endpointInterface = "midd.logic.IFileWS")
public class FileWS implements IFileWS {
	private final String path = "pdf/";
	
	@Override
	public byte[] downloadFile(String filename){
		//creates dir
		Boolean dir = new File("pdf").mkdir();
		File file =  new File(path + filename);
		byte [] base64;
		if(file.exists()){
			base64 = new byte[(int)file.length()];
			try {
				FileInputStream rip = new FileInputStream(file);
				rip.read(base64);
				rip.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return base64;
	}
		
	@Override
	public String uploadFile(String name, byte[] data) {
		FileOutputStream save;
		Boolean dir = new File("pdf").mkdir();
		System.out.println(System.getProperty("user.dir"));
		try {
			
			String filename = path + name;
			File file = new File(filename);
			if(file.exists()){
				return "ERROR::File name already exists.";
			}
			save = new FileOutputStream(filename);
			save.write(data);
			//data.writeTo(save);
			save.flush();
			save.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "OK::File Uploaded.";
	}

}
