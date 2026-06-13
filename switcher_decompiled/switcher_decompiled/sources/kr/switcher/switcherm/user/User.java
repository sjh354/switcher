package kr.switcher.switcherm.user;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class User {
    private String address1;
    private String address2;
    private String email;
    private String id;
    private String mainSwitcherCode;
    private String phoneNumber;
    private String postNumber;
    private List<Integer> requestList;
    private String userName;

    public User() {
        this.userName = "사용자";
    }

    public User(String str) {
        this.userName = "사용자";
        this.phoneNumber = str;
    }

    public User(String str, String str2, String str3, String str4, String str5, String str6) {
        this.phoneNumber = str;
        this.userName = str2;
        setMainSwitcherMacAddress(str3);
        this.postNumber = str4;
        this.address1 = str5;
        this.address2 = str6;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getMainSwitcherCode() {
        return this.mainSwitcherCode;
    }

    public void setMainSwitcherMacAddress(String str) {
        this.mainSwitcherCode = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getAddress1() {
        return this.address1;
    }

    public String getPostNumber() {
        return this.postNumber;
    }

    public void setPostNumber(String str) {
        this.postNumber = str;
    }

    public void setAddress1(String str) {
        this.address1 = str;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String str) {
        this.address2 = str;
    }

    public List<Integer> getRequestList() {
        return this.requestList;
    }

    public void setRequestList(List<Integer> list) {
        this.requestList = list;
    }
}
