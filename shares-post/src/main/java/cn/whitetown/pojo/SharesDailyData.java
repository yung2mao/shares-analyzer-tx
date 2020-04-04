package cn.whitetown.pojo;

import cn.whitetown.commons.utils.CusJsonToObject;
import cn.whitetown.commons.utils.IDCreateUtil;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author GrainRain
 * @date 2020/03/26 17:35
 **/

public class SharesDailyData implements Serializable, CusJsonToObject<SharesDailyData> {
    @ExcelProperty(value = "id",index = 0)
    private String id;
    @ExcelProperty(value = "ts_code",index = 1)
    private String tsCode;
    @ExcelProperty(value = "trade_date",index = 2)
    private String tradeData;
    @ExcelProperty(value = "open",index = 3)
    private double open;
    @ExcelProperty(value = "high",index = 4)
    private double high;
    @ExcelProperty(value = "low",index = 5)
    private double low;
    @ExcelProperty(value = "close",index = 6)
    private double close;
    @ExcelProperty(value = "pre_close",index = 7)
    private double preClose;
    @ExcelProperty(value = "change",index = 8)
    private double change;
    @ExcelProperty(value ="pct_change",index = 9)
    private double pctChange;
    @ExcelProperty(value ="vol",index = 10)
    private Long vol;
    @ExcelProperty(value = "amount",index = 11)
    private Long amount;
    @ExcelIgnore
    private static DecimalFormat format = new DecimalFormat("0.000000");

    public SharesDailyData() {
    }

    public SharesDailyData(String tsCode, String tradeData, double open, double high, double low, double close, double preClose, double change, double pctChange, Long vol, Long amount) {
        this.tsCode = tsCode;
        this.tradeData = tradeData;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.preClose = preClose;
        this.change = change;
        this.pctChange = pctChange;
        this.vol = vol;
        this.amount = amount;
        this.id = IDCreateUtil.getId("day");
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

    public String getTradeData() {
        return tradeData;
    }

    public void setTradeData(String tradeData) {
        this.tradeData = tradeData;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getPreClose() {
        return preClose;
    }

    public void setPreClose(double preClose) {
        this.preClose = preClose;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getPctChange() {
        return pctChange;
    }

    public void setPctChange(double pctChange) {
        this.pctChange = Double.parseDouble(format.format(pctChange));
    }

    public Long getVol() {
        return vol;
    }

    public void setVol(Long vol) {
        this.vol = vol;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setAllFields(Object json){
        SharesDailyJsonArray jsonArray = (SharesDailyJsonArray)json;
        this.tsCode = jsonArray.getString(0);
        this.tradeData = jsonArray.getString(1);
        this.open = jsonArray.getDouble(2);
        this.high = jsonArray.getDouble(3);
        this.low = jsonArray.getDouble(4);
        this.close = jsonArray.getDouble(5);
        this.preClose = jsonArray.getDouble(6);
        this.change = jsonArray.getDouble(7);
        this.setPctChange(jsonArray.getDouble(8) / 100);
        this.vol = (long) (jsonArray.getDouble(9) * 100);
        this.amount = (long)( jsonArray.getDouble(10) * 1000);
        this.id = IDCreateUtil.getId("day");
    }

    @Override
    public SharesDailyData getInstance(Object json) {
        SharesDailyData instance = new SharesDailyData();
        instance.setAllFields(SharesDailyJsonArray.getInstance((JSONArray) json));
        return instance;
    }

    @Override
    public String toString() {
        return "SharesDailyData{" +
                "id='" + id + '\'' +
                ", tsCode='" + tsCode + '\'' +
                ", tradeData='" + tradeData + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", preClose=" + preClose +
                ", change=" + change +
                ", pctChange=" + pctChange +
                ", vol=" + vol +
                ", amount=" + amount +
                '}';
    }

    public String writeFormat(){
        StringBuffer buffer = new StringBuffer("");
        return buffer.append(id).append("|")
                .append(tsCode).append("|")
                .append(tradeData).append("|")
                .append(open).append("|")
                .append(high).append("|")
                .append(low).append("|")
                .append(close).append("|")
                .append(preClose).append("|")
                .append(change).append("|")
                .append(pctChange).append("|")
                .append(vol).append("|")
                .append(amount).append("|")
                .append("\n").toString();
    }
}
