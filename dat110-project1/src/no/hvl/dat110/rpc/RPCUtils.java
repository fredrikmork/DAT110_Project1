package no.hvl.dat110.rpc;

import java.util.Arrays;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[1 + str.getBytes().length];

		// marshall RPC identifier and string into byte array

		try {
			encoded[0] = rpcid;
			for (int i = 0; i < str.getBytes().length; i++) {
				encoded[i + 1] = str.getBytes()[i];
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = "";

		// unmarshall String contained in data into decoded
		try {
			decoded = new String(Arrays.copyOfRange(data, 1, data.length));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];
		encoded[0] = rpcid;
		//marshall RPC identifier in case of void type

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// unmarshall void type
		
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array

		if (true) {
			throw new RuntimeException("not yet implemented");
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data

		if (true) {
			throw new RuntimeException("not yet implemented");
		}

		return decoded;

	}
}
