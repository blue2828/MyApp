package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.IEchartsService;

import javax.annotation.Resource;
import java.util.List;

@Controller("echartsAction")
@Scope("prototype")
public class echarsAction extends ActionSupport {
    private JSONObject jb;
    @Resource
    private IEchartsService echartsService;

    public JSONObject getJb() {
        return jb;
    }

    public void setJb(JSONObject jb) {
        this.jb = jb;
    }

    public String echartsData() {
        jb = new JSONObject();
        JSONArray array = new JSONArray();
        List<String> list = echartsService.getAllExamName();
        for (String examName : list) {
            int count = echartsService.countExamByName(examName);
            JSONObject tempJb = new JSONObject();
            tempJb.put("examName", examName);
            tempJb.put("count", count);
            array.add(tempJb);
        }
        jb.put("data", array);
        return SUCCESS;
    }
}
