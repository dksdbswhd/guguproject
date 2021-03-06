package com.jcpdev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.controller.action.Action;
import com.jcpdev.controller.action.ActionForward;
import com.jcpdev.controller.action.BoardCommentDeleteAction;
import com.jcpdev.controller.action.BoardCommentInsertAction;
import com.jcpdev.controller.action.BoardCommentListAction;
import com.jcpdev.controller.action.BoardHeartupdate;
import com.jcpdev.controller.action.DeleteFriend;
import com.jcpdev.controller.action.GalleryCategoryAction;
import com.jcpdev.controller.action.GalleryCategoryAdd;
import com.jcpdev.controller.action.GalleryCommentDeleteAction;
import com.jcpdev.controller.action.GalleryCommentInsertAction;
import com.jcpdev.controller.action.GalleryCommentListAction;
import com.jcpdev.controller.action.GalleryDeleteAction;
import com.jcpdev.controller.action.GalleryHeartupdate;
import com.jcpdev.controller.action.GalleryInsertAction;
import com.jcpdev.controller.action.GalleryInsertBeforeAction;
import com.jcpdev.controller.action.GalleryMainAction;
import com.jcpdev.controller.action.GalleryUpdateAction;
import com.jcpdev.controller.action.GalleryUpdateViewAction;
import com.jcpdev.controller.action.GbookCommentDeleteAction;
import com.jcpdev.controller.action.GbookCommentInsertAction;
import com.jcpdev.controller.action.GbookCommentListAction;
import com.jcpdev.controller.action.GuestBookAction;
import com.jcpdev.controller.action.GuestBookAddAction;
import com.jcpdev.controller.action.GuestBookDeleteAction;
import com.jcpdev.controller.action.GuestBookSaveAction;
import com.jcpdev.controller.action.GuguBoardAction;
import com.jcpdev.controller.action.GuguBoardDelete;
import com.jcpdev.controller.action.GuguBoardDetailAction;
import com.jcpdev.controller.action.GuguBoardSave;
import com.jcpdev.controller.action.GuguBoardUpdataView;
import com.jcpdev.controller.action.GuguBoardUpdateSave;
import com.jcpdev.controller.action.GuguBoardAction;
import com.jcpdev.controller.action.LoginAction;
import com.jcpdev.controller.action.LogoutAction;
import com.jcpdev.controller.action.LookForEmailAction;
import com.jcpdev.controller.action.LookForPWAction;
import com.jcpdev.controller.action.MateAction;
import com.jcpdev.controller.action.MemberAction;
import com.jcpdev.controller.action.MiniHomeAction;
import com.jcpdev.controller.action.NewFriendAction;
import com.jcpdev.controller.action.NewMateAction;
import com.jcpdev.controller.action.ProfileMainAction;
import com.jcpdev.controller.action.ProfileModifyAction;
import com.jcpdev.controller.action.ProfileUpdateAction;
import com.jcpdev.controller.action.RequestFriendAction;
import com.jcpdev.controller.action.RequestMateAction;
import com.jcpdev.controller.action.ShortIntroUpdateAction;
import com.jcpdev.controller.action.TitleUpdateAction;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	//??????Method ???????????? ?????? -> doGet() ?????? doPost()????????? ???????????? ????????? ??????.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward=null; 
		String spath = request.getServletPath();
		String path="home.jsp";
		String url ="./";   //?????? request.getContextPath();
		
		if(spath.equals("/member.do")) { //???????????? ???????????? ???????????? ??????????????? ??????  
			path = "user/member.jsp";
			forward = new ActionForward(false,path); 
		}else if(spath.equals("/member_save.do")) { // ????????? ????????? ?????????????????? dao.insert
			Action action = new MemberAction();
			forward = action.execute(request, response);      
		}else if(spath.equals("/login.do")) {  // ????????? ???????????? jsp (?????????,?????? ???????????? ??????)
			path = "user/loginView.jsp";
			forward = new ActionForward(false,path); 
		}else if(spath.equals("/loginAction.do")) {// ?????????,?????? ?????????????????? dao.login
			Action action = new LoginAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/logout.do")) { // ????????? ??????????????? ???????????? ????????? ?????????.-----------------------------------------------
			Action action = new LogoutAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/home.do")) {  // ?????????,???????????? ??? ???????????? 
			path = "index.jsp";
			forward = new ActionForward(false,path);
		}else if(spath.equals("/lostPW.do")) {  // ?????? ????????????
			path = "user/lostPW.jsp";
			forward = new ActionForward(false,path); 
		}else if(spath.equals("/lookForPW.do")) { // ???????????? dao.lookForPW
			Action action = new LookForPWAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/lostEmail.do")) {  // email ????????????
			path = "user/lostEmail.jsp";
			forward = new ActionForward(false,path); 
		}else if(spath.equals("/lookForEmail.do")) { // email(?????????)?????? dao.lookForEmail
			Action action = new LookForEmailAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/profileMain.do")) {  // ????????? ???????????? ?????? ????????? (??????x)--------------------------------------------
			Action action = new ProfileMainAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/profileModify.do")) {  // ?????? ?????????????????? ??????
			Action action = new ProfileModifyAction();
			forward = action.execute(request, response); 
		}else if(spath.equals("/profileUpdate.do")) {  // ?????????,???????????? ??? ???????????? 
			Action action = new ProfileUpdateAction();
			forward = action.execute(request, response); 
		}else if(spath.equals("/gallery.do")) {  // ????????? ???????????? ?????? ????????? (??????x)------------------------------------------
			Action action = new GalleryMainAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/gallerycategory.do")) { //?????? 10??? 25??? 13???-
			Action action = new GalleryCategoryAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/galleryRegist.do")) {
			Action action = new GalleryInsertBeforeAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/galleryInsert.do")) {  
			Action action = new GalleryInsertAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/galleryUpdateView.do")) {
			Action action = new GalleryUpdateViewAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/galleryUpdate.do")) {
			Action action = new GalleryUpdateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/categoryadd.do")) {
			Action action = new GalleryCategoryAdd();
			forward = action.execute(request, response);
		}					
		
		//?????? mate ?????? ??????  do
		// minjae(10??? 19?????? ?????? ????????????)
		else if(spath.equals("/minihome.do")) {
			Action action = new MiniHomeAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/mateAction.do")) {
			Action action = new MateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/newfriend.do")) {
			Action action = new NewFriendAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/newmate.do")) {
			Action action = new NewMateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/requestfriendaction.do")) {
			Action action = new RequestFriendAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/requestmateaction.do")) {
			Action action = new RequestMateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/deletefriend.do")) {
			Action action = new DeleteFriend();
			forward = action.execute(request, response);
		}
		
		
		// ?????? ????????? 10??? 20??? ????????? ??????(??????)	????????? ?????? ?????????, ?????? ?????????, ??????					
		else if(spath.equals("/galleryDelete.do")) {
			Action action = new GalleryDeleteAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/galleryCommentInsert.do")) {
			Action action = new GalleryCommentInsertAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/galleryCommentList.do")) {
			Action action = new GalleryCommentListAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/galleryCommentDelete.do")) {
			Action action = new GalleryCommentDeleteAction();
			forward = action.execute(request, response);
		}
						
		//?????????????????? ?????? ??????(10??? 20??? ??????????????? ?????????)
		else if(spath.equals("/guestbook.do")) { 
			Action action = new GuestBookAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/guestbookadd.do")) { 
			Action action = new GuestBookAddAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/guestbooksave.do")) { 
			Action action = new GuestBookSaveAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/guestbookdelete.do")) { 
			Action action = new GuestBookDeleteAction();
			forward = action.execute(request, response);
		}
		
		
		//????????? ?????? (10??? 21??? ???????????????)
		else if(spath.equals("/guguboard.do")) {
			Action action = new GuguBoardAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/newboard.do")) {
			path="view/boardinsert.jsp";
			forward=new ActionForward(false,path);
		}else if(spath.equals("/newboardsave.do")) {
			Action action = new GuguBoardSave();
			forward = action.execute(request, response);
		}else if(spath.equals("/boarddetail.do")) {
			Action action = new GuguBoardDetailAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/boardupdate.do")) {
			Action action = new GuguBoardUpdataView();
			forward = action.execute(request, response);
		}else if(spath.equals("/updatesave.do")) {
			Action action = new GuguBoardUpdateSave();
			forward = action.execute(request, response);
		}else if(spath.equals("/boarddelete.do")) {
			Action action = new GuguBoardDelete();
			forward = action.execute(request, response);
		}
		
		//????????? [10???23???] ????????? ?????? ??????
		//????????? ?????? ??????
		else if(spath.equals("/gbookCommentInsert.do")) {
			Action action = new GbookCommentInsertAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/gbookCommentList.do")) {
			Action action = new GbookCommentListAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/gbookCommentDelete.do")) {
			Action action = new GbookCommentDeleteAction();
			forward = action.execute(request, response);
		}
		//????????? ?????? ??????
		else if(spath.equals("/boardCommentInsert.do")) {
			Action action = new BoardCommentInsertAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/boardCommentList.do")) {
			Action action = new BoardCommentListAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/boardCommentDelete.do")) {
			Action action = new BoardCommentDeleteAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/shortUpdate.do")) {  //?????? ????????? ????????????
			Action action = new ShortIntroUpdateAction();
			forward = action.execute(request, response);
		}else if(spath.equals("/titleUpdate.do")) {  //?????? ????????? ????????????
			Action action = new TitleUpdateAction();
			forward = action.execute(request, response);
		}
		
		// ????????? 
		else if(spath.equals("/galleryheartupdate.do")) {
			Action action = new GalleryHeartupdate();
			forward = action.execute(request, response);
		}else if(spath.equals("/BoardHeartupdate.do")) {
			Action action = new BoardHeartupdate();
			forward = action.execute(request, response);
		}
		
		
		//??? ???????????? forward ??? isRedirect ??? url ?????? ?????????????????? ok!
		if(forward.isRedirect()) {   //?????? boolean ????????? getXXX ????????? isXXX ?????????.
			response.sendRedirect(forward.getUrl());
		}else {
			RequestDispatcher rd 
			= request.getRequestDispatcher(forward.getUrl()); //getRequest????????? ??????
			rd.forward(request, response);
		}
		
	}

}
