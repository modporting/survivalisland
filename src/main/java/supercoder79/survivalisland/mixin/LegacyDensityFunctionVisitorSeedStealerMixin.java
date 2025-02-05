package supercoder79.survivalisland.mixin;

import org.spongepowered.asm.mixin.Mixin;
import supercoder79.survivalisland.world.util.SeedStealer;

@Mixin(targets = {"net/minecraft/world/gen/noise/NoiseConfig$LegacyNoiseDensityFunctionVisitor"})
public class LegacyDensityFunctionVisitorSeedStealerMixin implements SeedStealer {
    private long seed;
    @Override
    public long steal() {
        return this.seed;
    }

    @Override
    public void set(long seed) {
        this.seed = seed;
    }


}
