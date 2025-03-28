package com.gumillea.exquisito.core.data;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoTrimMaterials;
import com.gumillea.exquisito.core.reg.ExquisitoTrimPatterns;
import com.teamabnormals.blueprint.core.api.BlueprintTrims;
import net.minecraft.client.renderer.texture.atlas.sources.DirectoryLister;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SpriteSourceProvider;

public class ExquisitoSpriteSourceProvider  extends SpriteSourceProvider {
    public ExquisitoSpriteSourceProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, helper, Exquisito.MODID);
    }

    @Override
    protected void addSources() {
        this.atlas(BlueprintTrims.ARMOR_TRIMS_ATLAS)
                .addSource(BlueprintTrims.materialPatternPermutations(
                        ExquisitoTrimMaterials.CARMOTINE,
                        ExquisitoTrimMaterials.CHORUS
                ))
                .addSource(BlueprintTrims.patternPermutationsOfVanillaMaterials(
                        ExquisitoTrimPatterns.EMBRYO,
                        ExquisitoTrimPatterns.KNOT
                        ));
        this.atlas(SpriteSourceProvider.BLOCKS_ATLAS)
                .addSource(new DirectoryLister("entity/toolbox", "entity/toolbox/"))
                .addSource(BlueprintTrims.materialPermutationsForItemLayers(
                        ExquisitoTrimMaterials.CARMOTINE,
                        ExquisitoTrimMaterials.CHORUS
                ));
    }

}

