/*
 * Copyright (c) 2008, Heng Yuan
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Heng Yuan nor the
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
package org.yuanheng.cookcc.codegen.xml;

import java.io.OutputStream;
import java.io.PrintWriter;

import org.yuanheng.cookcc.doc.Document;
import org.yuanheng.cookcc.interfaces.CodeGen;
import org.yuanheng.cookcc.interfaces.OptionParser;

/**
 * @author Heng Yuan
 * @version $Id$
 */
public class XmlCodeGen implements CodeGen
{
	private final static OptionParser[] s_optionParsers = null;

	private void printTokens (Document doc, PrintWriter p)
	{
		String[] tokens = doc.getTokens ();
		if (tokens.length == 0)
			return;
		p.print ("\t<tokens>");
		for (int i = 0; i < tokens.length; ++i)
		{
			if ((i % 5)> 0)
				p.print (" ");
			else
			{
				p.println ();
				p.print ("\t\t");
			}
			p.print (tokens[i]);
		}
		p.println ();
		p.println ("\t</tokens>");
	}

	private void printDocument (Document doc, PrintWriter p)
	{
		p.println ("<codecc>");
		StringBuffer buffer = doc.getHeader ();
		if (buffer.length () > 0)
		{
			p.print ("\t<header>");
			p.print (buffer);
			p.println ("</header>");
		}
		printTokens (doc, p);
		new XmlLexerOutput ().printLexer (doc.getLexer (), p);
		new XmlParserOutput ().printParserDoc (doc.getParser (), p);
		p.println ("</codecc>");
	}

	public void generateOutput (Document doc, OutputStream os)
	{
		PrintWriter p = new PrintWriter (os);
		printDocument (doc, p);
		p.flush ();
	}

	public OptionParser[] getOptionParsers ()
	{
		return new OptionParser[0];
	}
}
