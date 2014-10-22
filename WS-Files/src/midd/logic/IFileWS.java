package midd.logic;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService
@SOAPBinding(style = Style.RPC)

public interface IFileWS {
	@WebMethod byte[] downloadFile(String name);
	@WebMethod String uploadFile(String name, byte[] data);
}
