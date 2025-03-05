import java.util.List;

/**
 * model a Contact Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

class Contact {
	private String name;
	// create your list of PhonebookEntry
	private List<PhonebookEntry> pbEntries;

	public Contact(String name) {
		this.name = name;
		// initialize list
	}

	public void addPhonebookEntry(String number, String type) {
		// create a pbEntry with the incoming num/type
		// add that pbEntry to your list of pbEntries
	}
}
