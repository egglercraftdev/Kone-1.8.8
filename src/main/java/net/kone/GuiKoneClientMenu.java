package net.kone;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;

public class GuiKoneClientMenu extends GuiScreen{
	/**
     * A reference to the screen object that created this. Used for navigating
     * between screens.
     */
    private final GuiScreen parentScreen;
    private KoneClientOverlays koneClientOverlay;
    private Minecraft mc;
    /**
     * The title string that is displayed in the top-center of the screen.
     */
    
    protected String screenTitle = "kone Client Menu";

    public GuiKoneClientMenu(GuiScreen parentScreen, Minecraft mc) {
        this.parentScreen = parentScreen;
        this.mc = mc;
        //this.koneClientOverlay = new KoneClientOverlays(this.mc);
        //koneClientOverlay.debugMods = true;
    }
    
    public void initGui() {
    	
        
    }
    
    protected void actionPerformed(GuiButton par1GuiButton) {
    	
    }
    
    
    
    public void drawScreen(int i, int j, float f) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRendererObj, screenTitle, this.width / 2, 40,
				16777215);
		//koneClientOverlay.drawFPS(0, 0);
		//koneClientOverlay.drawKeyStrokes();
		//koneClientOverlay.drawXYZ(0, 0);
		
		super.drawScreen(i, j, f);
		
	}
}
