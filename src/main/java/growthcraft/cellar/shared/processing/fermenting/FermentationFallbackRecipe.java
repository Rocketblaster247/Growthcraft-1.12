package growthcraft.cellar.shared.processing.fermenting;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import growthcraft.core.shared.definition.IMultiFluidStacks;
import growthcraft.core.shared.definition.IMultiItemStacks;
import growthcraft.core.shared.fluids.FluidTest;
import growthcraft.core.shared.item.ItemTest;
import growthcraft.core.shared.item.MultiItemStacks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class FermentationFallbackRecipe implements IFermentationRecipe {
    private final IMultiFluidStacks inputFluidStack;
    private final FluidStack outputFluidStack;
    private final int time;

    public FermentationFallbackRecipe(@Nonnull IMultiFluidStacks pInputFluidStack, @Nonnull FluidStack pOutputFluidStack, int pTime) {
        this.inputFluidStack = pInputFluidStack;
        this.outputFluidStack = pOutputFluidStack;
        this.time = pTime;
    }

    @Override
    public IMultiFluidStacks getInputFluidStack() {
        return inputFluidStack;
    }

    @Override
    public FluidStack getOutputFluidStack() {
        return outputFluidStack;
    }

    @Override
    public int getTime() {
        return time;
    }

    @Override
    public boolean matchesRecipe(@Nullable FluidStack fluidStack, @Nullable ItemStack itemStack) {
        if (FluidTest.isValid(fluidStack) && ItemTest.isValid(itemStack)) {
            return FluidTest.hasEnough(inputFluidStack, fluidStack);
        }
        return false;
    }

    @Override
    public boolean matchesIngredient(@Nullable FluidStack fluidStack) {
        return FluidTest.fluidMatches(inputFluidStack, fluidStack);
    }

    @Override
    public boolean matchesIngredient(@Nullable ItemStack stack) {
        return true;
    }

    @Override
    public boolean isItemIngredient(ItemStack stack) {
        return true;
    }

    @Override
    public IMultiItemStacks getFermentingItemStack() {
        return MultiItemStacks.EMPTY;
    }
}
