package motionIsLife.dao;

import motionIsLife.vo.Contact;
import motionIsLife.vo.Contact_;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @PersistenceContext
    private EntityManager em;

    private final String ALL_CONTACT_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from contact";

    @Override
    public List findAll() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
        return contacts;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAllWithDetail() {
        List<Contact> contactsWithDetails = em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
        return contactsWithDetails;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult").getResultList();
    }

    @Override
    public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
        Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
        contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
        contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
        criteriaQuery.select(contactRoot).distinct(true);
        Predicate criteria = cb.conjunction();
        if(firstName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.firstName), firstName);
            criteria = cb.and(criteria, p);
        }
        if(lastName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.lastName), lastName);
            criteria = cb.and(criteria, p);
        }
        criteriaQuery.where(criteria);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Contact findById(Long id) {
        Contact contact = em.createNamedQuery("Contact.findById", Contact.class).setParameter("id", id).getSingleResult();
        return contact;
    }

    @Override
    public Contact save(Contact contact) {
        if(contact.getId() == null) {
            System.out.println("inserting new contact");
            em.persist(contact);
        } else {
            em.merge(contact);
            System.out.println("updating existing contact");
        }
        System.out.println("contact saving with id:" + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        Contact mergeContact = em.merge(contact);
        em.remove(mergeContact);
        System.out.println("Contact with id: " + contact.getId() + " deleted successfully");
    }
}
