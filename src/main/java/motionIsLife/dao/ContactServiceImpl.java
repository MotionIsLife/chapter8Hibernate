package motionIsLife.dao;

import com.google.common.collect.Lists;
import motionIsLife.vo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("springJpaContactService")
@Repository
@Transactional

public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findByFirstName(String firstName) {
        return Lists.newArrayList(contactRepository.findByFirstName(firstName));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return Lists.newArrayList(contactRepository.findByFirstNameAndLastName(firstName, lastName));
    }
}
