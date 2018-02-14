package motionIsLife.dao;

import motionIsLife.vo.Contact;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
    }
    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        return sessionFactory.getCurrentSession().getNamedQuery("Contact.findAllWithDetail").list();
    }
    @Override
    public Contact findById(Long id) {
        return (Contact) sessionFactory.getCurrentSession().getNamedQuery("Contact.findById").setParameter("id", id).uniqueResult();
    }
    @Override
    public Contact save(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        System.out.println("Contact saved with id: " + contact.getId());
        return null;
    }
    @Override
    public void delete(Contact contact) {

    }
}
