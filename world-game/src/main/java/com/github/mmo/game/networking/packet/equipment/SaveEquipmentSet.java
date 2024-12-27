package com.github.mmo.game.networking.packet.equipment;


import com.github.mmo.game.entity.player.EquipmentSetInfo;
import com.github.mmo.game.networking.*;

public class SaveEquipmentSet extends ClientPacket
{
	public EquipmentsetInfo.EquipmentsetData set;

	public SaveEquipmentSet(WorldPacket packet)
	{
		super(packet);
		set = new EquipmentSetInfo.EquipmentSetData();
	}

	@Override
	public void read()
	{
		set.setType(EquipmentSetInfo.EquipmentSetType.forValue(this.readInt32()));
		set.setGuid(this.readUInt64());
		set.setId(this.readUInt());
		set.setIgnoreMask(this.readUInt());

		for (byte i = 0; i < EquipmentSlot.End; ++i)
		{
			set.getPieces()[i] = this.readPackedGuid();
			set.getAppearances()[i] = this.readInt32();
		}

		set.getEnchants()[0] = this.readInt32();
		set.getEnchants()[1] = this.readInt32();

		set.setSecondaryShoulderApparanceId(this.readInt32());
		set.setSecondaryShoulderSlot(this.readInt32());
		set.setSecondaryWeaponAppearanceId(this.readInt32());
		set.setSecondaryWeaponSlot(this.readInt32());

		var hasSpecIndex = this.readBit();

		var setNameLength = this.<Integer>readBit(8);
		var setIconLength = this.<Integer>readBit(9);

		if (hasSpecIndex)
		{
			set.setAssignedSpecIndex(this.readInt32());
		}

		set.setName(this.readString(setNameLength));
		set.setIcon(this.readString(setIconLength));
	}
}
