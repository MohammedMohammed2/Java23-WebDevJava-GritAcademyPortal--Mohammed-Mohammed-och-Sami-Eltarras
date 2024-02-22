package org.example.JspUppgift.models;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Userbean implements Serializable {

    //making getters and setters to bring info from query
    private String id;
    private USER_TYPE userType;
    private PRIVILAGE_TYPE privilageType = PRIVILAGE_TYPE.user;
    private STATE_TYPE stateType = STATE_TYPE.anonymous;

    private List<String[]> data = null;

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }
    public Userbean(){}
    public Userbean(String id, USER_TYPE userType, PRIVILAGE_TYPE privilageType, STATE_TYPE stateType){
        this.id=id;
        this.userType=userType;
        this.privilageType=privilageType;
        this.stateType=stateType;
    }


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setStateType(STATE_TYPE stateType) {
        this.stateType = stateType;
    }

    public void setprivilageType(PRIVILAGE_TYPE privilageType) {
        this.privilageType = privilageType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }

    public PRIVILAGE_TYPE getprivilageType() {
        return privilageType;
    }

    public STATE_TYPE getStateType() {
        return stateType;
    }

    public USER_TYPE getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "userType: "+userType + " privilageType: " + privilageType + " stateType: "  + stateType;
    }

}