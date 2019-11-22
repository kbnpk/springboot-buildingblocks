/*
 * package com.stacksimply.restservices.controllers;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import javax.validation.constraints.Min; import static
 * org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo; import static
 * org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
 * import org.springframework.http.HttpStatus; import
 * org.springframework.validation.annotation.Validated; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.server.ResponseStatusException;
 * 
 * import com.stacksimply.restservices.entities.User; import
 * com.stacksimply.restservices.exceptions.UserNotFoundException; import
 * com.stacksimply.restservices.repositories.UserRepository; import
 * com.stacksimply.restservices.services.UserService;
 * 
 * @RestController
 * 
 * @RequestMapping(value="/hateoas/users")
 * 
 * @Validated public class UserHateoasController {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Autowired private UserService userService;
 * 
 * @GetMapping public List<User> getAllUsers(){ return
 * userService.getAllUsers(); }
 * 
 * @GetMapping("/{id}") public Optional<User>
 * getUserById(@PathVariable("id") @Min(1) long id){
 * 
 * try { Optional<User> userOptional =userService.getUserById(id); User user =
 * userOptional.get(); Long userid = user.getId();
 * user.add(linkTo(methodOn(UserHateoasController.class)
 * .getCustomer(user.getId())) .withSelfRel());
 * 
 * } catch (UserNotFoundException e) { throw new
 * ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage()); }
 * 
 * }
 * 
 * 
 * }
 */
