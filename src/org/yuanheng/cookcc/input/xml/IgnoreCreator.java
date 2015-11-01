/*
 * Copyright (c) 2008-2013, Heng Yuan
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *    Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *    Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *    Neither the name of the Heng Yuan nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Heng Yuan ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Heng Yuan BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.yuanheng.cookcc.input.xml;

import org.w3c.dom.Element;
import org.yuanheng.cookcc.doc.IgnoreDoc;

import cookxml.core.DecodeEngine;
import cookxml.core.interfaces.Creator;

/**
 * @author Heng Yuan
 * @version $Id: TokensCreator.java 750 2013-11-10 01:00:02Z superduperhengyuan@gmail.com $
 * @since 0.4
 */
class IgnoreCreator implements Creator
{
	public Object create (String parentNS, String parentTag, Element elm, Object parentObj, DecodeEngine decodeEngine) throws Exception
	{
		IgnoreDoc ignoreDoc = new IgnoreDoc ();
		Integer lineNum = (Integer)elm.getUserData ("line");
		if (lineNum != null)
			ignoreDoc.setLineNumber (lineNum.intValue ());
		return ignoreDoc;
	}

	public Object editFinished (String parentNS, String parentTag, Element elm, Object parentObj, Object obj, DecodeEngine decodeEngine) throws Exception
	{
		return obj;
	}
}