package game;


class WardenModuleTransfer
{
	public WardenOpcodes command = WardenOpcodes.values()[0];
	public short dataSize;
	public byte[] data = new byte[500];

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator byte[](WardenModuleTransfer transfer)
//		{
//			var buffer = new byteBuffer();
//			buffer.writeInt8((byte)transfer.command);
//			buffer.writeInt16(transfer.dataSize);
//			buffer.writeBytes(transfer.data, 500);
//
//			return buffer.getData();
//		}
}
