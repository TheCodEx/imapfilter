/**
 * 
 */
package org.bernitt.imapfilter.config.search;

import java.util.List;

import javax.mail.search.OrTerm;
import javax.mail.search.SearchTerm;

/**
 * @author fbe
 * 
 */
public class OrSearchFilterTerm implements SearchFilterTerm {

	private final List<SearchFilterTerm> terms;

	public OrSearchFilterTerm(List<SearchFilterTerm> terms) {
		this.terms = terms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bernitt.imapfilter.config.search.SearchFilterTerm#toSearchTerm()
	 */
	public SearchTerm toSearchTerm() {
		SearchTerm[] ta = new SearchTerm[this.terms.size()];
		for (int i = 0; i < this.terms.size(); i++) {
			ta[i] = this.terms.get(i).toSearchTerm();
		}
		return new OrTerm(ta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < this.terms.size(); i++) {
			if (i > 0) {
				b.append(" || ");
			}
			b.append(this.terms.get(i));
		}

		return b.toString();
	}
}
