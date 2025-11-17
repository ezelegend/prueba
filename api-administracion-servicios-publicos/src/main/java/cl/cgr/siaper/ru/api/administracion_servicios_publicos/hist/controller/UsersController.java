package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Usuario;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository.UsersInterfaceRepository;
//import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {

	private static final Logger log = LoggerFactory.getLogger(UsersController.class);

	//    @Autowired
	//    private UsersRepository usersRepository;

	@Autowired
	private UsersInterfaceRepository usersInterfaceRepository;


	private static final Set<String> SORTABLE = Set.of(
			"id", "run", "nombre", "apellido1", "apellido2", "codigo", "version"
			);

	@GetMapping("/getListUsersPageable")
	public PagedResponse<Usuario> getListUsersPageable(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(required = false) String sort,
			@RequestParam(required = false) String search
			) {
		int zeroBased = Math.max(page - 1, 0);

		Sort s = Sort.unsorted();
		if (sort != null && !sort.isBlank()) {
			String[] parts = sort.split(",");
			String field = parts[0].trim();
			if (SORTABLE.contains(field)) {
				Sort.Direction dir = (parts.length > 1 && "desc".equalsIgnoreCase(parts[1]))
						? Sort.Direction.DESC : Sort.Direction.ASC;
				s = Sort.by(dir, field);
			}
		}

		Pageable pageable = PageRequest.of(zeroBased, size, s);

		Page<Usuario> p = (search == null || search.isBlank())
				? usersInterfaceRepository.getListUsersPageable(pageable)
						: usersInterfaceRepository.getListUsersPageable(search.trim(), pageable);

		return new PagedResponse<>(
				p.getContent(),
				p.getTotalElements(),
				p.getTotalPages(),
				zeroBased + 1,
				p.getSize()
				);
	}


	@GetMapping("/getListUsersNoActivePageable")
	public PagedResponse<Usuario> getListUsersNoActivePageable(
			@RequestParam(defaultValue = "1") int page, 
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(required = false) String sort,
			@RequestParam(required = false) String search
			) {
		int zeroBased = Math.max(page - 1, 0);

		Sort s = Sort.unsorted();
		if (sort != null && !sort.isBlank()) {
			String[] parts = sort.split(",");
			String field = parts[0].trim();
			if (SORTABLE.contains(field)) {
				Sort.Direction dir = (parts.length > 1 && "desc".equalsIgnoreCase(parts[1]))
						? Sort.Direction.DESC : Sort.Direction.ASC;
				s = Sort.by(dir, field);
			}
		}

		Pageable pageable = PageRequest.of(zeroBased, size, s);

		Page<Usuario> p = (search == null || search.isBlank())
				? usersInterfaceRepository.getListUsersNoActivePageable(pageable)
						: usersInterfaceRepository.getListUsersNoActivePageable(search.trim(), pageable);

		return new PagedResponse<>(
				p.getContent(),
				p.getTotalElements(),
				p.getTotalPages(),
				zeroBased + 1,
				p.getSize()
				);
	}

}
