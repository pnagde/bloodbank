package com.bloodbank.universal.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "user_name",nullable = false)
    private String userName;
    
    @Column(name = "user_phone",nullable = true,unique = true)
    private String userPhone;
    
    @Column(name = "user_email",nullable = false,unique = true)
    private String userEmail;
    
    @Column(name = "user_password",nullable = false)
    private String password;
    
    @Column(name = "user_dob",nullable = true)
    private Date userDOB;
    
    @Column(name = "roles")
    private String roles;
    
    @Column(name = "user_gender",nullable = true)
    private String userGender;
    
    @Column(name = "user_blood",nullable = false)
    private String userBloodGroup;
    
    @Column(name = "active_status")
    private boolean activeStatus;    
    @Column(name = "verify_status")
    private boolean verifyStatus;
    
    @Column(name = "verify_code")
    private Integer verifyCode;
    public void setVerifyCode(Integer verifyCode) {
		this.verifyCode = verifyCode;
	}
    public Integer getVerifyCode() {
		return verifyCode;
	}

    public User() 
    {
    }
    
    public String getRoles() {
		return roles;
	}
    public void setRoles(String roles) {
		this.roles = roles;
	}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Date getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(Date userDOB) {
        this.userDOB = userDOB;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserBloodGroup() {
        return userBloodGroup;
    }

    public void setUserBloodGroup(String userBloodGroup) {
        this.userBloodGroup = userBloodGroup;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public boolean isVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(boolean verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", userEmail="
				+ userEmail + ", userPassword=" + password + ", userDOB=" + userDOB + ", userGender=" + userGender
				+ ", userBloodGroup=" + userBloodGroup + ", activeStatus=" + activeStatus + ", verifyStatus="
				+ verifyStatus + "]";
	}
    
    
 }
