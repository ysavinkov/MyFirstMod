package net.outrun.firstmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.outrun.firstmod.FirstMod;

@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab TEST_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TEST_TAB = event.registerCreativeModeTab(new ResourceLocation(FirstMod.MOD_ID, "test_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.TIN.get()))
                        .title(Component.translatable("creativemodetab.test_tab")));
    }
}
