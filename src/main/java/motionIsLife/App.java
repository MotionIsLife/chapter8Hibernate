package motionIsLife;

import motionIsLife.dao.ContactSummaryUntypeImpl;
import motionIsLife.vo.Contact;
import motionIsLife.vo.ContactTelDetail;
import motionIsLife.vo.Hobby;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();
        ContactSummaryUntypeImpl contactSummaryUntypeImpl = ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
        contactSummaryUntypeImpl.displayAllContactSummary();
    }

    private static void getById(Contact contact) {
        System.out.println("\n" + "getById " + contact + "\n");
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("listContactsWithDetail");
        for (Contact contact : contacts) {
            System.out.println("\n" + contact);
            if(contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
            if(contact.getHobbies() != null) {
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
        }
    }
}
