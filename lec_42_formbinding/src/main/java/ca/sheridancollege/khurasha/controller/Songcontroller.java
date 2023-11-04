package ca.sheridancollege.khurasha.controller;
import ca.sheridancollege.khurasha.beans.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class Songcontroller {
	
    List<Song> songlist = new CopyOnWriteArrayList<Song>();
    
  @GetMapping("/")
   public String index (Model model)
   {
	  model.addAttribute("song",new Song());
      model.addAttribute("songlist", songlist);
	  return "index";
   }
	
  @PostMapping("/addsong")
	public String addSong(Model model, @ModelAttribute Song song)
	{
	  songlist.add(song);
	  model.addAttribute("song",new Song());
      model.addAttribute("songlist", songlist);
      return "index";
	}
}
