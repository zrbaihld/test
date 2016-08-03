package com.zhuanche.zhuanche788.model;

/**
 * Created by Administrator on 2016/8/3.
 */
public class UserModel {

    /**
     * appToken : 4f0EZn43hC
     * driverString : {"id":"8868f0e9331c4b32b31aa657617c02d5","status":"9","creator":"1225853355","createTime":"2016-08-02","modifier":null,"modifyTime":null,"version":0,"delFlag":"0","tenantId":null,"loginId":"15566662222","nickName":null,"fullName":"app测试","mobile":"15566662222","email":null,"headimgurl":null,"sex":null,"province":null,"city":null,"country":null,"birthdate":null,"password":"e10adc3949ba59abbe56e057f20f883e","wechatId":null,"idcard":null,"telephone":null,"degEdu":null,"interest":null,"maritalStatus":null,"address":null,"area":null}
     */

    private String appToken;
    /**
     * id : 8868f0e9331c4b32b31aa657617c02d5
     * status : 9
     * creator : 1225853355
     * createTime : 2016-08-02
     * modifier : null
     * modifyTime : null
     * version : 0
     * delFlag : 0
     * tenantId : null
     * loginId : 15566662222
     * nickName : null
     * fullName : app测试
     * mobile : 15566662222
     * email : null
     * headimgurl : null
     * sex : null
     * province : null
     * city : null
     * country : null
     * birthdate : null
     * password : e10adc3949ba59abbe56e057f20f883e
     * wechatId : null
     * idcard : null
     * telephone : null
     * degEdu : null
     * interest : null
     * maritalStatus : null
     * address : null
     * area : null
     */

    private DriverObjectBean driverObject;

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public DriverObjectBean getDriverObject() {
        return driverObject;
    }

    public void setDriverObject(DriverObjectBean driverString) {
        this.driverObject = driverString;
    }

    public static class DriverObjectBean {
        private String id;
        private String status;
        private String creator;
        private String createTime;
        private String modifier;
        private String modifyTime;
        private int version;
        private String delFlag;
        private String tenantId;
        private String loginId;
        private String nickName;
        private String fullName;
        private String mobile;
        private String email;
        private String headimgurl;
        private String sex;
        private String province;
        private String city;
        private String country;
        private String birthdate;
        private String password;
        private String wechatId;
        private String idcard;
        private String telephone;
        private String degEdu;
        private String interest;
        private String maritalStatus;
        private String address;
        private String area;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getModifier() {
            return modifier;
        }

        public void setModifier(String modifier) {
            this.modifier = modifier;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(String birthdate) {
            this.birthdate = birthdate;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getWechatId() {
            return wechatId;
        }

        public void setWechatId(String wechatId) {
            this.wechatId = wechatId;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getDegEdu() {
            return degEdu;
        }

        public void setDegEdu(String degEdu) {
            this.degEdu = degEdu;
        }

        public String getInterest() {
            return interest;
        }

        public void setInterest(String interest) {
            this.interest = interest;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
}
