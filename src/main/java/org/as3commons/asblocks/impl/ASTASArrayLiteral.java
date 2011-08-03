////////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Michael Schmalle - Teoti Graphix, LLC
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
// http://www.apache.org/licenses/LICENSE-2.0 
// 
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, 
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and 
// limitations under the License
// 
// Author: Michael Schmalle, Principal Architect
// mschmalle at teotigraphix dot com
////////////////////////////////////////////////////////////////////////////////

package org.as3commons.asblocks.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.as3commons.asblocks.dom.IASArrayLiteral;
import org.as3commons.asblocks.dom.IASExpression;
import org.as3commons.asblocks.parser.antlr.LinkedListTree;

public class ASTASArrayLiteral extends ASTLiteral implements IASArrayLiteral
{

	public ASTASArrayLiteral(LinkedListTree ast)
	{
		super(ast);
	}

	@Override
	public List<IASExpression> getEntries()
	{
		List<IASExpression> entries = new ArrayList<IASExpression>();
		ASTIterator i = new ASTIterator(ast);
		while (i.hasNext())
		{
			entries.add(ExpressionBuilder.build(i.next()));
		}
		return Collections.unmodifiableList(entries);
	}

	@Override
	public void add(IASExpression expression)
	{
		if (ast.getChildCount() > 0)
		{
			ast.appendToken(TokenBuilder.newComma());
			ast.appendToken(TokenBuilder.newSpace());
		}
		ast.addChildWithTokens(toAST(expression));
	}

	@Override
	public IASExpression remove(int index)
	{
		LinkedListTree old = (LinkedListTree) ast.getChild(index);
		if (ast.getChildCount() - 1 > index)
		{
			ASTUtils.removeTrailingWhitespaceAndComma(old.getStopToken());
		} else if (index > 0)
		{
			ASTUtils.removePreceedingWhitespaceAndComma(old.getStartToken());
		}
		ast.deleteChild(index);
		return ExpressionBuilder.build(old);
	}

}
