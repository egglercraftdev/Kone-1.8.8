package net.kone;

import net.lax1dude.eaglercraft.v1_8.EagRuntime;
import net.lax1dude.eaglercraft.v1_8.EaglercraftVersion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenResourcePacks;

public class GuiGithubNotAvailable extends GuiScreen{

	 	private final GuiScreen parentScreen;
	    private KoneClientOverlays koneClientOverlay;
	    private Minecraft mc;
	    /**
	     * The title string that is displayed in the top-center of the screen.
	     */
	    
	    protected String screenTitle = "Github Not Available";

	    public GuiGithubNotAvailable(GuiScreen parentScreen, Minecraft mc) {
	        this.parentScreen = parentScreen;
	        this.mc = mc;
	        
	    }
	    
	    public void initGui() {
	    	
	    	this.buttonList.add(new GuiButton(101, this.width / 2 - 150, (int) Math.round(this.height/ 1.2), 125, 20, "Go to 1.5.2 Github"));
	    	this.buttonList.add(new GuiButton(102, this.width / 2 + 25, (int) Math.round(this.height/ 1.2), 125, 20, "Go Back..."));
	    }
	    
	    protected void actionPerformed(GuiButton par1GuiButton) {
	    	if (par1GuiButton.enabled) {
	            if (par1GuiButton.id == 101) {
	            	EagRuntime.openLink(EaglercraftVersion.projectForkURL);
	            }
	            if (par1GuiButton.id == 102) {
	                mc.displayGuiScreen(parentScreen);
	            }
	        }
	    }
	    
	    
	    
	    public void drawScreen(int i, int j, float f) {
			this.drawDefaultBackground();
			this.drawCenteredString(this.fontRendererObj, screenTitle, this.width / 2, 40,
					16777215);
			this.drawCenteredString(this.fontRendererObj, "kone Client 1.8.8 is not open source yet, but you can still go to the 1.5.2 Github.", this.width / 2, this.height / 3 + 10,
					16777215);
			
			super.drawScreen(i, j, f);
			
		}
}
