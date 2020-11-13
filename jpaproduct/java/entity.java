package jpaproduct;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="products")

public class entity implements Serializable
{
        @Id
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="color")
	private String color;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

public entity(String barcode, String name, String color, String description) 
{
	super( );
	this.barcode = barcode;
	this.name = name;
	this.color = color;
	this.description = description;
}

	
public entity( ) 
{
                super();
		this.barcode="default";
		this.color="default";
		this.name="default";
		this.description="default";
}

public String getBarcode( ) 
{
	return barcode;
}
public void setBarcode(String barcode)  
{
	this.barcode = barcode;
}
public String getName( ) 
{
	return name;
}
public void setName(String name) 
{
	this.name = name;
}
	
public String getColor( ) 
{
	return color;
}
public void setColor(String color) 
{
	this.color = color;
}
	
public String getDescription( ) 
{
	return description;
}
public void setDescription(String description) 
{
	this.description = description;
}

@Override
public String toString() {return "Product [barcode=" + barcode + ", name=" + name + ", color" + color + ", description=" + description + "]";}
}
