package service.imp;

import dao.IExamTypeDao;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import service.IExamTypeService;
import vo.ExamType;
import vo.Page;

import javax.annotation.Resource;
import java.util.List;

@Service("examTypeService")
public class ExamTypeService implements IExamTypeService {
    @Resource
    private IExamTypeDao examTypeDao;

    @Override
    public List<ExamType> getAllInfo(Page page, ExamType examType) {
        return examTypeDao.getAllInfo(page, examType);
    }

    @Override
    public int countExamType(Page page, ExamType examType) {
        return examTypeDao.countExamType(page, examType);
    }

    @Override
    public int saveExamType(ExamType examType) {
        int flag = 0;
        try {
            examTypeDao.saveExamType(examType);
            flag = 1;
        } catch (HibernateException e) {
            flag = 0;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int[] deleteExamType(String ids) {
        int flagArr[] = new int[2];
        try {
            flagArr = examTypeDao.delExamType(ids);
        } catch (HibernateException e) {
            flagArr[0] = 0;
            flagArr[1] = 0;
            e.printStackTrace();
        }
        return flagArr;
    }

    @Override
    public String findExamNameById(int id) {
        return examTypeDao.findExamNameById(id);
    }
}
