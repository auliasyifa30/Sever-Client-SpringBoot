package mii.co.id.clientappmcc.controllers;

import mii.co.id.clientappmcc.models.AuthRequest;
import mii.co.id.clientappmcc.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        if (!(authent instanceof AnonymousAuthenticationToken)) {
            /* The user is logged in :) */
            return "redirect:/admin/dashboard";
        }

        AuthRequest auth = new AuthRequest();
        model.addAttribute("auth", auth);
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute("auth") AuthRequest auth) {
        String redirectURL = "";

        if (authService.loginProcess(auth)) {
            redirectURL = "redirect:/admin/dashboard";
        } else {
            redirectURL = "redirect:/login?error";
        }
        return redirectURL;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

}
