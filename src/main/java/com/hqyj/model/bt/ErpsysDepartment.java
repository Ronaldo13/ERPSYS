package com.hqyj.model.bt;



/**
 * @author bt
 * 
 * 最后更新:2019年2月20日上午9:29:32
 */
public class ErpsysDepartment {
    private Integer departmentId;//部门编号

    private String departmentName;//部门名称 

    private String departmentAuthorityId;//部门权限编号

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAuthorityId() {
        return departmentAuthorityId;
    }

    public void setDepartmentAuthorityId(String departmentAuthorityId) {
        this.departmentAuthorityId = departmentAuthorityId;
    }

	@Override
	public String toString() {
		return "ErpsysDepartment [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentAuthorityId=" + departmentAuthorityId + "]";
	}
    
}