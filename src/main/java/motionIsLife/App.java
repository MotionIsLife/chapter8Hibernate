package motionIsLife;

import motionIsLife.dao.ContactService;
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
        ContactService contactDao = ctx.getBean("contactDao", ContactService.class);
        Contact contact = contactDao.findById(1L);
        contactDao.delete(contact);
        listContactsWithDetail(contactDao.findAllWithDetail());
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
