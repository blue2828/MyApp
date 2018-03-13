package service;

import vo.ExamType;
import vo.Page;

import java.util.List;

public interface IExamTypeService {
    public List<ExamType> getAllInfo(Page page, ExamType examType);

    public int countExamType(Page page, ExamType examType);

    public int saveExamType(ExamType examType);

    public int[] deleteExamType(String ids);

    public String findExamNameById(int id);
}
