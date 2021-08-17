package VO;

import java.sql.Date;

// Custom# table과 mapping되는 VO
public class CustomVo {
	private String custom_id;
	private String custom_name;
	private String custom_email;
	private int custom_age;
	private Date custom_reg_date;

	
	public CustomVo() {
	// 초기화 작업
	}
	
	public CustomVo(String custom_id, String custom_name, String custom_email, int custom_age, Date custom_reg_date) {
		super();
		this.custom_id = custom_id;
		this.custom_name = custom_name;
		this.custom_email = custom_email;
		this.custom_age = custom_age;
		this.custom_reg_date = custom_reg_date;
	}


	// toString 재정의
	@Override
	public String toString() {
		return "CutomVo [cutom_id = " + custom_id + 
				" custom_name = " + custom_name + " custom_email = " + custom_email +
				" custom_age = " + custom_age + " custom_reg_date = " + custom_reg_date;
		
	}
	
	
	
	// getter, setter
	public String getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(String custom_id) {
		this.custom_id = custom_id;
	}
	public String getCustom_name() {
		return custom_name;
	}
	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}
	public String getCustom_email() {
		return custom_email;
	}
	public void setCustom_email(String custom_email) {
		this.custom_email = custom_email;
	}
	public int getCustom_age() {
		return custom_age;
	}
	public void setCustom_age(int custom_age) {
		this.custom_age = custom_age;
	}
	public Date getCustom_reg_date() {
		return custom_reg_date;
	}
	public void setCustom_reg_date(Date custom_reg_date) {
		this.custom_reg_date = custom_reg_date;
	}
	
	
	
}
