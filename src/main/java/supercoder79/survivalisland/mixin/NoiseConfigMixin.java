package supercoder79.survivalisland.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.noise.NoiseConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import supercoder79.survivalisland.world.util.SeedStealer;

@Mixin(NoiseConfig.class)
public class NoiseConfigMixin {
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/gen/noise/NoiseRouter;apply(Lnet/minecraft/world/gen/densityfunction/DensityFunction$DensityFunctionVisitor;)Lnet/minecraft/world/gen/noise/NoiseRouter;"))
    private DensityFunction.DensityFunctionVisitor wrapper(DensityFunction.DensityFunctionVisitor visitor, @Local(argsOnly = true) long seed){
        if(visitor instanceof SeedStealer stealer){
            stealer.set(seed);
        }
        return visitor;
    }
}
