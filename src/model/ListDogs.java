package model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@ManyToOne(cascade=CascadeType.ALL, fetch =FetchType.LAZY)
	@JoinColumn(name="ownerID")
	private ListOwners owner;
	
	
	
	public void setOwner(ListOwners listOwner) {
		
		this.owner=listOwner;
		if(!listOwner.getListDogs().contains(this)) {
			listOwner.getListDogs().add(this);
		}
	}
	
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
	
	public ListOwners getOwner() {
		return owner;
	}
	
	public ListDogs(String t, String n) {
		this.type =t;
		this.name = n;
		
		
		
	}
	public String returnDogDetails() {
		return owner+"'s "+type+" is named: "+name;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", type=" + type + ", name=" + name + ", owner=" + owner + "]";
	}
	
}
