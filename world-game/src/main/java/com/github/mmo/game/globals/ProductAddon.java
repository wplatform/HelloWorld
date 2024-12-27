package game;public class ProductAddon
{
	private int displayInfoEntry;
	public final int getDisplayInfoEntry()
	{
		return displayInfoEntry;
	}
	public final void setDisplayInfoEntry(int value)
	{
		displayInfoEntry = value;
	}
	private byte disableListing;
	public final byte getDisableListing()
	{
		return disableListing;
	}
	public final void setDisableListing(byte value)
	{
		disableListing = value;
	}
	private byte disableBuy;
	public final byte getDisableBuy()
	{
		return disableBuy;
	}
	public final void setDisableBuy(byte value)
	{
		disableBuy = value;
	}
	private byte nameColorIndex;
	public final byte getNameColorIndex()
	{
		return nameColorIndex;
	}
	public final void setNameColorIndex(byte value)
	{
		nameColorIndex = value;
	}
	private String scriptName = "";
	public final String getScriptName()
	{
		return scriptName;
	}
	public final void setScriptName(String value)
	{
		scriptName = value;
	}
	private String comment = "";
	public final String getComment()
	{
		return comment;
	}
	public final void setComment(String value)
	{
		comment = value;
	}
}
