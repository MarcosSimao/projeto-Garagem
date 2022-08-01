package com.api.parkingcontrol.config.security;

import com.api.parkingcontrol.model.entites.UserModel;
import com.api.parkingcontrol.model.exception.ObjectNotFoundException;
import com.api.parkingcontrol.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceDetails implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      UserModel userModel=userRepository.findByUserName(username)
              .orElseThrow(()->new ObjectNotFoundException("Usuario nao existe "));
      return new UserPrincipal(userModel);
    }
}
