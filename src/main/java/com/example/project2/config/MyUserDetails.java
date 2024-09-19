package com.example.project2.config;

import com.example.project2.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private final User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Возвращаем null или роли, если они есть
        return null; // Если у пользователя есть роли, верните их здесь
    }

    @Override
    public String getPassword() {
        return user.getPassword();  // Возвращаем пароль пользователя
    }

    @Override
    public String getUsername() {
        return user.getUsername();  // Возвращаем имя пользователя
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Логика для проверки истечения аккаунта (всегда true, если нет особых условий)
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Логика для проверки блокировки аккаунта (всегда true, если нет особых условий)
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Логика для проверки срока действия учетных данных (всегда true)
    }

    @Override
    public boolean isEnabled() {
        return true;  // Логика для проверки, активен ли аккаунт (всегда true, если нет особых условий)
    }
}
