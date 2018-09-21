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
package org.care.controller.sitter;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.care.context.MyApplicationContext;
import org.care.dto.SitterNAJobDTO;
import org.care.service.SitterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created 9/20/2018 6:43 PM
 *
 * @author Abhay Yadav
 */
public class ListJobAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int userId = MyApplicationContext.get().getMember().getMemberId();
        List<SitterNAJobDTO> sitterNAJobDTOS = SitterService.getNAJobsList(userId);

        request.setAttribute("JobsList", sitterNAJobDTOS);
        return mapping.findForward("listJobPage");
    }
}
