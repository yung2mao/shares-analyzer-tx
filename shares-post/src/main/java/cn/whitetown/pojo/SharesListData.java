package cn.whitetown.pojo;

import java.io.Serializable;

/**
 * @author GrainRain
 * @date 2020/04/01 18:04
 **/
public class SharesListData implements Serializable {
    private String id;
    private String tsCode;
    private String name;
    private String area;
    private String industry;
    private String listDate;

    public SharesListData() {
    }

    public SharesListData(String id, String tsCode, String name, String area, String industry, String listDate) {
        this.id = id;
        this.tsCode = tsCode;
        this.name = name;
        this.area = area;
        this.industry = industry;
        this.listDate = listDate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getListDate() {
        return listDate;
    }

    public void setListDate(String listDate) {
        this.listDate = listDate;
    }


    @Override
    public String toString() {
        return "SharesListData{" +
                "id='" + id + '\'' +
                ", tsCode='" + tsCode + '\'' +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", industry='" + industry + '\'' +
                ", listDate='" + listDate + '\'' +
                '}';
    }

    public String writeFormat(){
        StringBuilder builder = new StringBuilder();
        return builder.append(id).append("|")
                .append(tsCode).append("|")
                .append(name).append("|")
                .append(area).append("|")
                .append(industry).append("|")
                .append(listDate).append("|")
                .append("\n")
                .toString();
    }

}
