package cn.iwannnn.first_gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.OptionSlider;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class FirstGui extends Screen {
    TextFieldWidget textFieldWidget;
    Button button;
    OptionSlider optionSlider;
    ResourceLocation FIRST_GUI_TEXTURE = new ResourceLocation("iwannnn", "textures/gui/first_gui.jpg");
    String content = "Hello Minecraft";
    SliderPercentageOption sliderPercentageOption;
    Widget sliderBar;

    protected FirstGui(ITextComponent titleIn) {
        super(titleIn);
    }

    @Override
    protected void init() {
        this.minecraft.keyboardListener.enableRepeatEvents(true);
        // public TextFieldWidget(net.minecraft.client.gui.FontRenderer p_i51137_1_,
        // intp_i51137_2_, int p_i51137_3_, int p_i51137_4_, int
        // p_i51137_5_,java.lang.String p_i51137_6_) {}
        this.textFieldWidget = new TextFieldWidget(this.font, this.width / 2 - 100, 66, 200, 20, "Context");// 设置长款xy坐标
        this.children.add(this.textFieldWidget);// 添加组件
        // public Button(int p_i51141_1_, int p_i51141_2_, int p_i51141_3_, int
        // p_i51141_4_, java.lang.String p_i51141_5_,
        // net.minecraft.client.gui.widget.button.Button.IPressable p_i51141_6_) {}
        this.button = new Button(this.width / 2 - 40, 96, 80, 20, "Space", (button) -> {
        });
        this.addButton(this.button);
        // public SliderPercentageOption(java.lang.String p_i51155_1_,
        // double p_i51155_2_, double p_i51155_4_, float p_i51155_6_,
        // java.util.function.Function<net.minecraft.client.GameSettings,java.lang.Double>
        // p_i51155_7_,
        // java.util.function.BiConsumer<net.minecraft.client.GameSettings,java.lang.Double>
        // p_i51155_8_,
        // java.util.function.BiFunction<net.minecraft.client.GameSettings,net.minecraft.client.settings.SliderPercentageOption,java.lang.String>
        // p_i51155_9_) {}
        this.sliderPercentageOption = new SliderPercentageOption("iwannnn.sliderbar", 5, 100, 5, (setting) -> {
            return Double.valueOf(0);
        }, (setting, value) -> {
        }, (gameSettings, sliderPercentageOption) -> "test");// 第五个和第六个参数是getter和setter 第七个参数滚动条底部文字
        // public net.minecraft.client.gui.widget.Widget
        // createWidget(net.minecraft.client.GameSettings p_216586_1_, int p_216586_2_,
        // int p_216586_3_, int p_216586_4_) {
        // return null;
        // }
        this.sliderBar = this.sliderPercentageOption.createWidget(Minecraft.getInstance().gameSettings,
                this.width / 2 - 100, 120, 200);
        this.children.add(this.sliderBar);
        super.init();
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTick) {
        this.renderBackground();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);// RGBA
        this.minecraft.getTextureManager().bindTexture(FIRST_GUI_TEXTURE);
        int textureWidth = 208;
        int textureHeight = 156;
        // public static void blit(int p_blit_0_, int p_blit_1_, int p_blit_2_, int
        // p_blit_3_, float p_blit_4_, float p_blit_5_, int p_blit_6_, int p_blit_7_,
        // int p_blit_8_, int p_blit_9_) {}
        this.blit(this.width / 2 - 150, 10, 0, 0, 300, 200, textureWidth, textureHeight);
        // public void drawString(net.minecraft.client.gui.FontRenderer p_drawString_1_,
        // java.lang.String p_drawString_2_, int p_drawString_3_, int p_drawString_4_,
        // int p_drawString_5_) {}
        this.drawString(this.font, content, this.width / 2 - 60, 30, 0x000000);

        this.textFieldWidget.render(mouseX, mouseY, partialTick);
        this.button.render(mouseX, mouseY, partialTick);
        this.sliderBar.render(mouseX, mouseY, partialTick);
        super.render(mouseX, mouseY, partialTick);
    }

}
