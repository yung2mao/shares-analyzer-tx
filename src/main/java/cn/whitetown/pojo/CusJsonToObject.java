package cn.whitetown.pojo;

/**
 * @author GrainRain
 * @date 2020/03/29 11:51
 **/
@FunctionalInterface
public interface CusJsonToObject {
    CusJsonToObject getInstance(Object json);
}
