import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		this.pbEntries = new ArrayList<>();

	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void addPhonebookEntry(String number, String type) {
		// create a pbEntry with the incoming num/type
		// add that pbEntry to your list of pbEntries
		PhonebookEntry pbEntry = new PhonebookEntry(number, type);
		pbEntries.add(pbEntry);
	}
	
	public List<PhonebookEntry> getpbEntries(){
		return pbEntries;
	}
	
	// Override equals() to compare contacts by name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return Objects.equals(name, contact.name);
    }

    // Override hashCode() to match equals()
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // Override toString() for better debug output
    @Override
    public String toString() {
        return "Contact{name='" + name + "'}";
    }
	
}
