package motionIsLife.dao;

import motionIsLife.vo.Contact;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @Qualifier("emfA")
    @PersistenceContext(unitName = "emfA")
    private EntityManager emA;

    @Qualifier("emfB")
    @PersistenceContext(unitName = "emfB")
    private EntityManager emB;

    @Override
    public Contact save(Contact contact) {
        Contact contactB = new Contact();
        contactB.setFirstName(contact.getFirstName());
        contactB.setLastName(contact.getLastName());
        contactB.setBirthDate(contact.getBirthDate());
        if(contact.getId() == null) {
            emA.persist(contact);
            emB.persist(contactB);
        } else {
            emA.merge(contact);
            emB.merge(contactB);
        }
        return contact;
    }
}
