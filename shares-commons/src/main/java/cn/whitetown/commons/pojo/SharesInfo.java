package cn.whitetown.commons.pojo;

import java.io.Serializable;

/**
 * @author GrainRain
 * @date 2020/04/04 16:23
 **/
public class SharesInfo implements Serializable {

    private static final long serialVersionUID = -7722772634257880273L;

    private String id;
    private String tsCode;
    private String name;
    private String exchange;
    private String chairman;
    private String manager;
    private double regCapital;
    private String setupDate;
    private String province;
    private String city;
    private String website;
    private String email;
    private String office;
    private int employeesNum;
    private String mainBusiness;
    private String businessScope;

    public SharesInfo() {
    }

    public SharesInfo(String id, String tsCode, String exchange, String chairman, String manager, double regCapital, String setupDate, String province, String city, String website, String email, String office, int employeesNum, String mainBusiness, String businessScope) {
        this.id = id;
        this.tsCode = tsCode;
        this.exchange = exchange;
        this.chairman = chairman;
        this.manager = manager;
        this.regCapital = regCapital;
        this.setupDate = setupDate;
        this.province = province;
        this.city = city;
        this.website = website;
        this.email = email;
        this.office = office;
        this.employeesNum = employeesNum;
        this.mainBusiness = mainBusiness;
        this.businessScope = businessScope;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public double getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(double regCapital) {
        this.regCapital = regCapital;
    }

    public String getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(String setupDate) {
        this.setupDate = setupDate;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getEmployeesNum() {
        return employeesNum;
    }

    public void setEmployeesNum(int employeesNum) {
        this.employeesNum = employeesNum;
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    @Override
    public String toString() {
        return "SharesInfo{" +
                "id='" + id + '\'' +
                ", tsCode='" + tsCode + '\'' +
                ", exchange='" + exchange + '\'' +
                ", chairman='" + chairman + '\'' +
                ", manager='" + manager + '\'' +
                ", regCapital=" + regCapital +
                ", setupDate='" + setupDate + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", office='" + office + '\'' +
                ", employeesNum=" + employeesNum +
                ", mainBusiness='" + mainBusiness + '\'' +
                ", businessScope='" + businessScope + '\'' +
                '}';
    }
    public String writeFormat(){
        StringBuilder builder = new StringBuilder("");
        return builder.append(id).append("|")
                .append(tsCode).append("|")
                .append(exchange).append("|")
                .append(chairman).append("|")
                .append(manager).append("|")
                .append(regCapital).append("|")
                .append(setupDate).append("|")
                .append(province).append("|")
                .append(city).append("|")
                .append(website).append("|")
                .append(email).append("|")
                .append(office).append("|")
                .append(employeesNum).append("|")
                .append(mainBusiness).append("|")
                .append(businessScope).append("|").append("\n").toString();

    }
}
