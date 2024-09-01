package com.firstAPI.eComApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Product {
	
    @Id
	public int  pid;
	public String title;
	public String description;
	public float price;
	public int stock;
	public String pro_img;
	
}
