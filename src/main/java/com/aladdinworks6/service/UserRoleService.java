package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.UserRole;
import com.aladdinworks6.dto.UserRoleDTO;
import com.aladdinworks6.dto.UserRoleSearchDTO;
import com.aladdinworks6.dto.UserRolePageDTO;
import com.aladdinworks6.dto.UserRoleConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface UserRoleService extends GenericService<UserRole, Integer> {

	List<UserRole> findAll();

	ResultDTO addUserRole(UserRoleDTO userRoleDTO, RequestDTO requestDTO);

	ResultDTO updateUserRole(UserRoleDTO userRoleDTO, RequestDTO requestDTO);

    Page<UserRole> getAllUserRoles(Pageable pageable);

    Page<UserRole> getAllUserRoles(Specification<UserRole> spec, Pageable pageable);

	ResponseEntity<UserRolePageDTO> getUserRoles(UserRoleSearchDTO userRoleSearchDTO);
	
	List<UserRoleDTO> convertUserRolesToUserRoleDTOs(List<UserRole> userRoles, UserRoleConvertCriteriaDTO convertCriteria);

	UserRoleDTO getUserRoleDTOById(Integer userRoleId);







}





