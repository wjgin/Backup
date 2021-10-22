package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.WritingDao;
import dto.Comment;
import dto.Writing;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 글 상세
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));

		WritingDao dao = WritingDao.getInstance();
		
		Writing bean = dao.getOne(idx);

		CommentDao cdao = CommentDao.getInstance();
		List<Comment> cmts = cdao.getList(idx);

		request.setAttribute("cmtlist", cmts);
		request.setAttribute("bean", bean);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url = "view/detail.jsp";
		return forward;

	}
}