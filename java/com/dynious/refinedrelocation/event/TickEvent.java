package com.dynious.refinedrelocation.event;

import com.dynious.refinedrelocation.lib.Reference;
import com.dynious.refinedrelocation.lib.Settings;
import com.dynious.refinedrelocation.version.VersionChecker;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;


public class TickEvent
{
    private static boolean initialized = false;

    @SubscribeEvent
    public void onClientTick(cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent event)
    {
        if (Settings.DISPLAY_VERSION_RESULT)
        {
            if (!initialized)
            {
                if (event.phase == cpw.mods.fml.common.gameevent.TickEvent.Phase.END)
                {
                    if (FMLClientHandler.instance().getClient().currentScreen == null)
                    {
                        if (VersionChecker.getResult() != VersionChecker.CheckState.UNINITIALIZED)
                        {
                            initialized = true;

                            if (VersionChecker.getResult() == VersionChecker.CheckState.OUTDATED)
                            {
                                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(String.format("Refined Relocation %s is outdated! Latest version: %s", Reference.VERSION, VersionChecker.getRemoteVersion().getModVersion())));
                                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Change log:"));
                                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(String.format(" %s", VersionChecker.getRemoteVersion().getChangeLog())));
                                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Get latest using: '/RefinedRelocation latest'"));
                            }
                        }
                    }
                }
            }
        }
    }
}