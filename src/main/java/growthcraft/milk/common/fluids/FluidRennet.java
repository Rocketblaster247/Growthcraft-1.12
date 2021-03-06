package growthcraft.milk.common.fluids;

import growthcraft.core.shared.fluids.GrowthcraftFluid;
import growthcraft.milk.shared.Reference;
import net.minecraft.util.ResourceLocation;

public class FluidRennet extends GrowthcraftFluid {

    public FluidRennet(String unlocalizedName) {
        super(unlocalizedName, new ResourceLocation(Reference.MODID, "blocks/fluids/" + unlocalizedName + "_still"), new ResourceLocation(Reference.MODID, "blocks/fluids/" + unlocalizedName + "_flow"));
        this.setUnlocalizedName(unlocalizedName);
    }
}
