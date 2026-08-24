package com.example;


import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.references.BlockItemId;

import java.util.function.Function;

public class Purple_PlanksBlocks {
    public static Block PURPLE_PLANKS = register(
            ModBlockItemIds.PURPLE_PLANKS,
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
    );

    public static void initialize() {}

    private static Block register(
            BlockItemId id,
            Function<BlockBehaviour.Properties,
                    Block> blockFactory,
            BlockBehaviour.Properties properties) {
        // Create the block instance
        Block block = Registry.register(
                BuiltInRegistries.BLOCK,
                id.block(),
                blockFactory.apply(properties.setId(id.block()))
        );

            BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
             Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(Purple_PlanksBlocks.PURPLE_PLANKS.asItem());
        });

        return block;
    }
    }

