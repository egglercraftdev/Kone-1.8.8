package net.kone;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.client.gui.GuiButton;

public class GuiXrayDetected extends GuiScreen{
	
	
	
	/**
     * A reference to the screen object that created this. Used for navigating
     * between screens.
     */
    private final GuiScreen parentScreen;
    /**
     * The title string that is displayed in the top-center of the screen.
     */
    
    protected String screenTitle = EnumChatFormatting.BOLD +""+ EnumChatFormatting.UNDERLINE + "X-RAY Texture Pack Detected" + EnumChatFormatting.RESET;

    public GuiXrayDetected(GuiScreen par1GuiScreen) {
        parentScreen = par1GuiScreen;
    }
    
    public void initGui() {
    	this.buttonList.add(new GuiButton(101, this.width / 2 - 150, (int) Math.round(this.height/ 1.2), 125, 20, "Resource Packs..."));
    	this.buttonList.add(new GuiButton(102, this.width / 2 + 25, (int) Math.round(this.height/ 1.2), 125, 20, "Go Back..."));
        
    }
    
    protected void actionPerformed(GuiButton par1GuiButton) {
    	if (par1GuiButton.enabled) {
            if (par1GuiButton.id == 101) {
                mc.displayGuiScreen(new GuiScreenResourcePacks(parentScreen));
            }
            if (par1GuiButton.id == 102) {
                mc.displayGuiScreen(parentScreen);
            }
        }
    }
    
    
    
    public void drawScreen(int par1, int par2, float par3) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 30, 14417920);
        this.drawCenteredString(this.fontRendererObj, "You have a X-RAY Texture Pack enabled, please disable it to", this.width / 2, this.height / 3, 16777215);
        this.drawCenteredString(this.fontRendererObj, "play on this X-RAY protected server.", this.width / 2, this.height / 3 + 10, 16777215);
        this.drawCenteredString(this.fontRendererObj, "This could be caused by a texture pack you have enabled,", this.width / 2, this.height / 2, 16777215);
        this.drawCenteredString(this.fontRendererObj, "try disabling it to play on this server.", this.width / 2 , this.height / 2 + 10, 16777215);
        
        super.drawScreen(par1, par2, par3);
    }

}
