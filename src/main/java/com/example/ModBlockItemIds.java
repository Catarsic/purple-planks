package com.example;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ModBlockItemIds {
    public static BlockItemId PURPLE_SAND = create("purple_planks");

    private static BlockItemId create(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(PurplePlanks.MOD_ID, name);
        return BlockItemId.create(id, id);
    }
}

