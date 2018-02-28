package motionIsLife.dao;

import motionIsLife.vo.ContactSummary;

import java.util.List;

public interface ContactSummaryService {
    List<ContactSummary> findAll();
}
