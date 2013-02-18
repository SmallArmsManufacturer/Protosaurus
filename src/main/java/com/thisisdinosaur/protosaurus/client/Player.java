package com.thisisdinosaur.protosaurus.client;

import java.util.ArrayList;
import java.util.List;

import com.thisisdinosaur.protosaurus.shared.Dinosaur;

public class Player {

	private List<Dinosaur> controlledEntities;
	
	public Player(){
		this.controlledEntities = new ArrayList<Dinosaur>();
	}
	
	public void addEntity(Dinosaur entity) {
		this.controlledEntities.add(entity);
	}
	
	public void removeEntity(Dinosaur entity) {
		this.controlledEntities.remove(entity);
	}
	
	public List<Dinosaur> getLOSEntities() {
		return this.controlledEntities;
	}

}
