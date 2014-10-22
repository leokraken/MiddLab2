package midd.logic;

import javax.xml.ws.Endpoint;

public class WSPublisher {
	public static void main(String []args){
		Endpoint.publish("http://localhost:9999/ws/updown", new FileWS());
	}
}
