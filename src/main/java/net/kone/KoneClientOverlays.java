package net.kone;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiOverlayDebug;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;

public class KoneClientOverlays extends Gui {
	
	private Minecraft mc;
	private FontRenderer fontRenderer;
	public boolean debugMods;
	
	public KoneClientOverlays(Minecraft mc) {
		this.mc = mc;
		this.fontRenderer = mc.fontRendererObj;
	}
	
	public void drawFPS(int x, int y) {
		if (this.mc.gameSettings.keyStrokesMod) {
			int fpsPos = 50;

			if (Minecraft.getDebugFPS() < 10) {
				fpsPos = 50;
			}
			else if (Minecraft.getDebugFPS() < 100) {
				fpsPos = 48;
			}
			else {
				fpsPos = 46;
			}
			
			drawGradientRect(17, 165, 113, 190, -1072689136, -804253680);
			this.fontRenderer.drawStringWithShadow(""+Minecraft.getDebugFPS()+" FPS", fpsPos, 174, 0xFFFFFF);
		}
		else {
			int fpsPos = 50;

			if (Minecraft.getDebugFPS() < 10) {
				fpsPos = 50;
			}
			else if (Minecraft.getDebugFPS() < 100) {
				fpsPos = 48;
			}
			else {
				fpsPos = 46;
			}
			
			drawGradientRect(17, 17, 113, 42, -1072689136, -804253680);
			this.fontRenderer.drawStringWithShadow(""+Minecraft.getDebugFPS()+" FPS", fpsPos, 26, 0xFFFFFF);
		}
		if (debugMods) {
			this.drawHorizontalLine(1,100,100,999999999);
		}
		
	}
	
	public void drawKeyStrokes() {
		
		this.drawGradientRect(50, 20, 80, 50, -1072689136, -804253680);
		this.drawGradientRect(50, 53, 80, 83, -1072689136, -804253680);
		this.drawGradientRect(17, 53, 47, 83, -1072689136, -804253680);
		this.drawGradientRect(83, 53, 113, 83, -1072689136, -804253680);
		this.drawGradientRect(17, 86, 64, 116, -1072689136, -804253680);
		this.drawGradientRect(66, 86, 113, 116, -1072689136, -804253680);
		this.drawGradientRect(17, 119, 113, 139, -1072689136, -804253680);
		this.drawGradientRect(17, 141, 113, 162, -1072689136, -804253680);
		
						
					
		if (mc.gameSettings.keyBindForward.isKeyDown()) {
		    this.drawGradientRect(50, 20, 80, 50, 0x88FFFFFF, 0x88FFFFFF);
		}
		if (mc.gameSettings.keyBindLeft.isKeyDown()) {
		    this.drawGradientRect(17, 53, 47, 83, 0x88FFFFFF, 0x88FFFFFF);
		}
		if (mc.gameSettings.keyBindBack.isKeyDown()) {
		    this.drawGradientRect(50, 53, 80, 83, 0x88FFFFFF, 0x88FFFFFF);
		}
		if (mc.gameSettings.keyBindRight.isKeyDown()) {
		    this.drawGradientRect(83, 53, 113, 83, 0x88FFFFFF, 0x88FFFFFF);
		}
		if (mc.gameSettings.keyBindJump.isKeyDown()) {
		    this.drawGradientRect(17, 119, 113, 139, 0x88FFFFFF, 0x88FFFFFF);
		}
		if (mc.gameSettings.keyBindSneak.isKeyDown()) {
		    this.drawGradientRect(17, 141, 113, 162, 0x88FFFFFF, 0x88FFFFFF);
		}
		if (mc.gameSettings.keyBindAttack.isKeyDown()) {
			
		    this.drawGradientRect(17, 86, 64, 116, 0x88FFFFFF, 0x88FFFFFF);
		}
		if (mc.gameSettings.keyBindUseItem.isKeyDown()) {
			
		    this.drawGradientRect(66, 86, 113, 116, 0x88FFFFFF, 0x88FFFFFF);
		}
						
		this.fontRenderer.drawStringWithShadow("W",  63, 32, 0xFFFFFF);
		this.fontRenderer.drawStringWithShadow("A", 30, 65, 0xFFFFFF);
		this.fontRenderer.drawStringWithShadow("S",  63, 65, 0xFFFFFF);
		this.fontRenderer.drawStringWithShadow("D", 96, 65, 0xFFFFFF);
		this.fontRenderer.drawStringWithShadow("Left", 31, 98, 0xFFFFFF);
		this.fontRenderer.drawStringWithShadow("Right", 78, 98, 0xFFFFFF);
		/* 
		var8.drawStringWithShadow("LMB", 24, 74, 0xFFFFFF);
		var8.drawStringWithShadow("RMB", 64, 74, 0xFFFFFF);
		*/
		this.fontRenderer.drawStringWithShadow("\u00A7m--------", 42, 130, 0xFFFFFF);
		this.fontRenderer.drawStringWithShadow("Sneak", 52, 148, 0xFFFFFF);
		
	}
	
	
	

	public void drawXYZ(int x, int y) {
		
		
		Entity e = mc.getRenderViewEntity();
		BlockPos blockpos = new BlockPos(e.posX, e.getEntityBoundingBox().minY, e.posZ);
		ScaledResolution dis = new ScaledResolution(this.mc);
		int vw = dis.getScaledWidth();
		drawGradientRect(vw - 120, 13,vw - 13, 65, -1072689136, -804253680);
		this.fontRenderer.drawStringWithShadow("[X: " + MathHelper.floor_double(blockpos.getX()) + "]", vw - 113, 20, 16777215);
		this.fontRenderer.drawStringWithShadow("[Y: " + MathHelper.floor_double(blockpos.getY()) + "]", vw - 113, 30, 16777215);
		this.fontRenderer.drawStringWithShadow("[Z: " + MathHelper.floor_double(blockpos.getZ()) + "]", vw - 113, 40, 16777215);
		String colorDirections = "";
		Entity entity = this.mc.getRenderViewEntity();
		EnumFacing enumfacing = entity.getHorizontalFacing();
		
		switch (enumfacing){
		case NORTH: 
			colorDirections = EnumChatFormatting.RED + "North" + EnumChatFormatting.RESET;
			break;
		case WEST:
			colorDirections = EnumChatFormatting.YELLOW + "West" + EnumChatFormatting.RESET;
			break;
		case EAST:
			colorDirections = EnumChatFormatting.BLUE + "East" + EnumChatFormatting.RESET;
			break;
		case SOUTH:
			colorDirections = EnumChatFormatting.GREEN + "South" + EnumChatFormatting.RESET;
			break;
		}
		this.fontRenderer.drawStringWithShadow("[Direction: " + colorDirections + "]", vw - 113, 50, 16777215);
		
	}

}
