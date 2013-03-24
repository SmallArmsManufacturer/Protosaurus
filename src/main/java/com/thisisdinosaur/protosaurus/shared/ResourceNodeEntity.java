package com.thisisdinosaur.protosaurus.shared;
import java.util.List;

import com.thisisdinosaur.protosaurus.client.GameEntity;
import com.thisisdinosaur.protosaurus.client.MapLogic;
import com.thisisdinosaur.protosaurus.client.Player;

public class ResourceNodeEntity extends GameEntity
{	
	private static final int CAPTURE_RADIUS = 50;
	private MapLogic ml;
	private Player owner;
	
	public ResourceNodeEntity(MapLogic ml)
	{
		this.ml = ml;
		owner = null;
	}
	
	public void tick(int delta)
	{
		for(Player player : ml.getPlayers()) {
			List<Dinosaur> playerControlledDinosaurs = player.getDinosaurs();
			for(Dinosaur d : playerControlledDinosaurs)
			{
				float dist = Maths.getDistance(this.getX(), this.getY(), d.getX(), d.getY());
				if(dist < CAPTURE_RADIUS)
				{
					if(owner != null)
						owner.removeResourceNode(this);
					
					owner = player;
					player.addResourceNode(this);
				}
			}
		}
	}

	public Player getOwner()
	{
		return owner;
	}
}
