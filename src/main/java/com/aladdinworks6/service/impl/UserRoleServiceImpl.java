package com.aladdinworks6.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.service.impl.GenericServiceImpl;
import com.aladdinworks6.dao.UserRoleDAO;
import com.aladdinworks6.domain.UserRole;
import com.aladdinworks6.dto.UserRoleDTO;
import com.aladdinworks6.dto.UserRoleSearchDTO;
import com.aladdinworks6.dto.UserRolePageDTO;
import com.aladdinworks6.dto.UserRoleConvertCriteriaDTO;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import com.aladdinworks6.service.UserRoleService;
import com.aladdinworks6.util.ControllerUtils;





@Service
public class UserRoleServiceImpl extends GenericServiceImpl<UserRole, Integer> implements UserRoleService {

    private final static Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

	@Autowired
	UserRoleDAO userRoleDao;

	


	@Override
	public GenericDAO<UserRole, Integer> getDAO() {
		return (GenericDAO<UserRole, Integer>) userRoleDao;
	}
	
	public List<UserRole> findAll () {
		List<UserRole> userRoles = userRoleDao.findAll();
		
		return userRoles;	
		
	}

	public ResultDTO addUserRole(UserRoleDTO userRoleDTO, RequestDTO requestDTO) {

		UserRole userRole = new UserRole();

		userRole.setUserRoleId(userRoleDTO.getUserRoleId());


		userRole.setRoleName(userRoleDTO.getRoleName());


		userRole.setPermissions(userRoleDTO.getPermissions());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		userRole = userRoleDao.save(userRole);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<UserRole> getAllUserRoles(Pageable pageable) {
		return userRoleDao.findAll(pageable);
	}

	public Page<UserRole> getAllUserRoles(Specification<UserRole> spec, Pageable pageable) {
		return userRoleDao.findAll(spec, pageable);
	}

	public ResponseEntity<UserRolePageDTO> getUserRoles(UserRoleSearchDTO userRoleSearchDTO) {
	
			Integer userRoleId = userRoleSearchDTO.getUserRoleId(); 
 			String roleName = userRoleSearchDTO.getRoleName(); 
 			String permissions = userRoleSearchDTO.getPermissions(); 
 			String sortBy = userRoleSearchDTO.getSortBy();
			String sortOrder = userRoleSearchDTO.getSortOrder();
			String searchQuery = userRoleSearchDTO.getSearchQuery();
			Integer page = userRoleSearchDTO.getPage();
			Integer size = userRoleSearchDTO.getSize();

	        Specification<UserRole> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, userRoleId, "userRoleId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, roleName, "roleName"); 
			
			spec = ControllerUtils.andIfNecessary(spec, permissions, "permissions"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("roleName")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("permissions")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<UserRole> userRoles = this.getAllUserRoles(spec, pageable);
		
		//System.out.println(String.valueOf(userRoles.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(userRoles.getTotalPages()));
		
		List<UserRole> userRolesList = userRoles.getContent();
		
		UserRoleConvertCriteriaDTO convertCriteria = new UserRoleConvertCriteriaDTO();
		List<UserRoleDTO> userRoleDTOs = this.convertUserRolesToUserRoleDTOs(userRolesList,convertCriteria);
		
		UserRolePageDTO userRolePageDTO = new UserRolePageDTO();
		userRolePageDTO.setUserRoles(userRoleDTOs);
		userRolePageDTO.setTotalElements(userRoles.getTotalElements());
		return ResponseEntity.ok(userRolePageDTO);
	}

	public List<UserRoleDTO> convertUserRolesToUserRoleDTOs(List<UserRole> userRoles, UserRoleConvertCriteriaDTO convertCriteria) {
		
		List<UserRoleDTO> userRoleDTOs = new ArrayList<UserRoleDTO>();
		
		for (UserRole userRole : userRoles) {
			userRoleDTOs.add(convertUserRoleToUserRoleDTO(userRole,convertCriteria));
		}
		
		return userRoleDTOs;

	}
	
	public UserRoleDTO convertUserRoleToUserRoleDTO(UserRole userRole, UserRoleConvertCriteriaDTO convertCriteria) {
		
		UserRoleDTO userRoleDTO = new UserRoleDTO();
		
		userRoleDTO.setUserRoleId(userRole.getUserRoleId());

	
		userRoleDTO.setRoleName(userRole.getRoleName());

	
		userRoleDTO.setPermissions(userRole.getPermissions());

	

		
		return userRoleDTO;
	}

	public ResultDTO updateUserRole(UserRoleDTO userRoleDTO, RequestDTO requestDTO) {
		
		UserRole userRole = userRoleDao.getById(userRoleDTO.getUserRoleId());

		userRole.setUserRoleId(ControllerUtils.setValue(userRole.getUserRoleId(), userRoleDTO.getUserRoleId()));

		userRole.setRoleName(ControllerUtils.setValue(userRole.getRoleName(), userRoleDTO.getRoleName()));

		userRole.setPermissions(ControllerUtils.setValue(userRole.getPermissions(), userRoleDTO.getPermissions()));



        userRole = userRoleDao.save(userRole);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public UserRoleDTO getUserRoleDTOById(Integer userRoleId) {
	
		UserRole userRole = userRoleDao.getById(userRoleId);
			
		
		UserRoleConvertCriteriaDTO convertCriteria = new UserRoleConvertCriteriaDTO();
		return(this.convertUserRoleToUserRoleDTO(userRole,convertCriteria));
	}







}
