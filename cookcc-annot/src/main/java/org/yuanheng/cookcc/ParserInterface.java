package org.yuanheng.cookcc;

import java.io.IOException;

/**
 * This interface is not used for anything.  It is only a reminder of what
 * functions are required in a Parser generated by the CookCC without Lexer.
 * <p>
 * These functions do not need to be public.  They can protected or package
 * access.
 *
 * @author	Heng Yuan
 * @since	0.4
 */
public interface ParserInterface
{
	/**
	 * This function is used by the parser get the input from the lexer.
	 *
	 * @return	a status value.
	 * @throws	IOException
	 *			in case of I/O error.
	 */
	int yyLex ();

	/**
	 * Return the object associated with the token.
	 *
	 * @return	the object associated with the token.
	 */
	Object yyValue ();
}
