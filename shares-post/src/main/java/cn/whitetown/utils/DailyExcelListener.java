package cn.whitetown.utils;

import cn.whitetown.pojo.SharesDailyData;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author GrainRain
 * @date 2020/03/27 15:28
 **/
public class DailyExcelListener implements ReadListener<SharesDailyData> {

    private List<SharesDailyData> sharesDailyDataList = new LinkedList<>();

    @Override
    public void invoke(SharesDailyData row, AnalysisContext analysisContext) {
        sharesDailyDataList.add(row);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        if(analysisContext.readRowHolder().getCurrentRowAnalysisResult()==null)
            return false;
        return true;
    }

    public List<SharesDailyData> getSharesDailyDataList() {
        return sharesDailyDataList;
    }

    @Override
    public void onException(Exception e, AnalysisContext analysisContext) throws Exception {
        e.printStackTrace();
    }

    @Override
    public void invokeHead(Map<Integer, CellData> map, AnalysisContext analysisContext) {
    }
}
