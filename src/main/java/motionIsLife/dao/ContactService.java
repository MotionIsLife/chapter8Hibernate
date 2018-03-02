package motionIsLife.dao;

import motionIsLife.vo.Contact;

import java.util.List;

public interface ContactService {
    List findAll();
    List<Contact> findAllWithDetail();
    List<Contact> findAllByNativeQuery();
    List<Contact> findByCriteriaQuery(String firstName, String lastName);
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
