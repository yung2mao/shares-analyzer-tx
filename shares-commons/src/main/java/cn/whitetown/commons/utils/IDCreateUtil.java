package cn.whitetown.commons.utils;


/**
 * @ClassName IDCreateUtil
 * @Description TODO
 * @Author GrainRain
 * @Date 2020/1/9 8:40
 * @Version v1.0
 */
public final class IDCreateUtil {
    private static int serialNumber = 1000+(int)(1000*Math.random());
    private static int basicNumber = 10000;

    private IDCreateUtil(){}

    public static String getId(String businessCode){
        long time = System.currentTimeMillis();
        synchronized (IDCreateUtil.class){
            serialNumber += 1;
            if(serialNumber > 9999)
                serialNumber = 1000+(int)(1000*Math.random());
            return Long.toHexString(time) + serialNumber + businessCode;
        }
    }

    public static String getId(){
        long time = System.currentTimeMillis();
        synchronized (IDCreateUtil.class){
            serialNumber += 1;
            if(serialNumber > 9999)
                serialNumber = 1000+(int)(1000*Math.random());
            return Long.toHexString(time) + serialNumber;
        }
    }

    public static String getBasicId(String code){
        return basicNumber++ + code;
    }
}
