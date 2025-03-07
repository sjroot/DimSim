/*
 **************************************************************************
 *                                                                        *
 *               DDDDD   iii             DDDDD   iii                      *
 *               DD  DD      mm mm mmmm  DD  DD      mm mm mmmm           *
 *               DD   DD iii mmm  mm  mm DD   DD iii mmm  mm  mm          *
 *               DD   DD iii mmm  mm  mm DD   DD iii mmm  mm  mm          *
 *               DDDDDD  iii mmm  mm  mm DDDDDD  iii mmm  mm  mm          *
 *                                                                        *
 **************************************************************************
 **************************************************************************
 *                                                                        *
 * Part of the DimDim V 2.0 Codebase (http://www.dimdim.com)	          *
 *                                                                        *
 * Copyright (c) 2008 Dimdim Inc. All Rights Reserved.              	  *
 *                                                                        *
 *                                                                        *
 * This code is licensed under the DimDim License                         *
 * For details please visit http://www.dimdim.com/license                 *
 *                                                                        *
 **************************************************************************
 */

package com.dimdim.conference.ui.panels.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * @author Jayant Pandit
 * @email Jayant.Pandit@communiva.com
 * 
 */

public class StopRecordingQuestion2Widget extends VerticalPanel
{
	public	StopRecordingQuestion2Widget()
	{
		Label line1 = new Label("You have stopped recording your meeting.");
		line1.setWordWrap(true);
		line1.setStyleName("common-text");
		this.add(line1);
		this.setCellHorizontalAlignment(line1, HorizontalPanel.ALIGN_LEFT);
		this.setCellVerticalAlignment(line1, VerticalPanel.ALIGN_MIDDLE);
		
		Label line2 = new Label("Do you want to save this recording?");
		line2.setWordWrap(true);
		line2.setStyleName("common-text");
		this.add(line2);
		this.setCellHorizontalAlignment(line2, HorizontalPanel.ALIGN_LEFT);
		this.setCellVerticalAlignment(line2, VerticalPanel.ALIGN_MIDDLE);
	}
}
