package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] marshalling = RPCUtils.marshallString(RPCID, message);
		rmiclient.connect();
		rmiclient.call(marshalling);
		RPCUtils.unmarshallString(marshalling);
		rmiclient.disconnect();
	}
}
