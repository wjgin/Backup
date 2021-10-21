package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import dao.JjimDao;
import dao.UsersDao;
import dao.WritingDao;
import dto.Writing;
import dto.Comment;
import dto.Jjim;
import dto.SessionDto;
import dto.Users;

public class MypageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		SessionDto dto = (SessionDto)session.getAttribute("user");
		
		String userId = dto.getId();
		WritingDao wdao = WritingDao.getInstance();
		List<Writing> wlist = wdao.selectById(userId);
		request.setAttribute("wlist", wlist);
		
		CommentDao cdao = CommentDao.getInstance();
		List<Comment> clist = cdao.selectById(userId);
		request.setAttribute("clist", clist);
		
		JjimDao jdao = JjimDao.getInstance();
		List<Jjim> jlist = jdao.selectById(userId);
		request.setAttribute("jlist", jlist);
		
		UsersDao udao = UsersDao.getInstance();
		Users udto = new Users();
		udto = udao.proIdxInfo(userId);
		request.setAttribute("udto", udto);
		request.setAttribute("userId", userId);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url="view/mypage.jsp?userId="+userId;
		return forward;
	}

}