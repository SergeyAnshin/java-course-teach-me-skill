package com.ans.serg.restsecurity.service;

import com.ans.serg.restsecurity.dto.UserSignupDTO;
import com.ans.serg.restsecurity.entity.Role;
import com.ans.serg.restsecurity.entity.User;
import com.ans.serg.restsecurity.entity.UserRole;
import com.ans.serg.restsecurity.exception.EntityAlreadyExistsException;
import com.ans.serg.restsecurity.mapper.UserMapper;
import com.ans.serg.restsecurity.repository.RoleRepository;
import com.ans.serg.restsecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User signup(UserSignupDTO userSignupDTO) {
        if (userRepository.existsByUsername(userSignupDTO.getUsername())) {
            throw new EntityAlreadyExistsException("User with this username already exists!");
        } else {
            User user = UserMapper.fromUserSignupDTOToUser(userSignupDTO);
            Set<Role> roles = new HashSet<>() {{
                add(roleRepository.findAllByName(UserRole.USER.name()).orElse(null));
            }};
            user.setRoles(roles);
            return userRepository.save(user);
        }
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return UserMapper.fromUserToUserUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("User with this username doesn't exist!");
        }
    }
}
