package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class ClubAllocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clubid;
	public int getClubid() {
		return clubid;
	}
	public void setClubid(int clubid) {
		this.clubid = clubid;
	}

	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getRoomdescription() {
		return roomdescription;
	}
	public void setRoomdescription(String roomdescription) {
		this.roomdescription = roomdescription;
	}
	
	private String roomcode;
	private String roomname;
	private String roomdescription;
	private String ideasshared;
	public String getIdeasshared() {
		return ideasshared;
	}
	public void setIdeasshared(String ideasshared) {
		this.ideasshared = ideasshared;
	}
	
}
