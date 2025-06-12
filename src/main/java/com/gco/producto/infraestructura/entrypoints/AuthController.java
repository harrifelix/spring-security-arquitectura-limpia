package com.gco.producto.infraestructura.entrypoints;


import com.gco.producto.dominio.usecase.security.DetalleUsuarioUseCase;
import com.gco.producto.infraestructura.security.payload.AutenticacionLogin;
import com.gco.producto.infraestructura.security.payload.AutenticacionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import com.gco.producto.dominio.gateway.*;
import com.gco.producto.infraestructura.security.utils.*;
import  com.gco.producto.infraestructura.adapters.entidad.*;
import  java.util.*;
import  com.gco.producto.infraestructura.security.payload.*;
import org.springframework.security.core.GrantedAuthority;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AuthController {

    /* ~ Autowired
    ------------------------------------------------------------------------------- */
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private DetalleUsuarioUseCase detalleUsuarioUseCase;
    @Autowired
    private JwtUtil jwtUtil;


    /* ~ Rutas publicas
    ------------------------------------------------------------------------------- */
    @GetMapping("/public")
    @CrossOrigin("*")
    public String homePublic(){
        return "Pagina de inicio al publico";
    } // fin de la peticion

    @PostMapping("/registrarse")
    @CrossOrigin("*")
    public ResponseEntity<?> registrarse(@RequestBody Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Asignar role de user
        Role role = roleService.buscarRolePorId(3);
        usuario.agregarRoleALista(role);
        usuario.setActivo(true);
        usuarioService.guardarUsuario(usuario);

        return ResponseEntity.ok("Usuario registrado correctamente");
    } // fin de la pagina de registro

    @PostMapping("/logout")
    @CrossOrigin("*")
    public ResponseEntity<?> logout(@RequestBody Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Asignar role de user
        Role role = roleService.buscarRolePorId(3);
        usuario.agregarRoleALista(role);
        usuario.setActivo(true);
        usuarioService.guardarUsuario(usuario);

        return ResponseEntity.ok("Usuario registrado correctamente");
    } // fin de la pagina de registro


    @PostMapping("/iniciar")
    @CrossOrigin("*")
    public ResponseEntity<?> iniciarSesion(@RequestBody AutenticacionLogin autLogin) throws Exception {
        //autLogin.getPassword();
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(autLogin.getUsername(), autLogin.getPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("Error en el username o contraseña " + ex.getMessage());
        } // fin de try~catch

        // Obtenemos los datos del usuario de la BD para construir el token
        final UserDetails userDetails = detalleUsuarioUseCase.loadUserByUsername(autLogin.getUsername());
        final String token = jwtUtil.creatToken(userDetails);

        List<GrantedAuthority> authorities = new ArrayList<>();

            // Extract list of permissions (name)
        for (GrantedAuthority autenticacionRoles:userDetails.getAuthorities()) {
            AutenticacionRoles autenticacionRol = new AutenticacionRoles();
            autenticacionRol.setRol(autenticacionRoles.getAuthority());
            authorities.add(autenticacionRoles);
        }

        // Regresamos el token
        return ResponseEntity.ok(new AutenticacionResponse(token,
                userDetails.getUsername(),
                authorities));
    } // fin para iniciar sesion


    /* ~ Rutas privadas (requieren token)
    ------------------------------------------------------------------------------- */
    @GetMapping("/home")
    @CrossOrigin("*")
    public String userAuthenticated(){
        return "Welcome";
    }

} // fin del controlador home
