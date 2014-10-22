package midd.ws.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import midd.datatypes.DataParse;
import midd.logic.FileWSService;
import midd.logic.Utils;

public class Client {

	public static void downloadFile(String name, String rename) throws IOException{

		FileWSService ws = new FileWSService();
		midd.logic.IFileWS port = ws.getFileWSPort();
		byte[] data = port.downloadFile(name);
		
		if(data != null){
			FileOutputStream save = new FileOutputStream(rename);
			save.write(data);
			save.flush();	
			save.close();
			System.out.println("OK::File Downloaded.");
		}else{
			System.out.println("ERROR::File not exists.");
		}
		
	}
	
	public static void uploadFile(String name, String rename) throws IOException{
		
		FileWSService ws = new FileWSService();
		midd.logic.IFileWS port = ws.getFileWSPort();
		File file = new File(name);
		byte [] base64 = new byte[(int)file.length()];
		FileInputStream rip =  new FileInputStream(file);
		rip.read(base64);
		rip.close();
		String message = port.uploadFile(rename, base64);
		System.out.println(message);
		
	}
	
	public static void main(String [] args){
		
		Utils utils = new Utils();
		try {
			DataParse parse = utils.ParseArgs(args);
			if(parse.isDownload())
				downloadFile(parse.getFileName(), parse.getFileRename());
			else 
				uploadFile(parse.getFileName(), parse.getFileRename());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
