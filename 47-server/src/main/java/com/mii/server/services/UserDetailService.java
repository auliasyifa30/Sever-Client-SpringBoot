
package com.mii.server.services;

import com.mii.server.dtos.LoginDTO;
import com.mii.server.entities.Privileges;
import com.mii.server.entities.Role;
import com.mii.server.entities.Users;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public Users loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = userRepository.findByUserName(userName);
        if(userRepository == null) {
            throw new UsernameNotFoundException(userName + "Not Found");
        }
            return users;
    }
    
    public String loadByUserName(String userName, String userPassword) {
        Users userDB = userRepository.findByUserName(userName);
        Users user = new Users();
        if (userDB == null) {
            throw new UsernameNotFoundException("username not found");
        } else {
            if (!userDB.getPassword().equals(userPassword)) {
            } else {
                System.out.println("Session Sukses");
            }
            return userDB.getUsername();
        }
    }
    
    //untuk mendapatkan get authorities
    public LoginDTO loginDTO(String userName) {
        Users user = new Users();
        Integer userId = userRepository.findByUserName(userName).getUserId();
        List<Role> roles = userRepository.findByUserName(userName).getRoleList();
        List<String> authorities = new ArrayList<>();

        for (Role r : roles) {
            authorities.add("ROLE_" + r.getRoleName().toUpperCase());
            List<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesList();
            for (Privileges p : privileges) {
                authorities.add(p.getPrivilegeName());
            }
        }

        LoginDTO log = new LoginDTO(userName, authorities);
        return log;
    }
    
    //authentication token (session) ==> pencocokan password
    public String login(String userName, String userPassword){
        BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
        Users users = new Users();
        Users userFromdb = userRepository.findByUserName(userName);
        if (userFromdb != null){
            if (!userFromdb.getPassword().equals(userPassword)){
//            if (!(pass.matches(userPassword, userFromdb.getPassword()))){
                throw new UsernameNotFoundException("kata sandi salah");
            }else{
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userFromdb.getUsername(),
                userFromdb.getPassword(), userFromdb.getAuthorities());
//                Authentication authentication = authenticationManager.authenticate(authToken);
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("Session Created");
            }
            return userFromdb.getUsername();
        }else{
            throw new UsernameNotFoundException("username tidak ditemukan");
        }
    }
    
    
}
