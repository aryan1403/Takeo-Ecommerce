package util;



import com.takeo.ecommerce.entity.Users;
import org.jetbrains.annotations.Nullable;
//import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class SecurityUtils {

    /*public static @Nullable Users getCurrentUser(){
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principle instanceof Users){
            return (Users) principle;
        }
        return null;
    }

   /* public static String getRole(){
        User user = getCurrentUser();
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        for(GrantedAuthority authority: authorities){
            return authority.getAuthority();
        }
        return null;
    }*/
}
