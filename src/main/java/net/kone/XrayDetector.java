package net.kone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

public class XrayDetector{
	//private ResourceLocation grassSideTexturePath = new ResourceLocation("textures/blocks/grass_side.png");
	private ResourceLocation grassTopTexturePath = new ResourceLocation("textures/blocks/grass_top.png");
	private ResourceLocation grassBlockJson = new ResourceLocation("models/block/grass.json");
	
	private int imgdata[];
	
	private IResourceManager resourceManager = GuiScreen.mc.getResourceManager();
	
	public boolean XrayDetectIps(ServerData selectedServer){
		
		System.out.println(selectedServer.serverIP);
		if (selectedServer.serverIP.startsWith("wss://konemc.ga")) {
			
			boolean isUsingXray = XrayDetect();
			return isUsingXray;
			
		}
		if (selectedServer.serverIP.startsWith("ws://konemc.ga")) {
			boolean isUsingXray = XrayDetect();
			return isUsingXray;
		}
		else if (selectedServer.serverIP.startsWith("ws://75.57.115.175")) {
			boolean isUsingXray = XrayDetect();
			return isUsingXray;
		}
		else if (selectedServer.serverIP.startsWith("wss://mc.asspixel.net")){
			boolean isUsingXray = XrayDetect();
			return isUsingXray;
		}
		else if (selectedServer.serverIP.startsWith("wss://web.asspixel.net")){
			boolean isUsingXray = XrayDetect();
			return isUsingXray;
		}
		else if (selectedServer.serverIP.startsWith("wss://mc.arch.lol")){
			boolean isUsingXray = XrayDetect();
			return isUsingXray;
		}
		else {
			return false;
		}
		
	}
	
	private boolean XrayDetect() {
		
		boolean isUsingXray;
		
		try {
			imgdata = TextureUtil.readImageData(resourceManager, grassTopTexturePath);
			System.out.println(imgdata[1]);
			for (int i = 0; i < imgdata.length;i++) {
				if (imgdata[i] == 0) {
					isUsingXray =  true;
				}
			}
			
			isUsingXray = false;
			
		} catch (IOException e) {
			e.printStackTrace();
			isUsingXray =  false;
			
		}
		
		if (!isUsingXray) {
			try {
				
				InputStream json = resourceManager.getResource(grassBlockJson).getInputStream();
				
				 InputStreamReader isr = new InputStreamReader(json, StandardCharsets.UTF_8);
				 BufferedReader br = new BufferedReader(isr);
				 ArrayList<String> jsonLines = new ArrayList<String>();
				 //br.lines().forEach(line -> jsonLines.add(line));
				for (int i = 0; i < 999; i++) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					else {
						jsonLines.add(line);
						//System.out.println(line);
					}
					
				}
					  
				 
				 
				 for (int i = 0; i < jsonLines.size(); i++) {
					 String currentLineNoSpaces = jsonLines.get(i).replaceAll("\\s", "");;
					 
					 if (currentLineNoSpaces.startsWith("\"up\":")) {
						 //System.out.println("found up");
						 if (currentLineNoSpaces.equals("\"up\":{\"uv\":[0,0,16,16],\"texture\":\"#top\",\"cullface\":\"up\",\"tintindex\":0},")) {
							 
							 isUsingXray = false;
						 }
						 else {
							 //System.out.println(currentLineNoSpaces);
							 //System.out.println(currentLineNoSpaces.equals("\"up\":{\"uv\":[0,0,16,16],\"texture\":\"#top\",\"cullface\":\"up\",\"tintindex\":0},"));
							 //System.out.println("\"up\":{\"uv\":[0,0,16,16],\"texture\":\"#top\",\"cullface\":\"up\",\"tintindex\":0},");
							 isUsingXray = true;
						 }
						 
					 }
				 }
				 
				 
				
				
				//System.out.println(json.read());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return isUsingXray;
	}
	
}
