package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dto.Comment;


public class CommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		CommentDao dao = CommentDao.getInstance();
		
		int pageNo = Integer.parseInt(request.getParameter("page"));
		int writingIdx;
		
		if (request.getParameter("del") != null) {
			int cmtidx = Integer.parseInt(request.getParameter("cmtidx"));
			int idx = Integer.parseInt(request.getParameter("idx"));
			dao.delete(cmtidx);
			writingIdx = idx;
		} else {
			String userId = request.getParameter("userId");
			String content = request.getParameter("content");
			writingIdx = Integer.parseInt(request.getParameter("writingIdx"));

			Comment dto = new Comment(0, writingIdx, userId, content);
			dao.insert(dto);
		}

		dao.updateCountAll(writingIdx);
		
		forward.isRedirect = true;
		forward.url = "detail.do?idx=" + writingIdx + "&page=" + pageNo;
		
		return forward;
	}

}
