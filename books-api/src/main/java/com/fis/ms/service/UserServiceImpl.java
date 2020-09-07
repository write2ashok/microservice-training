package com.fis.ms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fis.ms.model.User;
import com.fis.ms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository mUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByUserName(String userName){
        return mUserRepository.findBySubscriberName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = mUserRepository.findBySubscriberName(userName);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        List<GrantedAuthority> role_name = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getSubscriberName(),
                user.getPassword(), role_name);
    }

	@Override
	public List<User> findAllUserByUserid(Long userid) {
		return mUserRepository.findAllById(userid);
	}

	@Override
	public User save(User address) {
		return mUserRepository.save(address);
	}

	@Override
	public User findUserById(Long id) {
		return mUserRepository.findUserById(id);
	}
}