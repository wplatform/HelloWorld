package game;


public class CreatureTextEntry
{
	public int creatureId;
	public byte groupId;
	public byte id;
	public String text;
	public ChatMsg type = ChatMsg.values()[0];
	public Language lang = language.values()[0];
	public float probability;
	public Emote emote = emote.values()[0];
	public int duration;
	public int sound;
	public SoundKitPlayType soundPlayType = SoundKitPlayType.values()[0];
	public int broadcastTextId;
	public CreaturetextRange textRange = CreatureTextRange.values()[0];
}