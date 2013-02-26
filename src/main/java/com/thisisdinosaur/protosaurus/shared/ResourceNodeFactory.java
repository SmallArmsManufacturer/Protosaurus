package com.thisisdinosaur.protosaurus.shared;

import com.thisisdinosaur.protosaurus.client.MapLogic;

public class ResourceNodeFactory
{
	private static final int DEFAULT_MAX_RESOURCES = 1000;
	private static final int DEFAULT_MAX_HEALTH = 100;
	
	public static ResourceNode makeResourceNode(MapLogic ml)
	{
		ResourceNodeEntity nodeEntity = new ResourceNodeEntity(ml);
		ResourceNodeDrawer resourceNodeDrawer = new ResourceNodeDrawer(nodeEntity);
		return new ResourceNode(nodeEntity, resourceNodeDrawer, DEFAULT_MAX_HEALTH, DEFAULT_MAX_RESOURCES);
	}
	

}
