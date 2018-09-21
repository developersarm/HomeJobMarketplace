/*
 * Copyright 2018 (c) Abhay
 * Bangalore, India.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Abhay Yadav. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and Abhay.
 */
package org.care.controller.seeker;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.care.context.MyApplicationContext;
import org.care.dto.SeekerJobApplicationDTO;
import org.care.service.SeekerService;
import org.care.utils.CommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created 9/20/2018 6:43 PM
 *
 * @author Abhay Yadav
 */
public class ListJobAppAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int userId = MyApplicationContext.get().getMember().getMemberId();

        String jobIdRaw = request.getParameter("JobId");
        if (jobIdRaw != null && !jobIdRaw.isEmpty() && jobIdRaw.matches("^[0-9]+$")) {
            int jobId = Integer.parseInt(jobIdRaw);

            if (userId == SeekerService.getUserIdforJobId(jobId)) {

                String jobTitle = SeekerService.getJobTitle(jobId);
                List<SeekerJobApplicationDTO> seekerJobAppDTOS = SeekerService.getJobApplicationsByJobId(jobId);
                request.setAttribute("jobApplications", seekerJobAppDTOS);
                request.setAttribute("jobTitle", jobTitle);

                return mapping.findForward("jobAppListPage");
            }
        }
        return mapping.findForward("failure");
    }
}
