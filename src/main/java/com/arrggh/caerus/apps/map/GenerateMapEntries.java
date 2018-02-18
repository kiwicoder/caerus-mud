package com.arrggh.caerus.apps.map;

import com.arrggh.caerus.data.impl.map.RoomData;
import com.arrggh.caerus.model.impl.map.Room;

public class GenerateMapEntries {


    public void generate(Directories directories) {
        RoomData roomData = new RoomData(() -> directories.getRoomDirectory());

        roomData.write(new Room(RoomIdentifiers.WelcomeRoom, "Welcome Room", null));
        roomData.write(new Room(RoomIdentifiers.DeathsOffice, "Death's Office", null));

        roomData.write(new Room(RoomIdentifiers.VillageSquareNW, "Village Square (NW)", null));
        roomData.write(new Room(RoomIdentifiers.VillageSquareN, "Village Square (N)", null));
        roomData.write(new Room(RoomIdentifiers.VillageSquareNE, "Village Square (NE)", null));
        roomData.write(new Room(RoomIdentifiers.VillageSquareW, "Village Square (W)", null));
        roomData.write(new Room(RoomIdentifiers.VillageSquareC, "Village Square (C)", null));
        roomData.write(new Room(RoomIdentifiers.VillageSquareE, "Village Square (E)", null));
        roomData.write(new Room(RoomIdentifiers.VillageSquareSW, "Village Square (SW)", null));
        roomData.write(new Room(RoomIdentifiers.VillageSquareS, "Village Square (S)", null));
        roomData.write(new Room(RoomIdentifiers.VillageSquareSE, "Village Square (SE)", null));

        roomData.write(new Room(RoomIdentifiers.EmptyShopGroundNW, "Empty Shop Ground Floor (NW)", null));
        roomData.write(new Room(RoomIdentifiers.EmptyShopGroundNE, "Empty Shop Ground Floor (NE)", null));
        roomData.write(new Room(RoomIdentifiers.EmptyShopGroundSW, "Empty Shop Ground Floor (SW)", null));
        roomData.write(new Room(RoomIdentifiers.EmptyShopGroundSE, "Empty Shop Ground Floor (SE)", null));

        roomData.write(new Room(RoomIdentifiers.EmptyShopFirstNW, "Empty Shop First Floor (NW)", null));
        roomData.write(new Room(RoomIdentifiers.EmptyShopFirstNW, "Empty Shop First Floor (NE)", null));
        roomData.write(new Room(RoomIdentifiers.EmptyShopFirstNW, "Empty Shop First Floor (SW)", null));
        roomData.write(new Room(RoomIdentifiers.EmptyShopFirstNW, "Empty Shop First Floor (SE)", null));

        roomData.write(new Room(RoomIdentifiers.WeaponShop, "Weapon Shop", null));
        roomData.write(new Room(RoomIdentifiers.ArmorShop, "Armor Shop", null));
        roomData.write(new Room(RoomIdentifiers.MagicShop, "Magic Shop", null));

    }
}
