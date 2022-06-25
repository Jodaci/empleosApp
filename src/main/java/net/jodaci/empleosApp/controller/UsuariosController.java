package net.jodaci.empleosApp.controller;

import net.jodaci.empleosApp.model.Usuario;
import net.jodaci.empleosApp.model.Vacante;
import net.jodaci.empleosApp.service.iUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    iUsuariosService serviceUsuario;

    @GetMapping("/index")
    public String mostrarIndex(Model model){
        List<Usuario> lista = serviceUsuario.buscarTodos();
        model.addAttribute("usuarios",lista);
        return "usuarios/listUsuarios";
    }

    @GetMapping("/delete/{id}")
    public  String eliminar(@PathVariable("id") int idusuario, RedirectAttributes attributes){
        serviceUsuario.eliminar(idusuario);
        attributes.addFlashAttribute("msg","El usuario fue eliminado");
        return "redirect:/usuarios/index";
    }
}
