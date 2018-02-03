package motionIsLife;

import motionIsLife.dao.ContactDao;
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
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        listContactsWithDetail(contactDao.findAll());
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
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
