package cn.whitetown.commons.utils;

/**
 * @author GrainRain
 * @date 2020/03/29 11:51
 **/
@FunctionalInterface
public interface CusJsonToObject<T> {
    T getInstance(Object json);
}
