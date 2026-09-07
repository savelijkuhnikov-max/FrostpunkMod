package com.frostpunk.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HeatSourceBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 14, 14);
    public static final int HEAT_RADIUS = 16;
    public static final int MAX_HEAT_LEVEL = 15;

    public HeatSourceBlock(Properties properties) {
        super(properties
                .lightLevel(state -> 12)
                .strength(2.5f, 7.0f)
                .requiresCorrectToolForDrops());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 12;
    }

    public static int getHeatLevel(BlockGetter level, BlockPos sourcePos, BlockPos targetPos) {
        int distance = (int) sourcePos.distSqr(targetPos);
        if (distance > HEAT_RADIUS * HEAT_RADIUS) return 0;
        return Math.max(0, MAX_HEAT_LEVEL - (distance / 2));
    }
}
