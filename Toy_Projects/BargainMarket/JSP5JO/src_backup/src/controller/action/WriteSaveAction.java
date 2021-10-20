package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GalleryDao;
import dao.WritingDao;
import dto.Gallery;
import dto.Writing;

public class WriteSaveAction implements Action  {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		request.setCharacterEncoding("UTF-8");
		
		String subject = (String)request.getAttribute("subject");
		String categoryIdx = (String)request.getAttribute("categoryIdx");
		String userId = (String)request.getAttribute("userId");
		String content = (String)request.getAttribute("content");
		
		System.out.println(subject);
		System.out.println(categoryIdx);
		System.out.println(userId);
		System.out.println(content);
		
		Writing dto = new Writing();
		dto.setSubject(subject);
		dto.setCategoryIdx(categoryIdx);
		dto.setUserId(userId);
		dto.setContent(content);
		
		GalleryDao gdao = GalleryDao.getInstance();
		String path="d:\\dektop\\upload";
		
		int size=5*1024*1024;
		
		try {
			MultipartRequest muti = new MultipartRequest
					(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			
			String title = "test";
			String filename = muti.getFilesystemName("fileName");
			
			Gallery gdto = new Gallery(0,title, filename);
			
			gdao.insert(gdto);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		WritingDao dao = WritingDao.getInstance();
		dao.insert(dto);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = true;
		forward.url="index.do";
		return forward;
	}
	
		
}