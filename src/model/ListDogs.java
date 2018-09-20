package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dogs")
public class ListDogs {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="type")
	private String type;
	@Column(name="name")
	private String name;
	@Column(name="owner")
	private String owner;
	
	
	public ListDogs(){
		
	}
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public ListDogs(String t, String n, String o) {
		this.type =t;
		this.name = n;
		this.owner = o;
	}
	public String returnDogDetails() {
		return owner+"'s "+type+" is named: "+name;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", type=" + type + ", name=" + name + ", owner=" + owner + "]";
	}
	
}
