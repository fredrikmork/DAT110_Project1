package no.hvl.dat110.rpc;

import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	public void connect() {
		
		//connect using the underlying messaging layer connection
		try {
			connection = msgclient.connect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void disconnect() {
		
		//disconnect/close the underlying messaging connection
		
		try {
			if(connection != null) {
				connection.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public byte[] call(byte[] rpcrequest) {
		Message decapsulate = new Message(rpcrequest);
		connection.send(decapsulate);
		Message encapsulate = connection.receive();
		
		byte[] rpcreply= encapsulate.getData();
		
		/* 
		
		Make a remote call on the RPC server by sending a request message
		and receive a reply message
		
		rpcrequest is the marshalled rpcrequest from the client-stub
		rpctreply is the rpcreply to be unmarshalled by the client-stub
		
		*/
		
		return rpcreply;
		
	}

}
