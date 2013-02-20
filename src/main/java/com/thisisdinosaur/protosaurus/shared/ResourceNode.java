package com.thisisdinosaur.protosaurus.shared;

import java.awt.Graphics2D;

import com.thisisdinosaur.protosaurus.client.Displayable;
import com.thisisdinosaur.protosaurus.client.LogicTicker;

public class ResourceNode implements Displayable, LogicTicker
{
	protected ResourceNodeEntity nodeEntity;
	protected Displayable nodeDrawer;
	
	protected int resources, maxResources;
	protected int health, maxHealth;
	
	protected int lastHitId;
	protected int ownerId;
	
	public ResourceNode(ResourceNodeEntity nodeEntity, Displayable cityDrawer, int maxHealth, int maxResources)
	{
		this.nodeEntity = nodeEntity;
		this.nodeDrawer = cityDrawer;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.maxResources = maxResources;
		this.resources = maxResources;
		
		lastHitId = 0;
		ownerId = 0;
	}
		
	@Override
	public void draw(Graphics2D g)
	{
		this.nodeDrawer.draw(g);
	}
	
	public void tick(int delta)
	{
		this.nodeEntity.tick(delta);
	}

	@Override
	public float getRotation()
	{
		return 0;
	}

	public int getResources()
	{
		return resources;
	}

	public void setResources(int resources)
	{
		this.resources = resources;
	}

	public int getMaxResources()
	{
		return maxResources;
	}

	public void setMaxResources(int maxResources)
	{
		this.maxResources = maxResources;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}

	public int getOwnerId()
	{
		return ownerId;
	}

	public void setOwnerId(int playerId)
	{
		this.ownerId = playerId;
	}

    public float getX () {
        return this.nodeEntity.getX();
    }
    
    public float getY () {
        return this.nodeEntity.getY();
    }
    
    public void setX(int x) {
        this.nodeEntity.setX(x);
    }
    
    public void setY(int y) {
        this.nodeEntity.setY(y);
    }
}
