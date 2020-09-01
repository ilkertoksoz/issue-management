package com.ilkert.issuemanagement.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ilkert.issuemanagement.entity.User;

public interface UserService {

    User Save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUserName(String username);
}
