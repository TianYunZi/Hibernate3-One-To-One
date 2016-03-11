package org.ahhn.com.onetoone.foreign;

/**
 * Created by XJX on 2016/3/11.
 */
public class Manager {
	private Integer mgrId;
	private String mgrName;

	private Department department;

	public Integer getMgrId() {
		return mgrId;
	}

	public void setMgrId(Integer mgrId) {
		this.mgrId = mgrId;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Manager{" +
				"mgrId=" + mgrId +
				", mgrName='" + mgrName + '\'' +
				", department=" + department +
				'}';
	}
}
