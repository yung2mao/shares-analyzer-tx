package cn.whitetown.view.controller;

import cn.whitetown.view.service.SharesQueryService;
import cn.whitetown.view.vo.UIResult;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author GrainRain
 * @date 2020/04/03 17:17
 **/
@RestController
public class SharesQueryController{
    @Autowired
    private SharesQueryService queryService;

    @RequestMapping("/queryNum")
    public UIResult querySharesNum(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        return queryService.querySharesNum();
    }
}
