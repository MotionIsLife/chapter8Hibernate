package motionIsLife;

import motionIsLife.dao.ContactService;
import motionIsLife.vo.Contact;
import motionIsLife.vo.ContactTelDetail;
import motionIsLife.vo.Hobby;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

public class App {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);

        Contact contact = contactService.findById(1L);
        contactService.delete(contact);
        listContactsWithDetail(contactService.findAllWithDetail());
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
