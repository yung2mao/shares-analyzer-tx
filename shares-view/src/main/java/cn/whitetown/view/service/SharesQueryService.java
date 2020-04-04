package cn.whitetown.view.service;

import cn.whitetown.view.mappers.BasicMapper;
import cn.whitetown.view.vo.SharesNumWithArea;
import cn.whitetown.view.vo.UIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GrainRain
 * @date 2020/04/03 17:17
 **/
@Service
public class SharesQueryService {
    @Autowired
    private BasicMapper mapper;

    public UIResult querySharesNum(){
        try {
            List<SharesNumWithArea> sharesNumWithAreas = mapper.selectSharesNumWithArea();
            return new UIResult(200,"success",sharesNumWithAreas);
        }catch (Exception e){
            e.printStackTrace();
            return new UIResult(500,"failed",null);
        }
    }
}
