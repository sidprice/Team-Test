package com.sidprice.android.teamtest.models;

public class User {
    private String  mUserName ;
    private String  mEmail ;
    private String  mRole ;

    public static final String  ROLE_OWNER = "owner" ;
    public static final String  ROLE_MEMBER = "member" ;

    public User(String UserName, String Email, String Role) {
        this.mUserName = UserName;
        this.mEmail = Email;
        this.mRole = Role;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String mRole) {
        this.mRole = mRole;
    }
}
