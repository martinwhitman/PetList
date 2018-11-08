package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class ListOwners{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="ownerID")
	private int ownerID;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="state")
	private String state;
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "owner")
	private List<ListDogs> listDogs;
	
	public List<ListDogs> getListDogs() {
		return listDogs;
	}


	public void setListDogs(List<ListDogs> listDogs) {
		this.listDogs = listDogs;
	}


	public void addDog (ListDogs dog) {
		this.listDogs.add(dog);
		if(dog.getOwner()!=this) {
			dog.setOwner(this);
		}
	}
	
	
	public int getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 
	 */
	public ListOwners() {
	}
	@Override
	public String toString() {
		return "ListOwners [ownerID=" + ownerID + ", name=" + name + ", address=" + address + ", state=" + state + "]";
	}
	/**
	 * @param ownerID
	 * @param name
	 * @param address
	 * @param state
	 */
	public ListOwners(String name, String address, String state) {
		
		this.name = name;
		this.address = address;
		this.state = state;
	}
	
	
}

