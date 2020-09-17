package domain;

import javax.persistence.*;

@Entity
@Table(name="mobile_data")
@PrimaryKeyJoinColumn(name="id")
public class Mobile extends Product
{
	@Column(name="mobile_brand")
	private String mobileBrand;
	
	@Column(name="os_type")
	private String osType;
	
	public String getMobileBrand() 
	{
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) 
	{
		this.mobileBrand = mobileBrand;
	}
	public String getOsType() 
	{
		return osType;
	}
	public void setOsType(String osType) 
	{
		this.osType = osType;
	}
}
