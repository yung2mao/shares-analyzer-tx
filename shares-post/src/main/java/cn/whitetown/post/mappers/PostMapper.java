package cn.whitetown.post.mappers;

import cn.whitetown.post.pojo.SharesListData;

import java.util.List;

/**
 * @author GrainRain
 * @date 2020/04/04 18:16
 **/
public interface PostMapper {
    void insertBasicSharesList(List<SharesListData> dataList);
}
