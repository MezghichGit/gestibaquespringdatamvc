package com.sip.gestibanque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestibanque.entities.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role,Integer>{
	Role findByLibelle(String libelle);

}
