package service.imp;

import dao.IMemberDao;
import dao.imp.MemberDao;
import service.IMemberService;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import vo.Member;
import vo.Page;
import vo.Student;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service("memberService")
//@Transactional
public class memberService implements IMemberService {
    @Resource
    private IMemberDao memberDao;
    /*@Resource
    private IMemberDao memberDaos;*/

    @Override
    public List<?> validateMember(Member member) {
        List<?> list = null;
        try {
            list = memberDao.validateMember(member);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int save_memRegister(Member member) {
        int returnArg = -1;
        try {
            memberDao.memRegister(member);
            returnArg = 1;
        } catch (HibernateException e) {
            returnArg = 0;
            e.printStackTrace();
        }
        return returnArg;
    }

    @Override
    public int updateImg(Object obj) {
        int returnArg = -1;
        try {
            memberDao.updateImg(obj);
            returnArg = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            returnArg = 0;
        }
        return returnArg;
    }

    public String refreshImgHeader(Object obj) {
        String newImgHeader = "";
        try {
            newImgHeader = memberDao.refreshImgHeader(obj);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return newImgHeader;
    }

    @Override
    public List<Member> viewAllReg(Page page, String memName, String memberId) {
        List<Member> list = memberDao.viewAllReg(page, memName, memberId);
        return list;
    }

    @Override
    public int countReg(String memName, String memberId) {
        int count = memberDao.countReg(memName, memberId);
        return count;
    }

    @Override
    public int updateRegAppro(Object memberId) {
        int returnArg = -1;
        try {
            memberDao.updateRegAppro(memberId);
            returnArg = 1;
        } catch (HibernateException e) {
            returnArg = 0;
            e.printStackTrace();
        }
        return returnArg;
    }

    @Override
    public int updateLoginRead(Student stu) {
        int flag = -1;
        try {
            memberDao.editLoginRead(stu);
            flag = 1;
        } catch (Exception e) {
            flag = 0;
        }
        return flag;
    }

    @Override
    public int updateMemberInfo(Object obj) {
        int flag = -1;
        try {
            memberDao.updateMemberInfo(obj);
            flag = 1;
        } catch (Exception e) {
            flag = 0;
            e.printStackTrace();
        }
        return flag;
    }

}
