package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.x500.X500Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;

import ch.qos.logback.core.joran.conditional.IfAction;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding.Verifier;
import tn.esprit.spring.entity.RendezVous;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.service.EmailSenderService;
import tn.esprit.spring.service.RendezVousServiceImpl;
import tn.esprit.spring.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/RendezVous")
public class RendezVousController {
	@Autowired
	RendezVousServiceImpl impl;
	@Autowired
	UserService userImpl;
	@Autowired
	EmailSenderService emailSender;
	Utilisateur user ;
	@GetMapping(value = "/retrieves-all-RendezVous")
	public List<RendezVous> getRendezVous() {

		List<RendezVous> list = impl.retreiveAllRendezVous();
		System.out.print("lists RendezVous" + list);
		return list;
	}

	@GetMapping(value = "/retrieves-RendezVous-by-id/{id}")
	public Optional<RendezVous> getRendezVousById(@PathVariable("id") Long id) {

		return impl.getRendezVousById(id);
	}

	@PostMapping(value = "/save-update-RendezVous")	
	public String addOrUpdateRendezVous(@RequestBody RendezVous rclm) throws Exception {
		System.out.print("new RendezVous" + rclm);
		if (this.verifierinviter(rclm) == Boolean.TRUE) {
			RendezVous rendezVous =impl.addOrUpdateRendezVous(rclm);
			emailSender.sendSimpleEmail(rclm.getInviter().getEmail(), rclm.getObjet()+" avec "+rclm.getCreateur().getNom(), 
					"vous avez un rendez vous"+rclm.getType()+" avec "+rclm.getCreateur().getNom()+" "+rclm.getCreateur().getPrenom()+"\n"
					+"de "+rclm.getDateDebut()+" à "+rclm.getDateFin()+"\n"
					+"Description:\n"+rclm.getDescription()+"\n"
					+"vous pouvez le contacter avec Email: "+rclm.getCreateur().getEmail()+"\n"
					+"ou par telephone: "+rclm.getCreateur().getTelephone());
			return "rendez-vous créer avec succé ";
			
		} else {
			return "Inviter n'est pas dispo";

		}

	}
	
	@DeleteMapping(value = "/delete-RendezVous/{id}")
	public void deleteRendezVous(@PathVariable("id") Long id) {
		impl.deleteRendezVous(id);

	}

	public boolean verifierinviter(RendezVous data) {
		
		Utilisateur inviter = data.getInviter();
		System.out.println("=============>>>>"+data.getInviter());
		this.user = userImpl.getUtilisateurById(inviter.getId());
		if (this.user.getRendezvous().size() > 0) {
			for (RendezVous ren : this.user.getRendezvous()) {
				if (ren.getDateDebut().after(data.getDateFin()) || ren.getDateFin().before(data.getDateDebut())) {
					return Boolean.TRUE;
				}else {
					return Boolean.FALSE;
				}
			}

		}
			return Boolean.TRUE;
		
		

	}
}
