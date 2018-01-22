package com.jk.user.model;

public class Power {
    private String powerId;

    private String pname;

    private String puri;

    private String parent;

    public String getPowerId() {
        return powerId;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId == null ? null : powerId.trim();
    }

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPuri() {
		return puri;
	}

	public void setPuri(String puri) {
		this.puri = puri;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

}