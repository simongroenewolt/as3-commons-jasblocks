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

/**
 * A XML literal; <code>&lt;foo id="bar"&gt;goo&lt;/foo&gt;</code>.
 * 
 * <pre>
 * IASXMLLiteral ul = factory.newXMLLiteral();
 * </pre>
 * 
 * <p>Will produce; <code>todo</code></p>
 * 
 * @author Michael Schmalle
 * @copyright Teoti Graphix, LLC
 * @since 1.0
 * 
 * @see org.as3commons.asblocks.ASFactory#newXMLLiteral()
 */
public interface IASXMLLiteral extends IASLiteral
{
	/**
	 * The <code>String</code> literal value.
	 * 
	 * @return The XML <code>String</code> value.
	 */
	public String getValue();
}
