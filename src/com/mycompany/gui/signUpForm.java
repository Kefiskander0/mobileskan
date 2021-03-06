package com.mycompany.gui;

import java.util.Vector;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycomany.services.UserService;

public class signUpForm extends BaseForm{
	
	   public signUpForm(Resources res) {
	        super(new BorderLayout());
	        Toolbar tb = new Toolbar(true);
	        setToolbar(tb);
	        tb.setUIID("Container");
	        getTitleArea().setUIID("Container");
	        Form previous = Display.getInstance().getCurrent();
	        tb.setBackCommand("", e -> previous.showBack());
	        setUIID("SignIn");
	                
	        TextField name = new TextField("", "Name", 20, TextField.ANY);
	        TextField prenom = new TextField("", "Prenom", 20, TextField.ANY);
	        TextField adresse = new TextField("", "Adresse", 20, TextField.ANY);
	        TextField numTel = new TextField("", "N° téléphone", 20, TextField.ANY);
	        TextField whoami = new TextField("", "Qui êtes-vous?", 20, TextField.ANY);
	        TextField password = new TextField("", "Mot de passe", 20, TextField.PASSWORD);
	        TextField confirmpassword = new TextField("", "Mot de passe", 20, TextField.PASSWORD);
	        TextField mailAdress = new TextField("", "@MAIL", 20, TextField.EMAILADDR);

	        
	          		
    		
	           //Role 
	        //Vector 3ibara ala array 7atit fiha roles ta3na ba3d nzidouhom lel comboBox
//	        Vector<String> vectorRole;
//	        vectorRole = new Vector();
//	        
//	        vectorRole.add("Client");
//	        vectorRole.add("Responsable");
//	        
	      //  ComboBox<String>roles = new ComboBox<>(vectorRole);
	        
	        
	        
	        
	        name.setSingleLineTextArea(false);
	        prenom.setSingleLineTextArea(false);
	        password.setSingleLineTextArea(false);
	        confirmpassword.setSingleLineTextArea(false);
	        whoami.setSingleLineTextArea(false);
	        numTel.setSingleLineTextArea(false);
	        mailAdress.setSingleLineTextArea(false);
	        adresse.setSingleLineTextArea(false);

	        confirmpassword.setSingleLineTextArea(false);
	        Button next = new Button("SignUp");
	        Button signIn = new Button("Sign In");
	        signIn.addActionListener(e -> new SignInForm(res).show());
	        signIn.setUIID("Link");
	        Label alreadHaveAnAccount = new Label("Already have an account?");
	        
	        Container content = BoxLayout.encloseY(
	                new Label("Sign Up", "LogoLabel"),
	                new FloatingHint(name),
	                createLineSeparator(),
	                new FloatingHint(prenom),
	                createLineSeparator(),
	                new FloatingHint(adresse),	     
	                new FloatingHint(numTel),
	                createLineSeparator(),
	                new FloatingHint(confirmpassword),
	                createLineSeparator(),
	                new FloatingHint(password),
	                createLineSeparator(),
	                new FloatingHint(mailAdress),
	                createLineSeparator(),
	                new FloatingHint(whoami),
	                createLineSeparator()
	              //  roles//sinon y7otich role fi form ta3 signup
	        );
	        content.setScrollableY(true);
	        add(BorderLayout.CENTER, content);
	        add(BorderLayout.SOUTH, BoxLayout.encloseY(
	                next,
	                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
	        ));
	        next.requestFocus();
	        next.addActionListener((e) -> {
	            
	        	
	        
	        	
				UserService.getInstance().signup(name, prenom, adresse, numTel, password, mailAdress, whoami, res);
	            Dialog.show("Success","account is saved","OK",null);
	            new SignInForm(res).show();
	        });
	        }

}
