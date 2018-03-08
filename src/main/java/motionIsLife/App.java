package motionIsLife;

import motionIsLife.dao.ContactService;
import motionIsLife.vo.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("contactService", ContactService.class);

        Contact contactA = new Contact();
        contactA.setFirstName("aaa");
        contactA.setLastName("bbb");
        contactService.save(contactA);
        System.out.println("contact saved successfully");
    }
}
