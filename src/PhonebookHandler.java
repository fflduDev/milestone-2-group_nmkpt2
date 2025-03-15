import java.util.*;

/**
 * PhonebookHandler - supports Phonebook operations
 * 
 * Use a map to build the Phonebook key: Contact value: List<phonebookEntries>
 */

public class PhonebookHandler implements iPhonebookHander {

	private Map<String, Contact> phonebook = new HashMap<>();
	
	public PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook2) {
		this.phonebook = new HashMap<>();
	    for (Map.Entry<Contact, List<PhonebookEntry>> entry : phonebook2.entrySet()) {
	        this.phonebook.put(entry.getKey().getName(), entry.getKey()); // Store by name
	    }
	}

	@Override
	public List<Contact> sortByName() {
		
		List<Contact> contacts = new ArrayList<>(phonebook.values());		
		mergeSort(contacts, 0, contacts.size() - 1);
		// Debugging output: check sorted names
	    /*System.out.println("Sorted Contacts:");
	    for (Contact c : contacts) {
	        System.out.println(c.getName());
	    }*/
		return contacts;
	}
	
	static void merge(List<Contact> contacts, int leftFirst, int leftLast, int rightFirst, int rightLast) {
		List<Contact> tempArray = new ArrayList<>();
		int index = leftFirst;
		int saveFirst = leftFirst; // to remember where to copy back

		while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
			if (contacts.get(leftFirst).getName().compareTo(contacts.get(rightFirst).getName()) < 0){
				tempArray.add(contacts.get(leftFirst));
				leftFirst++;
			} else {
				tempArray.add(contacts.get(rightFirst));
				rightFirst++;
			}
			index++;
		}

		while (leftFirst <= leftLast)
		// Copy remaining items from left half.

		{
			tempArray.add(contacts.get(leftFirst));
			leftFirst++;
			index++;
		}

		while (rightFirst <= rightLast)
		// Copy remaining items from right half.
		{
			tempArray.add(contacts.get(rightFirst));
			rightFirst++;
			index++;
		}

		for (index = saveFirst; index <= rightLast; index++)
			contacts.set(index, tempArray.get(index-saveFirst));
	}

	static void mergeSort(List<Contact> contacts, int first, int last) {
		if (first < last) {
			int middle = (first + last) / 2;
			mergeSort(contacts, first, middle);
			mergeSort(contacts, middle + 1, last);
			merge(contacts, first, middle, middle + 1, last);
		}
	}
	
	@Override
	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
		List<PhonebookEntry> entries = new ArrayList<>();
		int left = 0;
		int right = sortedContacts.size() - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			Contact midContact = sortedContacts.get(mid);
			int comparison = midContact.getName().compareToIgnoreCase(name);
			
			if (comparison == 0) {
				entries = midContact.getpbEntries();
				break;
			} else if (comparison < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (entries.isEmpty()) {
			System.out.println(name + " not found");
		}
		return entries;
	}

	@Override
	public void display(List<Contact> sortedContacts) {
		for(Contact contact :sortedContacts) {
			System.out.println("name: " + contact.getName());
			for (PhonebookEntry entry : contact.getpbEntries()) {
				System.out.println(entry.getType()+ entry.getPhoneNumber());
			}
		}
	}

}
