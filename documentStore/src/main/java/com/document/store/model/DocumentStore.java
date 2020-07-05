package com.document.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DocumentStore {
	@Id
	private String id;
	private String name;
	private String profession;
	
	public DocumentStore() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public DocumentStore(String id,String name,  String proffesion) {
		super();
		this.name = name;
		this.id = id;
		this.setProfession(proffesion);
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
}
