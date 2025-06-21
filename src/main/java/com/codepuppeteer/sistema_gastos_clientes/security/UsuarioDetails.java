package com.codepuppeteer.sistema_gastos_clientes.security;

import com.codepuppeteer.sistema_gastos_clientes.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsuarioDetails implements UserDetails {

    private final Usuario usuario;

    public UsuarioDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().name()));
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return usuario.getActivo();
    }

    @Override
    public boolean isAccountNonLocked() {
        return usuario.getActivo();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return usuario.getActivo();
    }

    @Override
    public boolean isEnabled() {
        return usuario.getActivo();
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
