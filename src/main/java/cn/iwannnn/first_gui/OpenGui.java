package cn.iwannnn.first_gui;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;

public class OpenGui {
    public static void openGUI() {
        Minecraft.getInstance().displayGuiScreen(new FirstGui(new StringTextComponent("test")));
    }
}
