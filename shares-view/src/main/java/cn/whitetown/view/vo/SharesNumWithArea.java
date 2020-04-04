package cn.whitetown.view.vo;

/**
 * @author GrainRain
 * @date 2020/04/03 17:12
 **/
public class SharesNumWithArea {
    private int id;
    private String province;
    private int num;

    public SharesNumWithArea() {
    }

    public SharesNumWithArea(int id, String province, int num) {
        this.id = id;
        this.province = province;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "SharesNumWithArea{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", num=" + num +
                '}';
    }
}
