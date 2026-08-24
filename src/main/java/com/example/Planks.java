package com.example;

import com.jcraft.jorbis.Block;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.references.BlockItemId;

import java.util.function.Function;

public class Planks {
    public static Block PURPLE_PLANKS = register(
            ModBlockItemIds.PURPLE_PLANKS,
            (properties) -> new PurplePlanks(new ColorRGBA(0xB792FFFF), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
    );

    public static void initialize() {}

    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Create the block instance
        Block block = Registry.register(
                BuiltInRegistries.BLOCK,
                id.block(),
                blockFactory.apply(properties.setId(id.block()))
        );

        return block;
    }
    }

