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
 * Part of the DimDim V 1.0 Codebase (http://www.dimdim.com)	          *
 *                                                                        *
 * Copyright (c) 2006 Communiva Inc. All Rights Reserved.                 *
 *                                                                        *
 *                                                                        *
 * This code is licensed under the DimDim License                         *
 * For details please visit http://www.dimdim.com/license                 *
 *                                                                        *
 **************************************************************************
 */
 
package com.dimdim.conference.action.whiteboard;

import com.dimdim.conference.ConferenceConstants;
import com.dimdim.conference.action.ConferenceAction;
import com.dimdim.conference.model.IConference;
import com.dimdim.conference.model.IConferenceParticipant;

/**
 * @author Jayant Pandit
 * @email Jayant.Pandit@communiva.com
 *
 */
public class WhiteboardControlAction		extends	ConferenceAction
{
	protected	String	cmd;
	protected	String	ri;		//	resourceId
	protected	String	si;		//	streamId
	
	public	WhiteboardControlAction()
	{
	}
	public	String	doWork()	throws	Exception
	{
		String	ret = SUCCESS;
		IConference conf = this.userSession.getConference();
		IConferenceParticipant user = this.userSession.getUser();
		
		try
		{
			System.out.println("Whiteboard control event: -"+cmd+"--"+si+"--");
			conf.getResourceManager().handleWhiteboardControlMessage(user, cmd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ret = ERROR;
		}
		return	ret;
	}
	public String getCmd()
	{
		return cmd;
	}
	public void setCmd(String cmd)
	{
		this.cmd = cmd;
	}
	public String getRi()
	{
		return ri;
	}
	public void setRi(String ri)
	{
		this.ri = ri;
	}
	public String getSi()
	{
		return si;
	}
	public void setSi(String si)
	{
		this.si = si;
	}
}
