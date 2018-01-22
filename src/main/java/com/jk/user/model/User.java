package com.jk.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private Integer userid;

    private String username;

    private String password;

    private String userdspname;

    private String sex;

    private Date birthday;

    private String phone;
    
    
    private String descroptionQx;
    private String descroptionJs;
    private Integer userRoles;
    private String depName;
    
    private String birthdayShow;  //日期展示字段
    
    
    

    public Integer getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Integer userRoles) {
		this.userRoles = userRoles;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserdspname() {
        return userdspname;
    }

    public void setUserdspname(String userdspname) {
        this.userdspname = userdspname == null ? null : userdspname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

	public String getDescroptionQx() {
		return descroptionQx;
	}

	public void setDescroptionQx(String descroptionQx) {
		this.descroptionQx = descroptionQx;
	}

	public String getDescroptionJs() {
		return descroptionJs;
	}

	public void setDescroptionJs(String descroptionJs) {
		this.descroptionJs = descroptionJs;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public String getBirthdayShow() {
		return sdf.format(birthday);
	}

	public void setBirthdayShow(String birthdayShow) {
		this.birthdayShow = birthdayShow;
	}
	
}