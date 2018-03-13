package service.imp;

import dao.IEchartsDao;
import org.springframework.stereotype.Service;
import service.IEchartsService;

import javax.annotation.Resource;
import java.util.List;

@Service("echartsService")
public class EchartsService implements IEchartsService {
    @Resource
    private IEchartsDao echartsDao;

    @Override
    public List<String> getAllExamName() {
        return echartsDao.getAllExamName();
    }

    @Override
    public int countExamByName(String examName) {
        return echartsDao.countExamByName(examName);
    }
}
