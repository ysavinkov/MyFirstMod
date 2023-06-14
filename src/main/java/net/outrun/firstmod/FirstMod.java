package net.outrun.firstmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.outrun.firstmod.block.ModBlocks;
import net.outrun.firstmod.item.ModCreativeModeTabs;
import net.outrun.firstmod.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FirstMod.MOD_ID)
public class FirstMod {

    public static final String MOD_ID = "firstmod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public FirstMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.TIN);
            event.accept(ModItems.RAW_TIN);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.TIN_BLOCK);
        }

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.TIN_ORE);
            event.accept(ModBlocks.DEEPSLATE_TIN_ORE);
        }

        if (event.getTab() == ModCreativeModeTabs.TEST_TAB) {
            event.accept(ModItems.TIN);
            event.accept(ModItems.RAW_TIN);
            event.accept(ModBlocks.TIN_BLOCK);
            event.accept(ModBlocks.TIN_ORE);
            event.accept(ModBlocks.DEEPSLATE_TIN_ORE);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
