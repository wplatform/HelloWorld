package game;


class WardenHashRequest {
    public WardenOpcodes command = WardenOpcodes.values()[0];
    public byte[] seed = new byte[16];

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator byte[](WardenHashRequest request)
//		{
//			var buffer = new byteBuffer();
//			buffer.writeInt8((byte)request.command);
//			buffer.writeBytes(request.seed);
//
//			return buffer.getData();
//		}
}
