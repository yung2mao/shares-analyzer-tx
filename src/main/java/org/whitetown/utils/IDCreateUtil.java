package org.whitetown.utils;


/**
 * @ClassName IDCreateUtil
 * @Description TODO
 * @Author GrainRain
 * @Date 2020/1/9 8:40
 * @Version v1.0
 */
public class IDCreateUtil {
    private static int serialNumber = 1000+(int)(1000*Math.random());

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
}
