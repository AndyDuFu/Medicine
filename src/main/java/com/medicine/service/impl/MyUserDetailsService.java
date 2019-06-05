//ipackage com.medicine.service.impl;
//
//import com.medicine.domain.User;
//import com.medicine.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Slf4j
//public class MyUserDetailsService implements UserDetailsService{
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = this.userService.findUserByUserName(username);
//        log.debug(user.getUserName()+"密码"+user.getPassword());
//        if(null == user) {
//            throw new UsernameNotFoundException("Can't find user by username: " + username);
//        }
//
//        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);  //角色认证
//    }
//}
