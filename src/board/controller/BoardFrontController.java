package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.BoardCmd;
import board.command.BoardListCmd;

@WebServlet("*.bbs")
public class BoardFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 *@see HttpServlet#HttpServlet()
	 */
	public BoardFrontController(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());
		
		BoardCmd cmd = null;
		String viewPage = null;
		
		// 글 목록 조회 처리
		if(cmdURI.equals("/boardList.bbs")){
			cmd = new BoardListCmd();
			cmd.execute(request, response);
			viewPage = "view/boardList.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
		
	}
	
	

}
