package org.ahhn.com.onetoone.foreign;

/**
 * Created by XJX on 2016/3/11.
 */
public class Department {
	private Integer deptId;
	private String deptName;

	private Manager manager;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Department{" +
				"deptId=" + deptId +
				", deptName='" + deptName + '\'' +
				", manager=" + manager +
				'}';
	}
}
