/**
 * 
 */
package org.bernitt.imapfilter.rules.intents;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;
import javax.mail.Flags.Flag;

/**
 * Marks the message as read
 * 
 * @author fbe
 */
public class MarkAsReadIntent implements Intent {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bernitt.imapfilter.rules.intents.Intent#execute(javax.mail.Message,
	 * javax.mail.Store)
	 */
	public boolean execute(Message msg, Store store) throws MessagingException {
		msg.setFlag(Flag.SEEN, true);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": marking message as read";
	}
}
