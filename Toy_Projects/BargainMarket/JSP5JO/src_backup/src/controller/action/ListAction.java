package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WritingDao;
import dto.Writing;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 카테고리 인자 가져오기
		String categoryIdx = request.getParameter("cate");
		
		// 인자로 전달 받은 카테고리 번호로 리스트 리턴
		WritingDao dao = WritingDao.getInstance();
		List<Writing>list = dao.selectByCategoryIdx(categoryIdx);
		
		// 리스트 전달
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("view/list.jsp");
		
		return forward;
	}

}
