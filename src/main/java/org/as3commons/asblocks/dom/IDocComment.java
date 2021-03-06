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

package org.as3commons.asblocks.dom;

import java.util.Iterator;
import java.util.List;

/**
 * The comment node of an <code>IDocCommentAware</code> client.
 * 
 * @author Michael Schmalle
 * @copyright Teoti Graphix, LLC
 * @since 1.0
 * 
 * @see org.as3commons.asblocks.dom.IDocCommentAware
 */
public interface IDocComment extends IScriptElement
{
	//--------------------------------------------------------------------------
	//
	//  Properties
	//
	//--------------------------------------------------------------------------

	//----------------------------------
	//  description
	//----------------------------------

	/**
	 * The <code>String</code> description of the comment.
	 * 
	 * <p>The description is all text minus an doc tags.</p>
	 * 
	 * @throws ASBlocksSyntaxError if the given text contains an end-of-comment
	 *         marker, or a tagged-paragraph
	 */
	public String getDescription();

	/**
	 * @see #getDescription()
	 * 
	 * @param value A <code>String</code> either creating a new description
	 * or replacing the old description AST nodes.
	 */
	public void setDescription(String value);

	/**
	 * Returns the <code>String</code> short description based on period and line
	 * ending format.
	 * 
	 * @return The <code>String</code> short description.
	 */
	public String getShortDescription();

	/**
	 * Returns the <code>String</code> long description based on period and line
	 * ending format of the short description.
	 * 
	 * <p>If there is only a short description, it will be returned.</p>
	 * 
	 * @return The <code>String</code> long description.
	 */
	public String getLongDescription();

	//--------------------------------------------------------------------------
	//
	//  Methods
	//
	//--------------------------------------------------------------------------

	/**
	 * Creates and appends a <code>IDocTag</code> tag to the documentation.
	 * 
	 * @param name The name of the new doc tag.
	 * @param body The body of the new doc tag.
	 * @return A new <code>IDocTag</code> instance.
	 * @throws ASBlocksSyntaxError if the given text contains an end-of-comment
	 *         marker, or a tagged-paragraph
	 */
	public IDocTag newDocTag(String name, String body);

	/**
	 * @see #newDocTag(String, String)
	 * @param name The name of the new doc tag.
	 * @return A new <code>IDocTag</code> instance.
	 */
	public IDocTag newDocTag(String name);

	/**
	 * Creates and appends a <code>IDocTag</code> tag to the documentation.
	 * 
	 * @param name The name of the new doc tag.
	 * @param index The index to add the new tag.
	 * @param body The body of the new doc tag.
	 * @return A new <code>IDocTag</code> instance.
	 * @throws ASBlocksSyntaxError if the given text contains an end-of-comment
	 *         marker, or a tagged-paragraph
	 */
	public IDocTag newDocTagAt(int index, String name, String body);

	/**
	 * @see #newDocTagAt(int, String, String)
	 * @param index The index to add the new tag.
	 * @param name The name of the new doc tag.
	 * @return A new <code>IDocTag</code> instance.
	 */
	public IDocTag newDocTagAt(int index, String name);

	/**
	 * Returns a <code>boolean</code> indicating whether the documentation
	 * contains an <code>IDocTag</code> by the name <code>name</code>.
	 * 
	 * @param name The <code>String</code> doc tag name to search for.
	 * @return A <code>boolean</code>; <code>true</code> contains the tag or
	 * <code>false</code> does not contain the tag.
	 */
	public boolean hasDocTag(String name);
	
	/**
	 * Returns all tags found in the documentation.
	 * 
	 * @return A <code>List</code> of <code>IDocTag</code>.
	 */
	public List<IDocTag> getAllTags();
	
	/**
	 * Returns an <code>Iterator</code> for all the tags by <code>name</code>.
	 * 
	 * <p>If the documentation does not contain any tags by name, the 
	 * <code>Iterator</code> is returned but containes nothing.</p>
	 * 
	 * @param name The name of <code>IDocTag</code> to return an 
	 * <code>Iterator</code> for.
	 * @return An <code>IDocTag</code> <code>Iterator</code>.
	 */
	public Iterator<IDocTag> getTags(String name);

	/**
	 * Returns the first <code>IDocTag</code> found in the documentation,
	 * <code>null</code> if there are no tags by name.
	 * 
	 * @param name The <code>IDocTag</code> name to search for.
	 * @return An <code>IDocTag</code> or <code>null</code>.  
	 */
	public IDocTag findFirstTag(String name);

	/**
	 * Removes the tag from the documentation.
	 * 
	 * @param The <code>IDocTag</code> to remove.
	 */
	public boolean removeDocTag(IDocTag tag);

}
