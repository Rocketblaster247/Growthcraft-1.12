package growthcraft.core.common.item;

import growthcraft.core.shared.Reference;
import growthcraft.core.shared.init.GrowthcraftCoreBlocks;
import growthcraft.core.shared.GrowthcraftLogger;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemRope extends Item {

    public ItemRope(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        GrowthcraftLogger.debugDumpLog(Reference.MODID, worldIn, pos);

        Block block = worldIn.getBlockState(pos).getBlock();

        if (block == Blocks.OAK_FENCE) {
            // If the target block is a BlockFence, then replace it with a RopeKnot block.
            worldIn.setBlockState(pos, GrowthcraftCoreBlocks.rope_knot.getDefaultState());
            // Decrease the player inventory as we used the rope.
            player.getHeldItem(hand).shrink(1);
            return EnumActionResult.SUCCESS;

        } else if (worldIn.getBlockState(pos.offset(facing)).getBlock().canPlaceBlockAt(worldIn, pos.offset(facing))) {
            // Since we are not using this item on a BlockFence, check to see if we can place a
            // block on the side we are selecting.
            worldIn.setBlockState(pos.offset(facing), GrowthcraftCoreBlocks.rope_fence.getDefaultState());
            player.getHeldItem(hand).shrink(1);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }


}
