/*
 * $Id$
 *
 * This file is part of the iText (R) project.
 * Copyright (c) 1998-2011 1T3XT BVBA
 * Authors: Balder Van Camp, Emiel Ackermann, et al.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License version 3
 * as published by the Free Software Foundation with the addition of the
 * following permission added to Section 15 as permitted in Section 7(a):
 * FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY 1T3XT,
 * 1T3XT DISCLAIMS THE WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA, 02110-1301 USA, or download the license from the following URL:
 * http://itextpdf.com/terms-of-use/
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License.
 *
 * In accordance with Section 7(b) of the GNU Affero General Public License,
 * a covered work must retain the producer line in every PDF that is created
 * or manipulated using iText.
 *
 * You can be released from the requirements of the license by purchasing
 * a commercial license. Buying such a license is mandatory as soon as you
 * develop commercial activities involving the iText software without
 * disclosing the source code of your own applications.
 * These activities include: offering paid services to customers as an ASP,
 * serving PDFs on the fly in a web application, shipping iText with a closed
 * source product.
 *
 * For more information, please contact iText Software Corp. at this
 * address: sales@itextpdf.com
 */
package com.itextpdf.tool.xml.html.table;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;

/**
 * @author redlab_b
 *
 */
public class TableRowElement implements Element {

	public enum Place{CAPTION_TOP(-2),HEADER(-1),BODY(0),FOOTER(1),CAPTION_BOTTOM(2);

		private Integer i;
		private Place(final Integer i) {
			this.i = i;
		}
		public Integer getI() {
			return i;
		}
	};
	private final Place place;
	private final List<HtmlCell> content;

    /**
     * @param currentContent
     * @param place 
     */
    public TableRowElement(final List<Element> currentContent, final Place place) {
        // filter out none TD elements, discard others
    	content = new ArrayList<HtmlCell>(currentContent.size());
    	for (Element e : currentContent) {
    		if (e instanceof HtmlCell) {
    			content.add((HtmlCell) e);
    		}
    	}
        this.place = place;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.text.Element#process(com.itextpdf.text.ElementListener)
     */
    public boolean process(final ElementListener listener) {
        return false;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.text.Element#type()
     */
    public int type() {
        return 0;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.text.Element#isContent()
     */
    public boolean isContent() {
        return false;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.text.Element#isNestable()
     */
    public boolean isNestable() {
        return false;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.text.Element#getChunks()
     */
    public List<Chunk> getChunks() {
        return null;
    }

    /**
     * @return the content
     */
    public List<HtmlCell> getContent() {
        return content;
    }

	/**
	 * @return the type of cell, defined by type of tag
	 */
	public Place getPlace() {
		return place;
	}
}
