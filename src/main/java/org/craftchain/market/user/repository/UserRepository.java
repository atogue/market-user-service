package org.craftchain.market.user.repository;

import org.craftchain.market.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
