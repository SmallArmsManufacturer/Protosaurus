package com.thisisdinosaur.protosaurus.client;

import java.util.ArrayList;
import java.util.List;

import com.thisisdinosaur.protosaurus.shared.Dinosaur;
import com.thisisdinosaur.protosaurus.shared.ResourceNodeEntity;

public class Player {

	private List<GameEntity> controlledEntities;
	private List<Dinosaur> dinosaurs;
	private List<ResourceNodeEntity> resourceNodes;
	
	private Dinosaur selectedEntity;
	
	public Player(){
		this.controlledEntities = new ArrayList<GameEntity>();
		this.dinosaurs = new ArrayList<Dinosaur>();
		this.resourceNodes = new ArrayList<ResourceNodeEntity>();
	}
	
	public void addDinosaur(Dinosaur dinosaur) {
		this.dinosaurs.add(dinosaur);
		this.controlledEntities.add(dinosaur.getEntity());
	}
	
	public void removeDinosaur(Dinosaur dinosaur) {
		this.dinosaurs.remove(dinosaur);
		this.controlledEntities.remove(dinosaur.getEntity());
	}
	
	// Will be changed to some other list when resource nodes are added
	public List<GameEntity> getLOSEntities() {
		return this.controlledEntities;
	}
	
	public List<Dinosaur> getDinosaurs() {
		return this.dinosaurs;
	}

	public Dinosaur getSelectedEntity() {
		return selectedEntity;
	}

	public void setSelectedEntity(Dinosaur selectedEntity) {
		this.selectedEntity = selectedEntity;
	}

	public void addResourceNode(ResourceNodeEntity resourceNodeEntity) {
		this.resourceNodes.add(resourceNodeEntity);
		this.controlledEntities.add(resourceNodeEntity);
	}

	public void removeResourceNode(ResourceNodeEntity resourceNodeEntity) {
		this.resourceNodes.remove(resourceNodeEntity);
		this.controlledEntities.remove(resourceNodeEntity);
	}

}
