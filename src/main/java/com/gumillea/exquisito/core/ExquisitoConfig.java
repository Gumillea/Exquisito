package com.gumillea.exquisito.core;

import com.teamabnormals.blueprint.core.annotations.ConfigKey;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ExquisitoConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();

        Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();
    }
    public static class Common {
        @ConfigKey("enable_chorus_flavor")
        public static ForgeConfigSpec.BooleanValue CHORUS_FLAVOR;
        @ConfigKey("enable_elmond_flavor")
        public static ForgeConfigSpec.BooleanValue ELMOND_FLAVOR;
        @ConfigKey("enable_jelly_ring_flavor")
        public static ForgeConfigSpec.BooleanValue JELLY_RING_FLAVOR;
        @ConfigKey("enable_zure_berry_flavor")
        public static ForgeConfigSpec.BooleanValue ZURE_BERRY_FLAVOR;
        @ConfigKey("enable_ether_bulb_flavor")
        public static ForgeConfigSpec.BooleanValue ETHER_BULB_FLAVOR;
        @ConfigKey("enable_nightshade_berry_flavor")
        public static ForgeConfigSpec.BooleanValue NIGHTSHADE_BERRY_FLAVOR;
        public static ForgeConfigSpec.BooleanValue FUCHSIA_GOO_SPREAD;
        public static ForgeConfigSpec.BooleanValue SPACE_DIVING_LIMITATION;
        public static ForgeConfigSpec.BooleanValue FOOD_MODIFICATION;
        public static ForgeConfigSpec.BooleanValue ENLIGHTEND_MODIFICATION;
        public static ForgeConfigSpec.BooleanValue ENDS_DELIGHT_MODIFICATION;
        public static ForgeConfigSpec.BooleanValue UNUSUAL_END_MODIFICATION;
        public static ForgeConfigSpec.BooleanValue BYG_MODIFICATION;
        public static ForgeConfigSpec.BooleanValue ENDERS_DELIGHT_MODIFICATION;
        public static ForgeConfigSpec.BooleanValue VC_MODIFICATION;

        Common(ForgeConfigSpec.Builder builder) {
        builder.push("Flavors");
        builder.push("Basic Flavors");
        CHORUS_FLAVOR = builder.comment("Whether to enable the Chorus Fruit flavor.").define("Chorus Flavor", true);
        ELMOND_FLAVOR = builder.comment("Whether to enable the Elmond flavor.").define("Elmond Flavor", true);
        builder.pop();
        builder.push("Compatible Flavors");
        builder.push("Enlightend Flavors");
        JELLY_RING_FLAVOR = builder.comment("Whether to enable the Jelly Ring flavor.").define("Jelly Ring Flavor", true);
        ZURE_BERRY_FLAVOR = builder.comment("Whether to enable the Zure Berry flavor.").define("Zure Berry Flavor", true);
        builder.pop();
        builder.push("Oh The Biomes You'll Go Flavors");
        ETHER_BULB_FLAVOR = builder.comment("Whether to enable the Ether Bulb flavor.").define("Ether Bulb Flavor", true);
        NIGHTSHADE_BERRY_FLAVOR = builder.comment("Whether to enable the Nightshade Berry flavor.").define("Nightshade Berry Flavor", true);
        builder.pop();
        builder.pop();
        builder.pop();
        builder.push("Effects");
        FUCHSIA_GOO_SPREAD = builder.comment("Whether to enable the \"jelly-spreading\" effect when Fuchsia Goo is removed by death or Chocolate Ringling.").define("Fuchsia Goo Spread", true);
        SPACE_DIVING_LIMITATION = builder.comment("Whether to enable the damage limitation of Space Diving.").define("Space Diving Limitation", true);
        builder.pop();
        builder.push("Compatibility");
        builder.push("Global Setting");
        FOOD_MODIFICATION = builder.comment("Whether to enable the food modifications for Vanilla and Compatible Mods.").define("Enable Modifications", true);
        builder.pop();
        builder.push("Specific Settings");
        ENLIGHTEND_MODIFICATION = builder.comment("Whether to enable the modifications for Enlightend.").define("Enlightend Modification", true);
        BYG_MODIFICATION = builder.comment("Whether to enable the modifications for Oh The Biomes You'll Go.").define("Oh The Biomes You'll Go Modification", true);
        ENDS_DELIGHT_MODIFICATION = builder.comment("Whether to enable the modifications for End's Delight.").define("End's Delight Compatibility", true);
        UNUSUAL_END_MODIFICATION = builder.comment("Whether to enable the modifications for Unusual End.").define("Unusual End Compatibility", true);
        ENDERS_DELIGHT_MODIFICATION = builder.comment("Whether to enable the modifications for Ender's Delight.").define("Ender's Delight Compatibility", true);
        VC_MODIFICATION = builder.comment("Whether to enable the modifications for Vanilla Cookbook.").define("Vanilla Cookbook Compatibility", true);
        builder.pop();
        builder.pop();
        }
    }
    public static class Client {
        public static ForgeConfigSpec.BooleanValue SPACE_DIVING_SFX;
        Client(ForgeConfigSpec.Builder builder) {
            SPACE_DIVING_SFX = builder.comment("Whether to enable the totem-like optical effect of Space Diving.").define("Space Diving Optical Effect", true);
        }
    }
}
