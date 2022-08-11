package com.myusufalpian.utilities;

import com.myusufalpian.models.entities.AppUser;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareUtils implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        AppUser currentUser = (AppUser) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return Optional.of(currentUser.getEmail());
    }
}
