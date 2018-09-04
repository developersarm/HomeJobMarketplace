package org.care.presentation.member;

import org.care.dto.ProfileDTO;
import org.care.dto.SeekerProfileDTO;
import org.care.dto.SitterProfileDTO;
import org.care.model.Member;
import org.care.model.Seeker;
import org.care.model.Sitter;
import org.care.service.SeekerService;
import org.care.service.SitterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String phoneNo = req.getParameter("phoneno");
        String emailId = req.getParameter("emailid");
        String address = req.getParameter("address");
        int pincode = Integer.parseInt(req.getParameter("pincode"));

        Member.MemberType memberType = (Member.MemberType) req.getSession().getAttribute("MemberType");
        ProfileDTO profileData;
        if (memberType == Member.MemberType.SITTER) {
            int experience = Integer.parseInt(req.getParameter("experience"));
            profileData = new SitterProfileDTO(firstName, lastName, phoneNo, emailId, address, pincode, experience);
        } else if (memberType == Member.MemberType.SEEKER) {
            int totalChildren = Integer.parseInt(req.getParameter("totalchildren"));
            String spouseName = req.getParameter("spousename");
            profileData = new SeekerProfileDTO(firstName, lastName, phoneNo, emailId, address, pincode, totalChildren, spouseName);
        } else {
            //todo: write something else in here
            profileData = null;
        }
        req.setAttribute("ProfileData", profileData);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/member/editprofile.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get of edit profile servlet called");
    }
}